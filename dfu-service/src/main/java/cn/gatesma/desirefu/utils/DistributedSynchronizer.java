package cn.gatesma.desirefu.utils;

import cn.gatesma.desirefu.config.cache.RedisClient;
import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * User: gatesma
 * Date: 2020-11-13
 * Desc: 分布式锁
 */
@Component
public class DistributedSynchronizer {

    private static final Logger logger = LoggerFactory.getLogger(DistributedSynchronizer.class);

    @Resource
    private RedisClient redisClient;

    //同步方法 分布式锁
    public <V> V synchronize(String lockName, int expireAfterMilSec, Callable<V> callable) {
        long threadId = Thread.currentThread().getId();
        long timestamp = System.currentTimeMillis();
        long expireTime = timestamp + expireAfterMilSec;
        String lockValue = timestamp + "_" + threadId;
        V result = null;
        try {
            while (true) {
                // try lock
                if (redisClient.putIfNotExists(lockName, lockValue, expireAfterMilSec)) {
                    result = callable.call();
                    break;
                }
                // expire
                if (System.currentTimeMillis() > expireTime) {
                    break;
                }
            }
        } catch (CustomerApiException e) {
            logger.error("customer api exception!", e);
            throw e;
        } catch (Throwable e) {
            logger.error("unexpected exception!", e);
            throw new CustomerApiException(ApiReturnCode.INNER_ERROR, e.getMessage() == null ? e.toString() : e.getMessage());
        } finally {
            // release lock
            String curLockVal = redisClient.get(lockName);
            // avoid to delete another lock
            if (lockValue.equals(curLockVal)) {
                redisClient.del(lockName);
            }
        }
        return result;
    }

    public <V> V synchronizeByAccount(long accountId, int accountType, int expireAfterMilSec, Callable<V> callable) {
        String lockName = accountId + "_" + accountType;
        return synchronize(lockName, expireAfterMilSec, callable);
    }
}