package cn.gatesma.desirefu.utils;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.exception.RPCException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author gatesma
 * @date 2020/12/21 1:02 下午
 * @desc
 */
public class JsonUtil {

    private static final Log log = LogFactory.getLog(JsonUtil.class);

    public static JSONObject getJsonObjectFromString(String json) {
        if (json == null) {
            throw new RPCException(ApiReturnCode.ILLEGAL_PARAM, "参数json是null", null);
        }
        if ("[]".equals(json) || "".equals(json)) {
            json = "{}";
        }
        return JSONObject.parseObject(json);
    }

}
