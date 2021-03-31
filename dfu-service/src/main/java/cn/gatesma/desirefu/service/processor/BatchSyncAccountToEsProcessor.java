package cn.gatesma.desirefu.service.processor;

import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Normalaccount_Record;
import cn.gatesma.desirefu.repository.NormalAccountRepository;
import cn.gatesma.desirefu.service.EsService;
import cn.gatesma.desirefu.service.NormalAccountService;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

@Component
public class BatchSyncAccountToEsProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchSyncAccountToEsProcessor.class);

    private static RateLimiter rateLimiter = RateLimiter.create(20.0);// 单机限速，每秒最多往es写入20个。

    @Resource
    private Client csClusterEsClient;

    @Resource
    private EsService esService;

    @Autowired
    private ThreadPoolExecutor batchSyncPoolExecutor;

    @Resource
    private NormalAccountService normalAccountService;

    @Resource
    private NormalAccountRepository normalAccountRepository;

    public void syncSubAccountToEs(List<Long> accountIdList) {
        if (CollectionUtils.isEmpty(accountIdList)) {
            return;
        }

        LOGGER.info("syncSubAccountToEs start");

        for (Long accountId : accountIdList) {
            rateLimiter.acquire();
            LOGGER.info("syncSubAccountToEs now is handing account id = {}", accountId);
            batchSyncPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    normalAccountService.syncAccount(accountId);
                }
            });
        }

        LOGGER.info("syncSubAccountToEs end");
    }

    /**
     * 同步现有的account列表
     */
    public void syncAllAccountToEs() {
        LOGGER.info("syncAllAccountToEs start");

        List<Normalaccount_Record> records = normalAccountRepository.queryNormalAccount(null, null, null, null, null, null);

        List<Long> accountIds = records.stream().map(Normalaccount_Record::getAccountid).collect(Collectors.toList());

        if (CollectionUtils.isEmpty(accountIds)) {
            return;
        }

        for (Long accountId : accountIds) {
            rateLimiter.acquire();

            LOGGER.info("now is handing account uid = {}", accountId);

            batchSyncPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    normalAccountService.syncAccount(accountId);
                }
            });
        }
        LOGGER.info("syncAllAccountToEs end");
    }


}
