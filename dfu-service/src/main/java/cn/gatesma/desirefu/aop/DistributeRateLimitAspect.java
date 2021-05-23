package cn.gatesma.desirefu.aop;

import cn.gatesma.desirefu.annotation.DistributedRateLimit;
import cn.gatesma.desirefu.config.cache.RedisClient;
import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Aspect
@Component
public class DistributeRateLimitAspect {

    @Resource
    private RedisClient redisClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(DistributeRateLimitAspect.class);

    /**
     * lua 脚本
     */
    private static final String lua =
            "local key = \"rate.limit.\" .. KEYS[1] .. ARGV[3]\n" +  //限流key
                    "local limit = tonumber(ARGV[1])\n" +  //限流阈值
                    "local unitSeconds = tonumber(ARGV[2])\n" +  //限流时间
                    "local current = tonumber(redis.call(\"incr\", key))\n" +
                    "if (current == 1) then\n" +
                    "     redis.call(\"expire\", key, unitSeconds)\n" +
                    "elseif current > limit then \n" +
                    "     local ttl = redis.call(\"ttl\", key) \n" +  //防止出现某次redis.call失败，造成的key无法过期的情况
                    "     if (ttl > unitSeconds  or ttl == -1) then \n" +
                    "        redis.call(\"del\", key) \n" +   // 如果key的ttl大于限流时间，或者根本没设置过期时间，直接删除，防止对后面的限流产生影响
                    "     end\n" +
                    "     return -1\n" +
                    "end\n" +
                    "return current";

    @Pointcut("@annotation(cn.gatesma.desirefu.annotation.DistributedRateLimit)")
    public void rateLimitPoint() {
    }

    @Before("rateLimitPoint()&&@annotation(rateLimit)")
    public void doBefore(JoinPoint joinPoint, DistributedRateLimit rateLimit) throws Throwable {
        List<String> keys = Collections.singletonList(rateLimit.keyOfConfigCenter());
        long time = System.currentTimeMillis();

        // 限流均为代码内部传递的参数，这里不会有异常
        String client = (String) joinPoint.getArgs()[0];
        int rate = (int) joinPoint.getArgs()[1];

        Long curCount = 0L;
        try {
            DefaultRedisScript<Long> script = new DefaultRedisScript<>(lua,Long.class);
            curCount = redisClient.execute(script, keys, String.valueOf(rate), String.valueOf(rateLimit.unitSeconds()),
                    client);
        } catch (Exception e) {
            LOGGER.error("DistributeRateLimitAspect redis eval error,  key = {}", rateLimit.keyOfConfigCenter(),e);
        }

        if (curCount != null && curCount == -1) {
            LOGGER.info("DistributeRateLimitAspect key = {}, set rate = {}, now rate is limited!", rateLimit.keyOfConfigCenter(), rate);
            throw new CustomerApiException(ApiReturnCode.RATE_LIMIT, rateLimit.noticeMsg());
        }

        if (curCount != null) {
            LOGGER.info("DistributeRateLimitAspect key = {}, set rate = {}, now request times = {}", rateLimit.keyOfConfigCenter(), rate, curCount);
        } else {
            LOGGER.error("限流策略失效，从缓存中获取当前总请求数量失败,请求已继续执行");
        }
    }
}