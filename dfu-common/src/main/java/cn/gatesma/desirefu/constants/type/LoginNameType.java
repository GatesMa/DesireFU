package cn.gatesma.desirefu.constants.type;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc: 登陆类型
 */
public enum LoginNameType {

    LOGIN_NAME_TYPE_QQ(1, "QQ"),
    LOGIN_NAME_TYPE_WX(2, "WX");

    private Integer value;
    private String desc;

    LoginNameType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static LoginNameType valueOf(int value) {
        for (LoginNameType type : LoginNameType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
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
