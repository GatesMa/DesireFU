package cn.gatesma.desirefu.utils.user;

import cn.gatesma.desirefu.constants.type.DeleteStatus;
import cn.gatesma.desirefu.domain.api.generate.GetUserRet;
import cn.gatesma.desirefu.domain.api.generate.User;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Userlogin_Record;
import cn.gatesma.desirefu.utils.RetCodeUtils;

import java.util.Objects;

/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc:
 */
public class UserUtils {

    public static boolean isUserNotEmpty(GetUserRet userRet) {
        return RetCodeUtils.isOk(userRet) && userRet.getData() != null;
    }

    public static boolean isUserEmpty(GetUserRet userRet) {
        return !isUserNotEmpty(userRet);
    }

    public static boolean isDeleted(Userlogin_Record userLogin) {
        return userLogin != null && Objects.equals(DeleteStatus.DELETED.code(), userLogin.getDeletestatus());
    }

}
