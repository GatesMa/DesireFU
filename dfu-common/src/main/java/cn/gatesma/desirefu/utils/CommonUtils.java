package cn.gatesma.desirefu.utils;

import com.google.common.base.Strings;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.lang3.BooleanUtils;

/**
 * @author gatesma
 * @date 2020/11/7
 * @desc 通用工具类
 */
public class CommonUtils {
    public static String safeGetStringFromObj(Object obj) {
        return safeGetStringFromObj(obj, "");
    }

    public static String safeGetStringFromObj(Object obj, String defaultValue) {
        return null == obj ? (Strings.isNullOrEmpty(defaultValue) ? "" : defaultValue) : obj.toString();
    }

    public static Integer safeGetIntegerFromObj(Object obj) {
        return null == obj ? 0 : (Integer) obj;
    }

    public static boolean safeGetBoolFromObj(String obj,boolean defaultValue){
        return BooleanUtils.toBooleanObject(obj) == null ? defaultValue : BooleanUtils.toBooleanObject(obj);
    }

    /**
     * 将参数内容进行md5加密
     * @param content
     * @return
     */
    public static String md5(byte[] content) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(content);
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5加密出现错误",e);
        }
    }

    /**
     * 将参数内容进行md5加密
     * @param content
     * @param charset
     * @return
     */
    public static String md5(String content, Charset charset) {
        return md5(content.getBytes(charset));
    }

    /**
     * 将参数内容进行md5加密
     * @param content
     * @return
     */
    public static String md5(String content) {
        return md5(content, StandardCharsets.UTF_8);
    }

}
