package cn.gatesma.desirefu.schedule;

import cn.gatesma.desirefu.repository.NormalAccountRepository;
import cn.gatesma.desirefu.service.processor.BatchSyncAccountToEsProcessor;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * User: gatesma
 * Date: 2021/4/9 11:03 上午
 * Desc: 同步最近修改的账号到ES
 */
@Component
public class SyncESUpdateSchedule {

    @Resource
    private NormalAccountRepository normalAccountRepository;

    @Resource
    private BatchSyncAccountToEsProcessor syncAccountToEsProcessor;

//    @Scheduled(cron = "0 0 20 * * ?") //每天晚上8点执行
//    public void syncEditData() {
//
//        // 获取最近一天被修改的账号
//        Date to = new Date();
//        Date from = TimeUtils.getSomeDay(to, -1);
//
//        Timestamp start = new Timestamp(from.getTime());
//        Timestamp end = new Timestamp(to.getTime());
//
//        List<Long> accountIdList = normalAccountRepository.getRecentUpdateAccountIdList(start, end);
//
//        // 调用Processor处理这些ID
//        syncAccountToEsProcessor.syncSubAccountToEs(accountIdList);
//
//    }

}
