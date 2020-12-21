package cn.gatesma.desirefu.exception;

import cn.gatesma.desirefu.constants.ApiReturnCode;

/**
 * @author gatesma
 * @date 2020/12/21 12:54 下午
 * @desc
 */
public class RPCException extends RuntimeException {
    private ApiReturnCode retCode;

    private Object data;

    public RPCException(ApiReturnCode retCode) {
        this(retCode, retCode.name());
    }

    public RPCException(ApiReturnCode retCode, String msg) {
        this(retCode, msg, null);
    }

    public RPCException(ApiReturnCode retCode, String msg, Object data) {
        super(msg);
        this.retCode = retCode;
        this.data = data;
    }

    public ApiReturnCode getRetCode() {
        return retCode;
    }

    public Object getData() {
        return data;
    }
}