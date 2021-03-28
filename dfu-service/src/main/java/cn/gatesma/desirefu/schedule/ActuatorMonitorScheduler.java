package cn.gatesma.desirefu.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Map;
import java.util.Objects;

/**
 * User: gatesma
 * Date: 2021/3/26 2:30 下午
 * Desc: 打印tomcat当前的队列、线程池等信息
 */
@Component
public class ActuatorMonitorScheduler {

    private static final Logger logger = LoggerFactory.getLogger(ActuatorMonitorScheduler.class);
    private static final String INTERFACE_NAME = "interface_name";
    private static final String MODULE_NAME = "module_name";
    private static final String SERVER_IP = "server_ip";

    @Scheduled(cron = "0/5 * * * * ?") //每10秒执行一次
    public void metricsReport() {
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName metrics = new ObjectName("org.springframework.boot:type=Endpoint,name=metricsEndpoint");
            Map<String, Object> dataMap = (Map<String, Object>) mBeanServer.getAttribute(metrics, "Data");

            int tomcatPoolSize = dataMap.get("tomcat.threads.pool_size") == null ? -1
                    : (Integer) dataMap.get("tomcat.threads.pool_size");
            int tomcatActiveCount = dataMap.get("tomcat.threads.active_count") == null ? -1
                    : (Integer) dataMap.get("tomcat.threads.active_count");
            int tomcatQueueSize =
                    dataMap.get("tomcat.threads.queue") == null ? -1 : (Integer) dataMap.get("tomcat.threads.queue");
            int largestPoolSize =
                    dataMap.get("tomcat.threads.largest_pool_size") == null ? -1 : (Integer) dataMap.get("tomcat.threads.largest_pool_size");
            int submittedCount =
                    dataMap.get("tomcat.threads.submitted_count") == null ? -1 : (Integer) dataMap.get("tomcat.threads.submitted_count");

            // 打印日志文件
            logger.info("[poolSize={},activeCount={},queueSize={},largestPoolSize={},submittedCount={}]",
                            tomcatPoolSize, tomcatActiveCount, tomcatQueueSize,largestPoolSize,submittedCount);

        } catch (Exception e) {
            logger.error("occur error!", e);
        }
    }
}