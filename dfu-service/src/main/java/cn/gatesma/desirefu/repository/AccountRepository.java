package cn.gatesma.desirefu.repository;


import cn.gatesma.desirefu.config.aspect.annotation.DIAccessMo;
import cn.gatesma.desirefu.constants.status.AccountStatus;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Message_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.ACCOUNT_;
import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.MESSAGE_;


/**
 * User: gatesma
 * Date: 2020-11-29
 * Desc:
 */
@Repository
public class AccountRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 通过id查询账号
     */
    @DIAccessMo(table = "Account_", db = "DFU_")
    public Account_Record getAccountById(Long accountId, DeleteStatus deleteStatus) {
        SelectConditionStep<Account_Record> stmt = dslContext
                .selectFrom(ACCOUNT_)
                .where(ACCOUNT_.ACCOUNTID.eq(accountId));
        if (deleteStatus != null) {
            stmt.and(ACCOUNT_.DELETESTATUS.eq(deleteStatus.code()));
        }
        return stmt.fetchOne();
    }

    /**
     * 新增Account
     */
    @DIAccessMo(table = "Account_", db = "DFU_")
    public long addAccount(Integer accountType, String nickName, Integer accountStatus, Integer approvalStatus,
                           String memo, Long auditUserId, String auditMsg, Timestamp auditedTime, Long rootUserId,
                           Timestamp createdTime, Integer deleteStatus, Long lastModifiedUserId, Timestamp lastModifiedTime) {
        Account_Record record = dslContext
                .insertInto(
                        ACCOUNT_,
                        ACCOUNT_.ACCOUNTTYPE,
                        ACCOUNT_.NICKNAME,
                        ACCOUNT_.ACCOUNTSTATUS,
                        ACCOUNT_.APPROVALSTATUS,
                        ACCOUNT_.MEMO,
                        ACCOUNT_.AUDITUSERID,
                        ACCOUNT_.AUDITMSG,
                        ACCOUNT_.AUDITEDTIME,
                        ACCOUNT_.ROOTUSERID,
                        ACCOUNT_.CREATEDTIME,
                        ACCOUNT_.DELETESTATUS,
                        ACCOUNT_.LASTMODIFIEDUSERID,
                        ACCOUNT_.LASTMODIFIEDTIME
                )
                .values(
                        accountType,
                        nickName,
                        accountStatus,
                        approvalStatus,
                        memo,
                        auditUserId,
                        auditMsg,
                        auditedTime,
                        rootUserId,
                        createdTime,
                        deleteStatus,
                        lastModifiedUserId,
                        lastModifiedTime
                ).returning(ACCOUNT_.ACCOUNTID).fetchOne();
        return record.getValue(ACCOUNT_.ACCOUNTID);
    }


    /**
     * 删除Account_表数据
     */
    @DIAccessMo(table = "Account_", db = "DFU_")
    public int deleteAccount(long accountId) {

        UpdateSetMoreStep<Account_Record> step = dslContext.update(ACCOUNT_)
                .set(ACCOUNT_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(ACCOUNT_.ACCOUNTID.eq(accountId)).execute();
    }

    /**
     * 批量通过uid获取数据
     */
    @DIAccessMo(table = "Account_", db = "DFU_")
    public List<Account_Record> batchGetAccountById(List<Long> accountIds) {

        SelectConditionStep<Account_Record> stmt = dslContext
                .selectFrom(ACCOUNT_)
                .where(ACCOUNT_.ACCOUNTID.in(accountIds))
                .and(ACCOUNT_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));

        return stmt.fetch();
    }

    /**
     * 获取全部未审核的账号
     */
    @DIAccessMo(table = "Account_", db = "DFU_")
    public List<Account_Record> getExamAccount(Integer type) {
        SelectConditionStep<Account_Record> stmt = dslContext
                .selectFrom(ACCOUNT_)
                .where(ACCOUNT_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()))
                .and(ACCOUNT_.ACCOUNTTYPE.eq(type))
                .and(ACCOUNT_.ACCOUNTSTATUS.eq(AccountStatus.STATUS_PENDING.code()));
        return stmt.fetch();
    }

    /**
     * 更新账号
     */
    @DIAccessMo(table = "Account_", db = "DFU_")
    public int updateAccount(Long accountId, Integer accountStatus, String nickname, String memo) {
        Timestamp modifiedTime = TimeUtils.now();
        UpdateSetMoreStep<Account_Record> stmt = dslContext.update(ACCOUNT_)
                .set(ACCOUNT_.LASTMODIFIEDTIME, modifiedTime);

        if (accountStatus != null) {
            stmt.set(ACCOUNT_.ACCOUNTSTATUS, accountStatus);
        }

        if (StringUtils.isNotBlank(nickname)) {
            stmt.set(ACCOUNT_.NICKNAME, nickname);
        }

        if (StringUtils.isNotBlank(memo)) {
            stmt.set(ACCOUNT_.MEMO, memo);
        }

        return stmt.where(ACCOUNT_.ACCOUNTID.eq(accountId))
                .and(ACCOUNT_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()))
                .execute();
    }


}
