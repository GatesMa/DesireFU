package cn.gatesma.desirefu.constants.type;

/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc:
 */
public enum DeleteStatus {

    NORMAL(0),
    DELETED(1);

    private int code;

    private DeleteStatus(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

    public static DeleteStatus parseCode(int deleteStatus) {
        for (DeleteStatus status : values()) {
            if (status.code == deleteStatus) {
                return status;
            }
        }
        return null;
    }

}
