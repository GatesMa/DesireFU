package cn.gatesma.desirefu.utils;

/**
 * @author gatesma
 * @date 2020/11/7
 * @desc trace验证工具类(spanId, traceId)
 */
public class ValidateUtil {

    // spanId的正则匹配，诸如：0.2.1，'.<num>'可以有无数次，但是num最大只能是4位数9999
    private final static String SPAN_PATTERN = "^0(\\.[1-9][0-9]{0,3})*$";

    /**
     * spanId必须符合格式：<br>
     * 以0开头，第二级和以后节点为1开始，不超过4位数字
     */
    public static boolean validateSpanId(String spanId) {
        return spanId != null && spanId.matches(SPAN_PATTERN);
    }

    /**
     * traceId格式校验
     */
    public static boolean validateTraceId(String traceId) {
        return traceId != null && traceId.length() == 32;
    }
}
