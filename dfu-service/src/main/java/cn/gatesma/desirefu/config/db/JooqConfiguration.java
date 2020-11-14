package cn.gatesma.desirefu.config.db;

import com.zaxxer.hikari.HikariDataSource;
import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.RenderNameStyle;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc: 数据库配置
 */
@Configuration
public class JooqConfiguration {

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
