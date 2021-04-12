package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.config.aspect.annotation.DIAccessMo;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.User_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.sql.Timestamp;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.*;


/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc:
 */
@Repository
public class UserRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 获取一个User
     */
    @DIAccessMo(table = "User_", db = "DFU_")
    public User_Record getUser(long userId, DeleteStatus deleteStatus) {
        SelectConditionStep<User_Record> stmt = dslContext
                .selectFrom(USER_)
                .where(USER_.USERID.eq(userId));
        if (deleteStatus != null) {
            stmt.and(USER_.DELETESTATUS.eq(deleteStatus.code()));
        }
        return stmt.fetchOne();
    }

    /**
     * 新增user
     */
    @DIAccessMo(table = "User_", db = "DFU_")
    public Long insertUser(Long createdUserId, Timestamp createdTime, String cellphone, String email, String userName) {

        createdUserId = (createdUserId == null) ? 0L : createdUserId;
        createdTime = (createdTime == null) ? TimeUtils.now() : createdTime;

        User_Record record = dslContext
                .insertInto(
                        USER_,
                        USER_.DELETESTATUS,
                        USER_.CREATEDUSERID,
                        USER_.CREATEDTIME,
                        USER_.LASTMODIFIEDUSERID,
                        USER_.LASTMODIFIEDTIME,
                        USER_.CELLPHONE,
                        USER_.EMAIL,
                        USER_.USERNAME
                )
                .values(
                        DeleteStatus.NORMAL.code(),
                        createdUserId,
                        createdTime,
                        createdUserId,
                        createdTime,
                        cellphone,
                        email,
                        userName
                ).returning(USER_.USERID).fetchOne();
        return record.getValue(USER_.USERID);
    }

    /**
     * 更新
     */
    @DIAccessMo(table = "User_", db = "DFU_")
    public boolean updateUser(long userId, String userName, String cellphone, String email) {

        UpdateSetMoreStep<User_Record> updateStep = dslContext.update(USER_)
                .set(USER_.LASTMODIFIEDTIME, TimeUtils.now());

        if (null != userName) {
            updateStep.set(USER_.USERNAME, userName);
        }

        if (null != cellphone) {
            updateStep.set(USER_.CELLPHONE, cellphone);
        }

        if (null != email) {
            updateStep.set(USER_.EMAIL, email);
        }

        return updateStep.where(USER_.USERID.eq(userId)).execute() > 0;
    }

    /**
     * 删除User_表数据
     */
    @DIAccessMo(table = "User_", db = "DFU_")
    public int deleteUser(long userId, Long operatorUserId) {

        UpdateSetMoreStep<User_Record> step = dslContext.update(USER_)
                .set(USER_.DELETESTATUS, DeleteStatus.DELETED.code());

        if (null != operatorUserId) {
            step.set(USER_.LASTMODIFIEDUSERID, operatorUserId);
        }

        return step.where(USER_.USERID.eq(userId)).execute();
    }



}
