package cn.gatesma.desirefu.utils;

import cn.gatesma.desirefu.constants.status.AccountStatus;

/**
 * User: gatesma
 * Date: 2020/12/24 10:01 上午
 * Desc:
 */
public class AccountUtils {


    /**
     * 账号状态转中文
     */
    public static String accountStatusToStr(Integer accountStatus) {
        AccountStatus status = AccountStatus.parseCode(accountStatus);

        if (status == null) {
            return "未知";
        } else {
            return status.msg();
        }

    }


}
