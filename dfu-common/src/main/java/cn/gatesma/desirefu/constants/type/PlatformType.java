package cn.gatesma.desirefu.constants.type;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author gatesma
 * @date 2020/11/1
 * @desc 账号类型枚举
 */
public enum PlatformType {

    NORMAL(1, "学生账号"), // NORMAL类型的账号，可以参与组队
    COMPETITION_CREATOR(2, "比赛信息管理"),// 比赛创建者账号
    OSS(3, "运营账号"), // 运营人员账号
    SUPER_USER(4, "SUPER_USER"),// 最高权限账号，原则上只有一个，用于OSS账户、比赛创建者账户任免等顶级权限操作
    ORGANIZE(5, "队伍")
    ;
    private Integer value;
    private String desc;

    public static Set<Integer> accountTypeSet;

    static {
        accountTypeSet = Sets.newHashSet();
        for (PlatformType type : PlatformType.values()) {
            accountTypeSet.add(type.value);
        }
    }

    PlatformType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static String getDescByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (PlatformType type : PlatformType.values()) {
            if (type.value.equals(value)) {
                return type.desc;
            }
        }
        return "未知";
    }

    public static Integer getValueByDesc(String desc) {
        if (desc == null) {
            return null;
        }
        for (PlatformType type : PlatformType.values()) {
            if (type.desc.equals(desc)) {
                return type.value;
            }
        }
        throw new IllegalArgumentException("unable to find the AccountType value=" + desc);
    }

    public static List<String> getAllDesc() {
        return Lists.newArrayList(PlatformType.values()).stream().map(it -> it.desc).collect(Collectors.toList());
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
