package cn.gatesma.desirefu.repository;


import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
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
    public int deleteAccount(long accountId) {

        UpdateSetMoreStep<Account_Record> step = dslContext.update(ACCOUNT_)
                .set(ACCOUNT_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(ACCOUNT_.ACCOUNTID.eq(accountId)).execute();
    }

    /**
     * 批量通过uid获取数据
     */
    public List<Account_Record> batchGetAccountById(List<Long> accountIds) {

        SelectConditionStep<Account_Record> stmt = dslContext
                .selectFrom(ACCOUNT_)
                .where(ACCOUNT_.ACCOUNTID.in(accountIds))
                .and(ACCOUNT_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));

        return stmt.fetch();
    }



}
