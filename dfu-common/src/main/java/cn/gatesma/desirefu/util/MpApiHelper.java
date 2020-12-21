package cn.gatesma.desirefu.util;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.Constants;
import cn.gatesma.desirefu.exception.RPCException;
import cn.gatesma.desirefu.utils.HttpUtil;
import cn.gatesma.desirefu.utils.JsonUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * @author gatesma
 * @date 2020/12/20 9:42 下午
 * @desc
 */
public class MpApiHelper {

    private static Logger log = LoggerFactory.getLogger(MpApiHelper.class);

    private static final String Domain = "api.weixin.qq.com";

    /**
     * 通过code获取微信的唯一openId
     */
    public static String genOpenIdFromCodeByAppIdAndSecret(String appId, String appSecret, String code) {


        // 生成get地址
        String url = genUrl("/sns/jscode2session", appId, appSecret, code);

        String res = "";


        // 重试三次
        for (int retryTime = 0; retryTime < Constants.retryTimes; retryTime++) {
            log.info("now retryTime = {}, url = {}", retryTime, url);
            long time = System.currentTimeMillis();
            boolean success = true;

            try {
                // 发送请求
                res = HttpUtil.requestGet(url);
                success = true;
            } catch (Exception e) {
                success = false;
                log.error("请求微信接口获取openID失败: " + e.getMessage());
                if (retryTime == Constants.retryTimes - 1) {
                    throw new RPCException(ApiReturnCode.EXTERNAL_INTERFACE_ERROR, "请求微信接口获取openID失败");
                }
            } finally {
                if (success) {
                    // TODO 监控
                } else {
                    //尝试三次后仍旧失败，才上报错误
                    if (retryTime == Constants.retryTimes - 1) {
                        // TODO 监控
                    }
                }
                log.info("request /sns/jscode2session wx api cost: {}", System.currentTimeMillis() - time);
            }
            // 如果成功就跳出
            if (success) {
                break;
            }
        }

        JSONObject json = JsonUtil.getJsonObjectFromString(res);
        log.info("POST URL:{}", url);
        log.info("POST res:{}", json);

        if (json.containsKey("openid")) {
            // 请求成功
            return json.getString("openid");
        } else {
            // 请求失败
            if (json.containsKey("errmsg")) {
                throw new RPCException(ApiReturnCode.EXTERNAL_INTERFACE_ERROR,
                        json.getInteger("errcode") + ": " + json.getString("errmsg"));
            } else {
                throw new RPCException(ApiReturnCode.EXTERNAL_INTERFACE_ERROR, "请求微信接口获取openID失败, ret={}", res);
            }
        }
    }


    /**
     * 生成get请求的地址
     *
     * @param api
     * @param appId
     * @param appSecret
     * @param code
     * @return
     */
    private static String genUrl(String api, String appId, String appSecret, String code) {

        return String.format("https://%s%s?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
                Domain, api, appId, appSecret, code);
    }

    public static void main(String[] args) {

        // qq1353934265 : oNMqH5BpVtDgoo7zdvcjej_w-mwE

        //String url = genUrl("/sns/jscode2session", "wx8de0474336dab069", "cc7357cd2464dff3fb327917c1333bcf", "063x7P0w3cIjxV2a684w3J95Bb3x7P01");
        genOpenIdFromCodeByAppIdAndSecret("wx8de0474336dab069", "cc7357cd2464dff3fb327917c1333bcf", "063am10w3OAAwV2FK12w3AFsLI1am10J");
    }

}
