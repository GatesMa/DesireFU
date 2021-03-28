package cn.gatesma.desirefu.config.monitor;

/**
 * User: gatesma
 * Date: 2021/3/26 2:30 下午
 * Desc:
 */

import org.apache.catalina.connector.Connector;
import org.apache.coyote.ProtocolHandler;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 收集tomcat相关的参数
 */
public class AdvancedTomcatMetrics implements PublicMetrics, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public Collection<Metric<?>> metrics() {
        if (this.applicationContext instanceof EmbeddedWebApplicationContext) {
            EmbeddedServletContainer embeddedServletContainer = ((EmbeddedWebApplicationContext) applicationContext)
                .getEmbeddedServletContainer();
            if (embeddedServletContainer instanceof TomcatEmbeddedServletContainer) {
                // 获取监控的资源
                Connector connector = ((TomcatEmbeddedServletContainer) embeddedServletContainer).getTomcat()
                    .getConnector();
                ProtocolHandler handler = connector.getProtocolHandler();
                ThreadPoolExecutor executor = (ThreadPoolExecutor) handler.getExecutor();
                // 注册监控指标
                List<Metric<?>> metrics = new ArrayList<Metric<?>>();
                metrics.add(new Metric<Integer>("tomcat.threads.pool_size", executor.getPoolSize()));
                metrics.add(new Metric<Integer>("tomcat.threads.active_count", executor.getActiveCount()));
                metrics.add(new Metric<Integer>("tomcat.threads.largest_pool_size", executor.getLargestPoolSize()));
                metrics.add(new Metric<Integer>("tomcat.threads.queue", executor.getQueue().size()));
                metrics.add(new Metric<Long>("tomcat.threads.task_count", executor.getTaskCount()));
                metrics.add(new Metric<Integer>("tomcat.threads.submitted_count", executor.getSubmittedCount()));
                metrics.add(new Metric<Long>("tomcat.threads.completed_task_count", executor.getCompletedTaskCount()));
                // 返回监控指标
                return metrics;
            }
        }
        return Collections.emptySet();
    }
}
