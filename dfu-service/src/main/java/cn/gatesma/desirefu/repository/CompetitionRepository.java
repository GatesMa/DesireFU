package cn.gatesma.desirefu.repository;


import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Competition_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.COMPETITION_;


/**
 * User: gatesma
 * Date: 2020-12-29
 * Desc:
 */
@Repository
public class CompetitionRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 通过id查询比赛
     */
    public Competition_Record getCompetitionById(Long competitionId, DeleteStatus deleteStatus) {
        SelectConditionStep<Competition_Record> stmt = dslContext
                .selectFrom(COMPETITION_)
                .where(COMPETITION_.COMPETITIONID.eq(competitionId));
        if (deleteStatus != null) {
            stmt.and(COMPETITION_.DELETESTATUS.eq(deleteStatus.code()));
        }
        return stmt.fetchOne();
    }

    /**
     * 新增 COMPETITION_
     */
    public boolean addCompetition(Long accountId, Integer accountType, Integer type, String title, String founder,
                                  String content, Timestamp beginTime, Timestamp endTime, Long createdUserId) {
        Timestamp now = TimeUtils.now();
        int res = dslContext
                .insertInto(
                        COMPETITION_,
                        COMPETITION_.ACCOUNTID,
                        COMPETITION_.ACCOUNTTYPE,
                        COMPETITION_.TYPE,
                        COMPETITION_.TITLE,
                        COMPETITION_.FOUNDER,
                        COMPETITION_.CONTENT,
                        COMPETITION_.PV,
                        COMPETITION_.BEGINTIME,
                        COMPETITION_.ENDTIME,
                        COMPETITION_.CREATEDUSERID,
                        COMPETITION_.CREATEDTIME,
                        COMPETITION_.DELETESTATUS,
                        COMPETITION_.LASTMODIFIEDUSERID,
                        COMPETITION_.LASTMODIFIEDTIME
                )
                .values(
                        accountId,
                        accountType,
                        type,
                        title,
                        founder,
                        content,
                        0,
                        beginTime,
                        endTime,
                        createdUserId,
                        now,
                        DeleteStatus.NORMAL.code(),
                        createdUserId,
                        now
                ).execute();
        return res == 1;
    }

    public int deleteCompetition(long competitionId) {

        UpdateSetMoreStep<Competition_Record> step = dslContext.update(COMPETITION_)
                .set(COMPETITION_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(COMPETITION_.COMPETITIONID.eq(competitionId)).execute();
    }


}
