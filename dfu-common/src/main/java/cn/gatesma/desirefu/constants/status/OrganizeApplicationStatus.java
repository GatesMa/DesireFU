package cn.gatesma.desirefu.constants.status;

/**
 * User: gatesma
 * Date: 2021/02/02 2:55 下午
 * Desc:
 */
public enum OrganizeApplicationStatus {

    //申请状态 0:申请中;1:申请成功;2:队长拒绝;3:用户取消;4:申请过期;7:OSS直接处理的请求(不在list接口展示);
    APPLYING(0),
    PASSED(1),
    REJECT(2),
    CANCEL(3),
    EXPIRED(4),
    UN_BIND_REQUEST(5),
    UN_BIND_CONFIRM(6),
    OSS_PROCESS(7);


    private final int code;

    OrganizeApplicationStatus(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

    public static OrganizeApplicationStatus parseCode(int deleteStatus) {
        for (OrganizeApplicationStatus status : values()) {
            if (status.code == deleteStatus) {
                return status;
            }
        }
        return null;
    }

}
