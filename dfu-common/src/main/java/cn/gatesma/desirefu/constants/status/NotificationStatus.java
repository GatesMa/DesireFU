package cn.gatesma.desirefu.constants.status;

/**
 * User: gatesma
 * Date: 2020-12-30
 * Desc:
 */
public enum NotificationStatus {

    DRAFT(0, "草稿"),
    NORMAL(1, "有效");

    private final int code;

    private final String msg;

    NotificationStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public static NotificationStatus parseCode(int deleteStatus) {
        for (NotificationStatus status : values()) {
            if (status.code == deleteStatus) {
                return status;
            }
        }
        return null;
    }

}
