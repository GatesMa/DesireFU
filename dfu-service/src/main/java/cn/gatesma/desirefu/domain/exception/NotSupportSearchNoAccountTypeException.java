package cn.gatesma.desirefu.domain.exception;

import java.io.Serializable;

public class NotSupportSearchNoAccountTypeException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 8804158847796471062L;

    public NotSupportSearchNoAccountTypeException(String msg) {
        super(msg);
    }

    public NotSupportSearchNoAccountTypeException(String msg, Exception e) {
        super(msg, e);
    }
}
