package cn.gatesma.desirefu.domain.config;

import redis.clients.jedis.JedisPoolConfig;

/**
 * User: gatesma
 * Date: 2020-11-12
 * Desc: Redis配置类
 */
public class RedisProperties extends JedisPoolConfig {

    private String password;
    private Integer timeout;
    private String hostName;
    private Integer port;
    private SentinelProperties sentinel;

    public static class SentinelProperties {

        private String master;
        private String ipAndPorts;

        public String getMaster() {
            return master;
        }

        public void setMaster(String master) {
            this.master = master;
        }

        public String getIpAndPorts() {
            return ipAndPorts;
        }

        public void setIpAndPorts(String ipAndPorts) {
            this.ipAndPorts = ipAndPorts;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public SentinelProperties getSentinel() {
        return sentinel;
    }

    public void setSentinel(SentinelProperties sentinel) {
        this.sentinel = sentinel;
    }
}
