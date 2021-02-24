package cn.gatesma.desirefu.config.db;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.RenderNameStyle;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.scheduling.annotation.Scheduled;

import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.sql.DataSource;
import java.lang.management.ManagementFactory;

/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc: 数据库配置
 */
@Configuration
public class JooqConfiguration {

//    private static HikariPoolMXBean proxy;

    private static final Logger LOGGER = LoggerFactory.getLogger(JooqConfiguration.class);

    @Bean
    @Scope(scopeName = "singleton")
    @ConfigurationProperties(prefix = "spring.datasource.dfu")
    public DataSource dataSource() {
        return new HikariDataSource();
    }

    @Bean
    @Scope(scopeName = "singleton")
    public DSLContext dslContext() {
        DSLContext context = new DefaultDSLContext(jooqConfig());
        context.settings().setRenderNameStyle(RenderNameStyle.AS_IS);
        return context;
    }

//    @Scheduled(cron = "0/1 * * * * *")
//    public void monitor() {
//        try {
//            if (null == proxy) {
//                MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
//                ObjectName poolName = new ObjectName("com.zaxxer.hikari:type=Pool (hikariCP_dfu)");
//                proxy = JMX.newMXBeanProxy(mBeanServer, poolName, HikariPoolMXBean.class);
//            } else {
//                LOGGER.info("{}, {}, {}, {}", proxy.getTotalConnections(), proxy.getActiveConnections(), proxy.getIdleConnections(), proxy.getThreadsAwaitingConnection());
//            }
//        } catch (Throwable cause) {
//            LOGGER.error("", cause);
//        }
//    }

//    @Scheduled(fixedRate = 1000)
//    public void HikariMonitor() {
//        HikariDataSource hikariDataSource = (HikariDataSource) dataSource();
//        hikariDataSource.getHikariPoolMXBean();
//        if(poolProxy == null) {
//            LOGGER.info("Hikari not initialized,please wait...");
//        }else {
//            LOGGER.info("HikariPoolState = "
//                    + "Active=[" + String.valueOf(poolProxy.getActiveConnections() + "] "
//                    + "Idle=[" + String.valueOf(poolProxy.getIdleConnections() + "] "
//                    + "Wait=["+poolProxy.getThreadsAwaitingConnection()+"] "
//                    + "Total=["+poolProxy.getTotalConnections()+"]")));
//        }
//
//    }


    @Bean
    public ConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource()));
    }

    @Bean
    @Scope(scopeName = "singleton")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public org.jooq.Configuration jooqConfig() {
        return new DefaultConfiguration()
                .set(connectionProvider())
                .set(new SpringTransactionProvider(transactionManager()))
                .set(new DefaultExecuteListenerProvider(new ExceptionTranslator()))
                .set(SQLDialect.MYSQL);
    }




}
