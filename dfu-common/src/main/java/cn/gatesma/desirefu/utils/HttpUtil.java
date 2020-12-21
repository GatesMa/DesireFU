package cn.gatesma.desirefu.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author gatesma
 * @date 2020/12/20 11:50 下午
 * @desc http client 封装
 */
public class HttpUtil {

    private final static Logger LOG = LoggerFactory.getLogger(HttpUtil.class);

    // 默认超时时间5s
    private final static int TIME_OUT_MILL = 5000;

    /**
     * requestGet
     *
     * @param url
     * @param timeout
     * @param headersMap
     * @return
     * @throws Exception
     */
    public static String requestGet(String url, int timeout, Map<String, String> headersMap) throws Exception {
        if (Strings.isNullOrEmpty(url)) {
            LOG.info("url不能为空!");
            return "";
        }

        String result = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        if (headersMap != null) {
            for (String key : headersMap.keySet()) {
                httpGet.addHeader(key, headersMap.get(key));
            }
        }

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout)
                .setConnectionRequestTimeout(timeout).build();
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response = httpclient.execute(httpGet);

        try {
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                result = EntityUtils.toString(entity, StandardCharsets.UTF_8.name());
                EntityUtils.consume(entity);
            }
        } finally {
            response.close();
            httpclient.close();
        }

        return result;
    }

    /**
     * requestGet
     *
     * @param url
     * @param timeout
     * @return
     * @throws Exception
     */
    public static String requestGet(String url, int timeout) throws Exception {
        return requestGet(url, timeout, null);
    }

    /**
     * http get请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String requestGet(String url) throws Exception {
        return requestGet(url, TIME_OUT_MILL);
    }

    /**
     * requestPost
     *
     * @param url
     * @param paramsMap
     * @param timeoutMill
     * @param headsMap
     * @return
     * @throws Exception
     */
    public static String requestPost(String url, Map<String, String> paramsMap, int timeoutMill,
                                     Map<String, String> headsMap) throws Exception {
        JSONObject jsonObject = new JSONObject();
        if (paramsMap != null) {
            for (String key : paramsMap.keySet()) {
                jsonObject.put(key, paramsMap.get(key));
            }
        }

        return requestPost(url, jsonObject, timeoutMill, headsMap);
    }

    /**
     * requestPost
     *
     * @param url
     * @param jsonParam
     * @param timeoutMill
     * @param headsMap
     * @return
     * @throws Exception
     */
    public static String requestPost(String url, JSONObject jsonParam, int timeoutMill, Map<String, String> headsMap)
            throws Exception {
        if (Strings.isNullOrEmpty(url)) {
            LOG.info("url不能为空!");
            return "";
        }

        String result = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        if (headsMap != null) {
            for (String key : headsMap.keySet()) {
                httpPost.addHeader(key, headsMap.get(key));
            }
        }

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeoutMill)
                .setSocketTimeout(timeoutMill).setConnectionRequestTimeout(timeoutMill).build();
        httpPost.setConfig(requestConfig);

        httpPost.setEntity(new StringEntity(jsonParam.toJSONString(), "UTF-8"));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                result = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
            }
        } finally {
            response.close();
            httpclient.close();
        }

        return result;
    }

    /**
     * requestPost
     *
     * @param url
     * @param paramsMap
     * @param timeoutMill
     * @return
     * @throws Exception
     */
    public static String requestPost(String url, Map<String, String> paramsMap, int timeoutMill) throws Exception {
        return requestPost(url, paramsMap, timeoutMill, null);
    }

    /**
     * http post请求
     *
     * @param url
     * @return
     */
    public static String requestPost(String url, Map<String, String> paramsMap) throws Exception {
        return requestPost(url, paramsMap, TIME_OUT_MILL);
    }

    /**
     * form表单post请求
     *
     * @param url
     * @param paramsMap
     * @param timeoutMill
     * @param headsMap
     * @return
     * @throws Exception
     */
    public static String requestPostForForm(String url, Map<String, String> paramsMap, int timeoutMill,
                                            Map<String, String> headsMap) throws Exception {
        if (Strings.isNullOrEmpty(url)) {
            LOG.info("url不能为空!");
            return "";
        }

        String result = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        if (headsMap != null) {
            for (String key : headsMap.keySet()) {
                httpPost.addHeader(key, headsMap.get(key));
            }
        }

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeoutMill)
                .setSocketTimeout(timeoutMill).setConnectionRequestTimeout(timeoutMill).build();
        httpPost.setConfig(requestConfig);

        //设置form格式post请求实体
        if (paramsMap != null && paramsMap.size() > 0) {
            List<NameValuePair> parasList = new ArrayList<>();
            Iterator<String> keys = paramsMap.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                parasList.add(new BasicNameValuePair(key, paramsMap.get(key)));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(parasList, "UTF-8"));
        }
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                result = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
            }
        } finally {
            response.close();
            httpclient.close();
        }

        return result;
    }

    /**
     * form表单post请求
     *
     * @param url
     * @param paramsMap
     * @param timeoutMill
     * @return
     * @throws Exception
     */
    public static String requestPostForForm(String url, Map<String, String> paramsMap, int timeoutMill)
            throws Exception {
        return requestPostForForm(url, paramsMap, timeoutMill, null);
    }
}