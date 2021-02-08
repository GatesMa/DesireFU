package cn.gatesma.desirefu.constants.status;

/**
 * User: gatesma
 * Date: 2021-02-07
 * Desc:
 */
public enum MessageStatus {

    NOT_READ(0, "未读"),
    READ(1, "已读");

    private final int code;

    private final String msg;

    MessageStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public static MessageStatus parseCode(int deleteStatus) {
        for (MessageStatus status : values()) {
            if (status.code == deleteStatus) {
                return status;
            }
        }
        return null;
    }

}
