package cn.gatesma.desirefu.repository;


import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Normalaccount_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.NORMALACCOUNT_;
import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.NORMALACCOUNT_;


/**
 * User: gatesma
 * Date: 2020-12-06
 * Desc:
 */
@Repository
public class NormalAccountRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 通过id查询账号
     */
    public Normalaccount_Record getAccountById(Long accountId, DeleteStatus deleteStatus) {
        SelectConditionStep<Normalaccount_Record> stmt = dslContext
                .selectFrom(NORMALACCOUNT_)
                .where(NORMALACCOUNT_.ACCOUNTID.eq(accountId));
        if (deleteStatus != null) {
            stmt.and(NORMALACCOUNT_.DELETESTATUS.eq(deleteStatus.code()));
        }
        return stmt.fetchOne();
    }

    /**
     * 新增 NormalAccount
     */
    public boolean addNormalAccount(Long accountId, Integer accountType, Integer collegeId, Integer departmentId,
                                 String major, String stuId, Long createdUserId) {
        Timestamp now = TimeUtils.now();
        int res = dslContext
                .insertInto(
                        NORMALACCOUNT_,
                        NORMALACCOUNT_.ACCOUNTID,
                        NORMALACCOUNT_.ACCOUNTTYPE,
                        NORMALACCOUNT_.COLLEGEID,
                        NORMALACCOUNT_.DEPARTMENTID,
                        NORMALACCOUNT_.MAJOR,
                        NORMALACCOUNT_.STUID,
                        NORMALACCOUNT_.CREATEDUSERID,
                        NORMALACCOUNT_.CREATEDTIME,
                        NORMALACCOUNT_.DELETESTATUS,
                        NORMALACCOUNT_.LASTMODIFIEDUSERID,
                        NORMALACCOUNT_.LASTMODIFIEDTIME
                )
                .values(
                        accountId,
                        accountType,
                        collegeId,
                        departmentId,
                        major,
                        stuId,
                        createdUserId,
                        now,
                        DeleteStatus.NORMAL.code(),
                        createdUserId,
                        now
                ).execute();
        return res == 1;
    }


    /**
     * 删除 NormalAccount 表数据
     */
    public int deleteAccount(long accountId) {

        UpdateSetMoreStep<Normalaccount_Record> step = dslContext.update(NORMALACCOUNT_)
                .set(NORMALACCOUNT_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(NORMALACCOUNT_.ACCOUNTID.eq(accountId)).execute();
    }



}
