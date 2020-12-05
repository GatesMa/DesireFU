package cn.gatesma.desirefu.constants.status;

/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc:
 */
public enum ApprovalStatus {

    PENDING(0, "待审核"),
    SUPPORT(1, "审核通过"),
    DENIED(2, "审核不通过");

    private final int code;

    private final String msg;

    ApprovalStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public static ApprovalStatus parseCode(int deleteStatus) {
        for (ApprovalStatus status : values()) {
            if (status.code == deleteStatus) {
                return status;
            }
        }
        return null;
    }

}
