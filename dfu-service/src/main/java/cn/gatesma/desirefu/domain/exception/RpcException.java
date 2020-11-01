package cn.gatesma.desirefu.domain.exception;

import java.io.Serializable;

public class RpcException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -6788976658976383578L;

    public RpcException(String msg) {
        super(msg);
    }

    public RpcException(String msg, Exception e) {
        super(msg, e);
    }
}
