package cn.gatesma.desirefu.config.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {

    private static final int MAX_QUEUE_SIZE = 100;//不设置过大队列，防止服务重新发布时有较多任务堆积 造成等待时间长
    private static final int MAX_POOL_SIZE = 50;//线程池的最大线程数
    private static final int CORE_POOL_SIZE = 10;//线程池的核心线程数量
    private static final Long KEEP_ALIVE_TIME = 1L;//当线程数大于核心线程数时，多余的空闲线程存活的最长时间 默认单位秒
    private static final String POOL_NAME = "CsEsSync-Pool-%d";

    //批量处理线程池配置
    private static final int BATCH_SYNC_POOL_MAX_QUEUE_SIZE = 600;
    private static final int BATCH_SYNC_POOL_MAX_POOL_SIZE = 50;//线程池的最大线程数
    private static final int BATCH_SYNC_POOL_CORE_POOL_SIZE = 1;//批量任务平常不会运行，设置一个较低的核心线程数
    private static final Long BATCH_SYNC_POOL_KEEP_ALIVE_TIME = 1L;//当线程数大于核心线程数时，多余的空闲线程存活的最长时间 默认单位秒
    private static final String BATCH_SYNC_POOL_POOL_NAME = "BATCH-SYNC-Pool-%d";

    @Bean
    public ThreadPoolExecutor syncDataPoolExecutor() {
        return new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(MAX_QUEUE_SIZE),
                new ThreadFactoryBuilder().setNameFormat(POOL_NAME).build(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Bean
    public ThreadPoolExecutor batchSyncPoolExecutor() {
        return new ThreadPoolExecutor(
                BATCH_SYNC_POOL_CORE_POOL_SIZE, BATCH_SYNC_POOL_MAX_POOL_SIZE, BATCH_SYNC_POOL_KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(BATCH_SYNC_POOL_MAX_QUEUE_SIZE),
                new ThreadFactoryBuilder().setNameFormat(BATCH_SYNC_POOL_POOL_NAME).build(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
