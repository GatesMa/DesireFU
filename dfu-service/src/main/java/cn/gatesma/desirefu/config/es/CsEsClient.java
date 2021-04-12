package cn.gatesma.desirefu.config.es;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.config.EsConfig;
import cn.gatesma.desirefu.service.EsService;
import com.google.common.net.HostAndPort;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class CsEsClient {

    private Logger LOGGER = LoggerFactory.getLogger(CsEsClient.class);

    @Bean
    @Scope(scopeName = "singleton")
    public Client esClient() {

        // 读取ES配置
        EsConfig esConfig = esConfig();

        // 创建ES Client对象
        return createClient(esConfig);
    }

    @Bean
    @Scope(scopeName = "singleton")
    @ConfigurationProperties(prefix = "customerservice.es")
    public EsConfig esConfig() {
        return new EsConfig();
    }


    private Client createClient(EsConfig config) {

        // 参数检查
        checkParamThrown(config);

        // 配置信息
        Settings esSetting = Settings.builder()
                //集群名字
                .put("cluster.name", config.getClusterName())
                //增加嗅探机制，找到ES集群
                .put("client.transport.sniff", true)
                .build();
        //配置信息Settings自定义
        TransportClient transportClient = new PreBuiltTransportClient(esSetting);
        // 为client添加node address
        Arrays.stream(config.getServers().split(";"))
                .map(HostAndPort::fromString)
                .forEach(hostAndPort -> addTransportAddress(transportClient, hostAndPort));

        LOGGER.info("连接elasticsearch");

        return transportClient;
    }

    /**
     * 检查EsConfig内容是否齐全
     * @param config
     */
    private void checkParamThrown(EsConfig config) {
        if(config==null){
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT,"ES config is empty!");
        }
        if(StringUtils.isBlank(config.getServers())){
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT,"ES.servers is empty!");
        }
        if(StringUtils.isBlank(config.getClusterName())){
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT,"ES.clusterName is empty!");
        }
    }

    /**
     * 为Client添加Address
     * @param client
     * @param hostAndPort
     * @return
     */
    private TransportClient addTransportAddress(TransportClient client, HostAndPort hostAndPort){
        try {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(hostAndPort.getHost()), hostAndPort.getPort()));
        } catch (UnknownHostException e) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT,"ES add transport address error!");
        }
        return client;
    }


    private static class ClientClearProxy implements InvocationHandler {

        private Client realClient;

        public ClientClearProxy(Client realClient) {
            this.realClient = realClient;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 不能关闭连接
            if (!method.getName().equals("close")) {
                return method.invoke(realClient, args);
            }
            return null;
        }

    }


    public static  class Pair<K,V>{
        private K left;
        private V right;

        public K getLeft() {
            return left;
        }

        public void setLeft(K left) {
            this.left = left;
        }

        public V getRight() {
            return right;
        }

        public void setRight(V right) {
            this.right = right;
        }

        public static <K,V>  Pair of(K k,V v){
            Pair<K,V> pair = new Pair<K, V>();
            pair.left = k;
            pair.right = v;
            return pair;
        }
    }


}
