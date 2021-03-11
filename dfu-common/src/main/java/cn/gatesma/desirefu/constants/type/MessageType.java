package cn.gatesma.desirefu.constants.type;

import cn.gatesma.desirefu.constants.status.MessageStatus;

/**
 * @author gatesma
 * @date 2021/02/07
 * @desc 消息类型
 */
public enum MessageType {

    COMMON_MSG(1, "常规消息"),
    JOIN_ORGANIZE(2, "入队请求"),
    LEAVE_ORGANIZE(3, "离队消息"),
    JOIN_ORGANIZE_SUCCESS(4, "入队请求审批通过"),
    JOIN_ORGANIZE_FAIL(5, "入队请求被拒绝"),
    CREATE_ORGANIZE(6, "创建队伍成功")
    ;

    private Integer value;
    private String desc;

    MessageType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static String parseValToMsg(Integer type) {
        for (MessageType item : values()) {
            if (item.value.equals(type)) {
                return item.desc;
            }
        }
        return "未知";
    }

    public Integer getValue() {

        return value;
    }

    public void setValue(Integer value) {

        this.value = value;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }


}
