package cn.gatesma.desirefu.config.cache;

import cn.gatesma.desirefu.domain.config.RedisProperties;
import com.google.common.collect.Sets;
import com.google.common.net.HostAndPort;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.HashSet;

/**
 * User: gatesma
 * Date: 2020-11-12
 * Desc:
 */
public class ConnectionFactoryBuilder {

    private RedisProperties properties;

    /**
     * 根据不同的配置文件配置，生成不同的JedisConnectionFactory
     */
    public JedisConnectionFactory build() {
        JedisConnectionFactory jedisConnectionFactory = null;
        if (isSentinelConfig()) {
            jedisConnectionFactory = sentinelConnectionFactory();
        } else if (isIpAndPortConfig()) {
            jedisConnectionFactory = standardConnectionFactory();
        } else {
            throw new RuntimeException("ckv config error!");
        }
        jedisConnectionFactory.setPassword(properties.getPassword());
        jedisConnectionFactory.setTimeout(properties.getTimeout());
        jedisConnectionFactory.setPoolConfig(properties);
        return jedisConnectionFactory;
    }

    /**
     * 配置集群
     */
    private boolean isSentinelConfig() {
        return properties != null &&
                properties.getSentinel() != null &&
                StringUtils.isNotBlank(properties.getSentinel().getMaster()) &&
                StringUtils.isNotBlank(properties.getSentinel().getIpAndPorts());
    }

    /**
     * 配置单机服务器
     */
    private boolean isIpAndPortConfig() {
        return properties != null &&
                StringUtils.isNotBlank(properties.getHostName()) &&
                properties.getPort() != null;
    }

    /**
     * 创建"哨兵"连接工厂
     *
     * @return 连接工厂
     */
    private JedisConnectionFactory sentinelConnectionFactory() {
        String master = properties.getSentinel().getMaster();
        String ipAndPorts = properties.getSentinel().getIpAndPorts();
        HashSet<String> ipAndPortSet = Sets.newHashSet(ipAndPorts.split(";"));
        return new JedisConnectionFactory(new RedisSentinelConfiguration(master, ipAndPortSet));
    }

    /**
     * 创建标准的IP、Port连接工厂
     *
     * @return 连接工厂
     */
    private JedisConnectionFactory standardConnectionFactory() {
        // 创建连接工厂
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(properties.getHostName());
        jedisConnectionFactory.setPort(properties.getPort());
        return jedisConnectionFactory;
    }

    public RedisProperties getProperties() {
        return properties;
    }

    public ConnectionFactoryBuilder setProperties(RedisProperties properties) {
        this.properties = properties;
        return this;
    }
}
