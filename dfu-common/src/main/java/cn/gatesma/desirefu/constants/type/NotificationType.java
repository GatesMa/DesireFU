package cn.gatesma.desirefu.constants.type;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author gatesma
 * @date 2021/01/22
 * @desc 公告枚举
 */
public enum NotificationType {

    FRONT_PAGE_SWIPER(1, "学生系统首页swiper"),
    PARK_SWIPER(2, "广场通知"),
    PARK_NOTICE(3, "广场swiper");

    private Integer value;
    private String desc;

    NotificationType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
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
