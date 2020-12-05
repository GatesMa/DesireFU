package cn.gatesma.desirefu.constants.status;

/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc:
 */
public enum AccountStatus {

    STATUS_PENDING(0, "待审核"),// 待审核
    STATUS_NORMAL(1, "有效"),// 有效
    STATUS_DENIED(2, "审核不通过"),// 审核不通过
    STATUS_FROZEN(3, "冻结");  // 冻结

    private final int code;

    private final String msg;

    AccountStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public static AccountStatus parseCode(int deleteStatus) {
        for (AccountStatus status : values()) {
            if (status.code == deleteStatus) {
                return status;
            }
        }
        return null;
    }

}
