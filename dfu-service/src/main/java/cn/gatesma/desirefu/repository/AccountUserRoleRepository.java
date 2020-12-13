package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Accountuserrole_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.collections.CollectionUtils;
import org.jooq.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.ACCOUNTUSERROLE_;
import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.ACCOUNT_;

/**
 * User: gatesma
 * Date: 2020-12-05
 * Desc:
 */
@Repository
public class AccountUserRoleRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 查询 AccountUserRole_，
     *
     * @param accountId 账号Id
     * @param accountType 账号类型
     * @param userId 用户Id
     * @return
     */
    public int queryValidAccountRoleCount(long accountId, int accountType, long userId) {
        int deleteStatus = DeleteStatus.NORMAL.code();
        return dslContext.selectCount().from(ACCOUNTUSERROLE_)
                .where(ACCOUNTUSERROLE_.ACCOUNTID.eq(accountId))
                .and(ACCOUNTUSERROLE_.ACCOUNTTYPE.eq(accountType))
                .and(ACCOUNTUSERROLE_.USERID.eq(userId))
                .and(ACCOUNTUSERROLE_.DELETESTATUS.eq(deleteStatus))
                .fetchOne(0, int.class);
    }

    /**
     * 根据主键查询 AccountUserRole_
     */
    public Accountuserrole_Record queryAccountRoleRecordById(long accountRoleId) {
        return dslContext.selectFrom(ACCOUNTUSERROLE_)
                .where(ACCOUNTUSERROLE_.ACCOUNTROLEID.eq(accountRoleId))
                .fetchOne();
    }

    /**
     * 新增/更新 AccountUserRole_
     *
     */
    public Long saveAccountRoleRecord(Accountuserrole_Record record) {

        if (null == record) {
            return null;
        }

        Long accountRoleId = record.getAccountroleid();
        // 插入
        if (null == accountRoleId) {
            Accountuserrole_Record insertRecord = dslContext
                    .insertInto(ACCOUNTUSERROLE_)
                    .set(record)
                    .returning(ACCOUNTUSERROLE_.ACCOUNTROLEID)
                    .fetchOne();
            if (null != insertRecord) {
                accountRoleId = insertRecord.getAccountroleid();
            }
        } else {
            dslContext.update(ACCOUNTUSERROLE_)
                    .set(record)
                    .where(ACCOUNTUSERROLE_.ACCOUNTROLEID.eq(accountRoleId))
                    .execute();
        }
        return accountRoleId;
    }

    /**
     * 新增AccountUserRole
     */
    public long addAccountUserRole(Long accountId, Integer accountType, Long userId, Integer role, Integer deleteStatus,
                                   Long createdUserId, Long lastModifiedUserId) {
        Timestamp now = TimeUtils.now();
        Accountuserrole_Record roleRelation =
                dslContext.insertInto(
                        ACCOUNTUSERROLE_,
                        ACCOUNTUSERROLE_.ACCOUNTID,
                        ACCOUNTUSERROLE_.ACCOUNTTYPE,
                        ACCOUNTUSERROLE_.USERID,
                        ACCOUNTUSERROLE_.ROLE,
                        ACCOUNTUSERROLE_.DELETESTATUS,
                        ACCOUNTUSERROLE_.CREATEDTIME,
                        ACCOUNTUSERROLE_.CREATEDUSERID,
                        ACCOUNTUSERROLE_.LASTMODIFIEDTIME,
                        ACCOUNTUSERROLE_.LASTMODIFIEDUSERID)
                        .values(
                                accountId,
                                accountType,
                                userId,
                                role,
                                deleteStatus,
                                now,
                                createdUserId,
                                now,
                                lastModifiedUserId)
                        .returning(ACCOUNTUSERROLE_.ACCOUNTROLEID).fetchOne();


        return roleRelation.getValue(ACCOUNTUSERROLE_.ACCOUNTROLEID);
    }

    /**
     * 查询账号用户角色信息
     */
    public List<Accountuserrole_Record> queryRoleRelation(Long accountId, Integer accountType, Long userId,
                                                          Integer role, Integer deleteStatus) {

        SelectConditionStep<Accountuserrole_Record> step = dslContext.selectFrom(ACCOUNTUSERROLE_)
                .where();

        if (null != accountId) {
            step.and(ACCOUNTUSERROLE_.ACCOUNTID.eq(accountId));
        }

        if (null != accountType) {
            step.and(ACCOUNTUSERROLE_.ACCOUNTTYPE.eq(accountType));
        }

        if (null != userId) {
            step.and(ACCOUNTUSERROLE_.USERID.eq(userId));
        }

        if (null != deleteStatus) {
            step.and(ACCOUNTUSERROLE_.DELETESTATUS.eq(deleteStatus));
        }

        if (null != role) {
            step.and(ACCOUNTUSERROLE_.ROLE.eq(role));
        }

        return step.fetch();
    }

    /**
     * 是否存在有效的角色信息(未删除)
     * (accountId, accountType, userId, role)未删除状态的只能存在一个
     *
     */
    public boolean hasAccountUserRole(Accountuserrole_Record record) {

        if (null == record) {
            return false;
        }

        int deleteStatus = DeleteStatus.NORMAL.code();

        SelectConditionStep<Record1<Integer>> step = dslContext.selectCount().from(ACCOUNTUSERROLE_)
                .where(ACCOUNTUSERROLE_.ACCOUNTID.eq(record.getAccountid()))
                .and(ACCOUNTUSERROLE_.ACCOUNTTYPE.eq(record.getAccounttype()))
                .and(ACCOUNTUSERROLE_.USERID.eq(record.getUserid()))
                .and(ACCOUNTUSERROLE_.ROLE.eq(record.getRole()))
                .and(ACCOUNTUSERROLE_.DELETESTATUS.eq(deleteStatus));

        // 更新的时候需要判断修改后的role是否已经存在
        // 即除当前AccountRoleId外还有别的记录
        if (null != record.getAccountroleid()) {
            step.and(ACCOUNTUSERROLE_.ACCOUNTROLEID.ne(record.getAccountroleid()));
        }

        return step.fetchOne(0, int.class) > 0;
    }

    public Result<Accountuserrole_Record> selectAccountUserRoleRelation(List<Long> accountIds, Long userId, List<Integer> roleList) {
        SelectConditionStep<Accountuserrole_Record> stmt = dslContext.selectFrom(ACCOUNTUSERROLE_)
                .where(ACCOUNTUSERROLE_.ACCOUNTID.in(accountIds))
                .and(ACCOUNTUSERROLE_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        if(userId!=null){
            stmt.and(ACCOUNTUSERROLE_.USERID.eq(userId));
        }
        if(CollectionUtils.isNotEmpty(roleList)){
            stmt.and(ACCOUNTUSERROLE_.ROLE.in(roleList));
        }
        return stmt.fetch();
    }





}
