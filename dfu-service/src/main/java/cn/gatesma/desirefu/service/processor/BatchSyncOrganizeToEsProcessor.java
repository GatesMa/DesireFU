package cn.gatesma.desirefu.service.processor;

import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Normalaccount_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organize_Record;
import cn.gatesma.desirefu.repository.NormalAccountRepository;
import cn.gatesma.desirefu.repository.OrganizeRepository;
import cn.gatesma.desirefu.service.EsService;
import cn.gatesma.desirefu.service.NormalAccountService;
import cn.gatesma.desirefu.service.OrganizeService;
import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

@Component
public class BatchSyncOrganizeToEsProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchSyncOrganizeToEsProcessor.class);

    private static RateLimiter rateLimiter = RateLimiter.create(20.0);// 单机限速，每秒最多往es写入20个。

    @Autowired
    private ThreadPoolExecutor batchSyncPoolExecutor;

    @Resource
    private OrganizeService organizeService;

    @Resource
    private OrganizeRepository organizeRepository;

    public void syncSubOrganizeToEs(List<Long> organizeIdList) {
        if (CollectionUtils.isEmpty(organizeIdList)) {
            return;
        }

        LOGGER.info("syncSubOrganizeToEs start");

        for (Long organizeId : organizeIdList) {
            rateLimiter.acquire();
            LOGGER.info("syncSubOrganizeToEs now is handing organizeId id = {}", organizeId);
            batchSyncPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    organizeService.syncOrganize(organizeId);
                }
            });
        }

        LOGGER.info("syncSubOrganizeToEs end");
    }

    /**
     * 同步现有的队伍列表
     */
    public void syncAllOrganizeToEs() {
        LOGGER.info("syncAllOrganizeToEs start");

        List<Organize_Record> records = organizeRepository.queryOrganize(null, null, null);

        List<Long> organizeIds = records.stream().map(Organize_Record::getOrganizeid).collect(Collectors.toList());

        if (CollectionUtils.isEmpty(organizeIds)) {
            return;
        }

        for (Long organizeId : organizeIds) {
            rateLimiter.acquire();

            LOGGER.info("now is handing organizeId uid = {}", organizeId);

            batchSyncPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    organizeService.syncOrganize(organizeId);
                }
            });
        }
        LOGGER.info("syncAllOrganizeToEs end");
    }


}
