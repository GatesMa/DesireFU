package cn.gatesma.desirefu.utils;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.exception.RPCException;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.google.gson.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.time.LocalDate;

/**
 * @author gatesma
 * @date 2020/12/21 1:02 下午
 * @desc
 */
public class JsonUtil {

    private final static Logger LOG = LoggerFactory.getLogger(JsonUtil.class);

    public static JSONObject getJsonObjectFromString(String json) {
        if (json == null) {
            throw new RPCException(ApiReturnCode.ILLEGAL_PARAM, "参数json是null", null);
        }
        if ("[]".equals(json) || "".equals(json)) {
            json = "{}";
        }
        return JSONObject.parseObject(json);
    }

    private static final Gson JSON_PARSER = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>(){
        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT,
                                     JsonDeserializationContext context) throws JsonParseException {
            return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
        }
    }).create();

    /**
     * json to object
     * @param jsonStr
     * @param classType
     * @param <T>
     * @return
     */
    public static <T> T deSerialize(String jsonStr, Class<T> classType) {

        if (!Strings.isNullOrEmpty(jsonStr) && null != classType) {

            try {
                return JSON_PARSER.fromJson(jsonStr, classType);
            } catch (Exception e) {
                LOG.error("反序列化 json {} 异常 ", jsonStr, e);
            }
        }

        return null;
    }

}
