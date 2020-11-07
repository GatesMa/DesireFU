package cn.gatesma.desirefu.domain;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import org.apache.commons.lang3.StringUtils;

/**
 * @author gatesma
 * @date 2020/11/7
 * @desc API返回模板类
 */
public class ApiResult<T> {

    private int code;
    private String message;
    private T data;

    public ApiResult() {}

    public ApiResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 请求成功结果
     */
    public static <T> ApiResult buildSucceedResult(T data) {
        return new ApiResult(ApiReturnCode.OK.code(), ApiReturnCode.OK.name(), data);
    }

    /**
     * 请求失败结果
     *
     * @param message
     * @return
     */
    public static <T> ApiResult buildFailedResult(String message) {
        return new ApiResult(ApiReturnCode.INNER_ERROR.code(), message, null);
    }

    /**
     * 请求失败结果
     *
     * @param message
     * @return
     */
    public static <T> ApiResult buildFailedResult(ApiReturnCode retCode, String message) {
        retCode=retCode==null?ApiReturnCode.INNER_ERROR:retCode;
        message= StringUtils.isBlank(message)?retCode.name():message;
        return new ApiResult(retCode.code(), message, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
