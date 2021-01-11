package cn.gatesma.desirefu.constants.status;

/**
 * User: gatesma
 * Date: 2020-12-30
 * Desc:
 */
public enum CompetitionState {

    PENDING(0, "未开始"),
    PROGRESSING(1, "进行中"),
    END(2, "已结束");

    private final int code;

    private final String msg;

    CompetitionState(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public static CompetitionState parseCode(int deleteStatus) {
        for (CompetitionState status : values()) {
            if (status.code == deleteStatus) {
                return status;
            }
        }
        return null;
    }

}
