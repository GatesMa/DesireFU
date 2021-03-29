package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.config.aspect.annotation.DIAccessMo;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Competitioncreatoraccount_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Normalaccount_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.COMPETITIONCREATORACCOUNT_;

/**
 * User: gatesma
 * Date: 2020/12/22 12:56 下午
 * Desc:
 */
@Repository
public class CompetitionCreatorAccountRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 通过id查询账号
     */
    @DIAccessMo(table = "CompetitionCreatorAccount_", db = "DFU_")
    public Competitioncreatoraccount_Record getAccountById(Long accountId, DeleteStatus deleteStatus) {
        SelectConditionStep<Competitioncreatoraccount_Record> stmt = dslContext
                .selectFrom(COMPETITIONCREATORACCOUNT_)
                .where(COMPETITIONCREATORACCOUNT_.ACCOUNTID.eq(accountId));
        if (deleteStatus != null) {
            stmt.and(COMPETITIONCREATORACCOUNT_.DELETESTATUS.eq(deleteStatus.code()));
        }
        return stmt.fetchOne();
    }

    /**
     * 新增 CompetitionCreatorAccount
     */
    @DIAccessMo(table = "CompetitionCreatorAccount_", db = "DFU_")
    public boolean addCompetitionCreatorAccount(Long accountId, Integer accountType, String author, Long createdUserId) {
        Timestamp now = TimeUtils.now();
        int res = dslContext
                .insertInto(
                        COMPETITIONCREATORACCOUNT_,
                        COMPETITIONCREATORACCOUNT_.ACCOUNTID,
                        COMPETITIONCREATORACCOUNT_.ACCOUNTTYPE,
                        COMPETITIONCREATORACCOUNT_.AUTHOR,
                        COMPETITIONCREATORACCOUNT_.CREATEDUSERID,
                        COMPETITIONCREATORACCOUNT_.CREATEDTIME,
                        COMPETITIONCREATORACCOUNT_.DELETESTATUS,
                        COMPETITIONCREATORACCOUNT_.LASTMODIFIEDUSERID,
                        COMPETITIONCREATORACCOUNT_.LASTMODIFIEDTIME
                )
                .values(
                        accountId,
                        accountType,
                        author,
                        createdUserId,
                        now,
                        DeleteStatus.NORMAL.code(),
                        createdUserId,
                        now
                ).execute();
        return res == 1;
    }


    /**
     * 删除 CompetitionCreatorAccount 表数据
     */
    @DIAccessMo(table = "CompetitionCreatorAccount_", db = "DFU_")
    public int deleteAccount(long accountId) {

        UpdateSetMoreStep<Competitioncreatoraccount_Record> step = dslContext.update(COMPETITIONCREATORACCOUNT_)
                .set(COMPETITIONCREATORACCOUNT_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(COMPETITIONCREATORACCOUNT_.ACCOUNTID.eq(accountId)).execute();
    }

}
