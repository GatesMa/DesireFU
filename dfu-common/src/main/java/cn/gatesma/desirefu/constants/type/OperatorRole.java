package cn.gatesma.desirefu.constants.type;

import cn.gatesma.desirefu.constants.status.AccountStatus;

/**
 * User: gatesma
 * Date: 2020-12-06
 * Desc:
 */
public enum OperatorRole {

    ROLE_ROOT(1, "ROOT用户"),// ROOT用户
    ROLE_ADMIN(2, "管理员"),// 管理员
    ROLE_OBSERVER(2, "观察者"),// 观察者
    ;

    private final int code;

    private final String msg;

    OperatorRole(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    public static OperatorRole parseCode(int deleteStatus) {
        for (OperatorRole status : values()) {
            if (status.code == deleteStatus) {
                return status;
            }
        }
        return null;
    }

}
