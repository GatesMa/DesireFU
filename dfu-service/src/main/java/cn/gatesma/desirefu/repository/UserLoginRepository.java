package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.type.DeleteStatus;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.User_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Userlogin_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.User_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Userlogin_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.jooq.*;
import org.jooq.types.UInteger;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.USERLOGIN_;
import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.USER_;


/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc:
 */
@Repository
public class UserLoginRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 根据login信息获取对应的用户ID
     *
     * @param loginName     登录名称
     * @param loginNameType 登录类型
     * @param deleteStatus  删除状态，可为空, 表示全部
     * @return login对应的user
     */
    public Userlogin_Record getLoginUser(String loginName, int loginNameType, DeleteStatus deleteStatus) {
        SelectConditionStep<Userlogin_Record> stmt = dslContext.selectFrom(USERLOGIN_)
                .where(USERLOGIN_.LOGINNAME.eq(loginName))
                .and(USERLOGIN_.LOGINNAMETYPE.eq(loginNameType));
        if (deleteStatus != null) {
            stmt.and(USERLOGIN_.DELETESTATUS.eq(deleteStatus.code()));
        }

        return stmt.fetchOne();
    }

    /**
     * 根据userId获取user的所有登陆信息
     */
    public List<Userlogin_Record> getUserLoginList(long userId, DeleteStatus deleteStatus) {
        SelectConditionStep<Userlogin_Record> stmt = dslContext.selectFrom(USERLOGIN_)
                .where(USERLOGIN_.USERID.eq(userId));

        if (deleteStatus != null) {
            stmt.and(USERLOGIN_.DELETESTATUS.eq(deleteStatus.code()));
        }

        return Arrays.asList(stmt.fetch().toArray(new Userlogin_Record[]{}));
    }

    /**
     * 插入UserLogin_表
     *
     * @param loginName     登录名称
     * @param loginNameType 登录类型
     * @param userId        用户ID
     * @return 变更记录数
     */
    public int insertUserLogin(String loginName, int loginNameType, long userId, Long createdUserId) {
        return insertUserLogin(loginName, loginNameType, userId, DeleteStatus.NORMAL, createdUserId);
    }

    public int insertUserLogin(String loginName, int loginNameType, long userId, DeleteStatus deleteStatus, Long createdUserId) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return dslContext.insertInto(USERLOGIN_,
                USERLOGIN_.LOGINNAME,
                USERLOGIN_.LOGINNAMETYPE,
                USERLOGIN_.USERID,
                USERLOGIN_.DELETESTATUS,
                USERLOGIN_.CREATEDUSERID,
                USERLOGIN_.CREATEDTIME,
                USERLOGIN_.LASTMODIFIEDUSERID,
                USERLOGIN_.LASTMODIFIEDTIME)
                .values(loginName,
                        loginNameType,
                        userId,
                        deleteStatus == null ? DeleteStatus.NORMAL.code() : deleteStatus.code(),
                        createdUserId == null ? 0 : createdUserId,
                        now,
                        createdUserId == null ? 0 : createdUserId,
                        now
                )
                .execute();
    }

    /**
     * 检查updateUserLogin的参数
     * @param id
     */
    private void checkUpdateUserLoginThrown(Long id, long userId) {
        if(id==null || userId == 0){
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM,"Illegal param for updating UserLogin_");
        }
    }

    /**
     * 根据id和loginName，更新UserLogin_表
     */
    public int updateUserLogin(Long id, long userId, Long operatorUserId, DeleteStatus newDeleteStatus) {
        // 参数校验
        checkUpdateUserLoginThrown(id, userId);
        // 拼装SQL
        UpdateSetMoreStep<Userlogin_Record> stmt = dslContext.update(USERLOGIN_)
                .set(USERLOGIN_.LASTMODIFIEDTIME, new Timestamp(System.currentTimeMillis()));

        if(operatorUserId !=null){
            stmt.set(USERLOGIN_.LASTMODIFIEDUSERID,operatorUserId);
        }

        if(newDeleteStatus != null){
            stmt.set(USERLOGIN_.DELETESTATUS,newDeleteStatus.code());
        }

        return stmt.where(USERLOGIN_.ID.eq(id))
                .and(USERLOGIN_.USERID.eq(userId))
                .execute();
    }


}
