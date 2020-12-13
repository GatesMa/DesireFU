package cn.gatesma.desirefu.constants.type;

import cn.gatesma.desirefu.constants.status.AccountStatus;

/**
 * User: gatesma
 * Date: 2020-12-06
 * Desc:
 */
public enum OperatorRole {

    ROLE_ROOT(1, "开户账号"),// ROOT用户
    ROLE_ADMIN(2, "管理员"),// 管理员
    ROLE_OBSERVER(3, "观察者"),// 观察者
    ;

    private final int code;

    private final String value;

    OperatorRole(int code, String msg) {
        this.code = code;
        this.value = msg;
    }

    public int code() {
        return code;
    }

    public String value() {
        return value;
    }

    public static OperatorRole parseCode(int code) {
        for (OperatorRole status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        return null;
    }

    public static String parseCodeToVal(int code) {
        for (OperatorRole status : values()) {
            if (status.code == code) {
                return status.value;
            }
        }
        return "未知";
    }

}
