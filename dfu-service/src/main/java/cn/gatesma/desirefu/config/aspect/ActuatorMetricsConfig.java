package cn.gatesma.desirefu.config.aspect;

import cn.gatesma.desirefu.config.monitor.AdvancedTomcatMetrics;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

/**
 * User: gatesma
 * Date: 2021/3/26 2:30 下午
 * Desc tomcat 监控等等
 */
@Configuration
public class ActuatorMetricsConfig {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass({Servlet.class, Tomcat.class})
    @ConditionalOnWebApplication
    public AdvancedTomcatMetrics advancedTomcatMetrics() {
        return new AdvancedTomcatMetrics();
    }
}
