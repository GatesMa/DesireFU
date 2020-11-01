package cn.gatesma.desirefu.controller.api;


import cn.gatesma.desirefu.constants.ApiReturnCode;

public class CustomerApiException extends RuntimeException {

    private static final long serialVersionUID = -6958537901675870030L;

    private ApiReturnCode retCode;

    private Object data;

    public CustomerApiException(ApiReturnCode retCode) {
        this(retCode, retCode.name());
    }

    public CustomerApiException(ApiReturnCode retCode, String msg) {
        this(retCode, msg, null);
    }

    public CustomerApiException(ApiReturnCode retCode, String msg, Object data) {
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

