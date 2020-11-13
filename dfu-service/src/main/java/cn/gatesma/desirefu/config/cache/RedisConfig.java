package cn.gatesma.desirefu.config.cache;

import cn.gatesma.desirefu.domain.config.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * User: gatesma
 * Date: 2020/11/12
 * Desc: redis连接池
 */
@Configuration
public class RedisConfig {


    @Bean
    @ConfigurationProperties(prefix = "redis.server")
    public RedisProperties redisProperties() {
        return new RedisProperties();
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisCacheConnectionFactory());
        return template;
    }

    @Bean
    public JedisConnectionFactory redisCacheConnectionFactory() {
        return new ConnectionFactoryBuilder()
                .setProperties(redisProperties())
                .build();
    }


}
