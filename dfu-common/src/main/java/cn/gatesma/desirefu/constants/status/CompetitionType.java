package cn.gatesma.desirefu.constants.status;

/**
 * User: gatesma
 * Date: 2020-12-31
 * Desc:
 */
public enum CompetitionType {

    DEPARTMENT_LEVEL(0, "院级"),
    SCHOOL_LEVEL(1, "校级"),
    PROVINCE_LEVEL(2, "省级"),
    COUNTRY_LEVEL(3, "国家级"),
    INTERNATIONAL_LEVEL(4, "国际级");

    private final int code;

    private final String msg;

    CompetitionType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public static CompetitionType parseCode(int deleteStatus) {
        for (CompetitionType status : values()) {
            if (status.code == deleteStatus) {
                return status;
            }
        }
        return null;
    }

}
