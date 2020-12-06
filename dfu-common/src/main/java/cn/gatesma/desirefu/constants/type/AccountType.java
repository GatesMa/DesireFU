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
public enum AccountType {

    NORMAL(1, "NORMAL"), // NORMAL类型的账号，可以参与组队
    COMPETITION_CREATOR(2, "COMPETITION_CREATOR"),// 比赛创建者账号
    OSS(3, "OSS"), // 运营人员账号
    SUPER_USER(4, "SUPER_USER");// 最高权限账号，原则上只有一个，用于OSS账户、比赛创建者账户任免等顶级权限操作

    private Integer value;
    private String desc;

    public static Set<Integer> accountTypeSet;

    static {
        accountTypeSet = Sets.newHashSet();
        for (AccountType type : AccountType.values()) {
            accountTypeSet.add(type.value);
        }
    }

    AccountType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static String getDescByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (AccountType type : AccountType.values()) {
            if (type.value.equals(value)) {
                return type.desc;
            }
        }
        throw new IllegalArgumentException("unable to find the AccountType value=" + value);
    }

    public static Integer getValueByDesc(String desc) {
        if (desc == null) {
            return null;
        }
        for (AccountType type : AccountType.values()) {
            if (type.desc.equals(desc)) {
                return type.value;
            }
        }
        throw new IllegalArgumentException("unable to find the AccountType value=" + desc);
    }

    public static List<String> getAllDesc() {
        return Lists.newArrayList(AccountType.values()).stream().map(it -> it.desc).collect(Collectors.toList());
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
