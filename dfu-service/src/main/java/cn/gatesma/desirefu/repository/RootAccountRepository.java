package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Rootaccount_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.ROOTACCOUNT_;

/**
 * User: gatesma
 * Date: 2020/12/22 1:19 下午
 * Desc:
 */
@Repository
public class RootAccountRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 通过id查询账号
     */
    public Rootaccount_Record getAccountById(Long accountId, DeleteStatus deleteStatus) {
        SelectConditionStep<Rootaccount_Record> stmt = dslContext
                .selectFrom(ROOTACCOUNT_)
                .where(ROOTACCOUNT_.ACCOUNTID.eq(accountId));
        if (deleteStatus != null) {
            stmt.and(ROOTACCOUNT_.DELETESTATUS.eq(deleteStatus.code()));
        }
        return stmt.fetchOne();
    }

    /**
     * 新增 RootAccount
     */
    public boolean addRootAccount(Long accountId, Integer accountType, Long createdUserId) {
        Timestamp now = TimeUtils.now();
        int res = dslContext
                .insertInto(
                        ROOTACCOUNT_,
                        ROOTACCOUNT_.ACCOUNTID,
                        ROOTACCOUNT_.ACCOUNTTYPE,
                        ROOTACCOUNT_.CREATEDUSERID,
                        ROOTACCOUNT_.CREATEDTIME,
                        ROOTACCOUNT_.DELETESTATUS,
                        ROOTACCOUNT_.LASTMODIFIEDUSERID,
                        ROOTACCOUNT_.LASTMODIFIEDTIME
                )
                .values(
                        accountId,
                        accountType,
                        createdUserId,
                        now,
                        DeleteStatus.NORMAL.code(),
                        createdUserId,
                        now
                ).execute();
        return res == 1;
    }


    /**
     * 删除 RootAccount 表数据
     */
    public int deleteAccount(long accountId) {

        UpdateSetMoreStep<Rootaccount_Record> step = dslContext.update(ROOTACCOUNT_)
                .set(ROOTACCOUNT_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(ROOTACCOUNT_.ACCOUNTID.eq(accountId)).execute();
    }

}
