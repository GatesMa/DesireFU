package cn.gatesma.desirefu.repository;


import cn.gatesma.desirefu.constants.status.CompetitionState;
import cn.gatesma.desirefu.constants.status.CompetitionStatus;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.api.generate.Page;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Competition_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

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

    private static final String DESC = "desc";
    private static final String ASC = "asc";

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
                                  String content, Integer status, Timestamp beginTime, Timestamp endTime, Long createdUserId) {
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
                        COMPETITION_.STATUS,
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
                        status == null ? CompetitionStatus.DRAFT.code() : status, // 默认草稿
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

    public List<Competition_Record> queryCompetition(List<Long> competitionIds, Long accountId, Integer type,
           String title, String founder, Integer status, Integer state, String sortField, String sortType, Page page) {

        // 获取现在的时间，筛选比赛的状态
        Timestamp now = TimeUtils.now();
        SelectConditionStep<Competition_Record> stmt = dslContext
                .selectFrom(COMPETITION_)
                .where(COMPETITION_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));

        if (CollectionUtils.isNotEmpty(competitionIds)) {
            stmt.and(COMPETITION_.COMPETITIONID.in(competitionIds));
        }

        if (accountId != null) {
            stmt.and(COMPETITION_.ACCOUNTID.eq(accountId));
        }

        if (type != null) {
            stmt.and(COMPETITION_.TYPE.eq(type));
        }

        if (StringUtils.isNotBlank(title)) {
            stmt.and(COMPETITION_.TITLE.like("%" + title + "%"));
        }

        if (StringUtils.isNotBlank(founder)) {
            stmt.and(COMPETITION_.FOUNDER.like("%" + founder + "%"));
        }

        // status判断是否草稿
        if (status != null) {
            stmt.and(COMPETITION_.STATUS.eq(status));
        }

        // state控制时间状态
        if (state != null) {
            if (CompetitionState.PENDING.code() == state) {
                stmt.and(COMPETITION_.BEGINTIME.gt(now));
            } else if (CompetitionState.PROGRESSING.code() == state) {
                stmt.and(COMPETITION_.BEGINTIME.le(now)).and(COMPETITION_.ENDTIME.gt(now));
            } else if (CompetitionState.END.code() == state) {
                stmt.and(COMPETITION_.ENDTIME.le(now));
            }
        }

        // 排序字段
        if (StringUtils.isNotBlank(sortField) && StringUtils.isNotBlank(sortType)) {
            if (sortField.equals(COMPETITION_.PV.getName()) && sortType.equals(DESC)) {
                stmt.orderBy(COMPETITION_.PV.desc());
            }
            if (sortField.equals(COMPETITION_.PV.getName()) && sortType.equals(ASC)) {
                stmt.orderBy(COMPETITION_.PV.asc());
            }
            if (sortField.equals(COMPETITION_.CREATEDTIME.getName()) && sortType.equals(DESC)) {
                stmt.orderBy(COMPETITION_.CREATEDTIME.desc());
            }
            if (sortField.equals(COMPETITION_.CREATEDTIME.getName()) && sortType.equals(ASC)) {
                stmt.orderBy(COMPETITION_.CREATEDTIME.asc());
            }
            if (sortField.equals(COMPETITION_.BEGINTIME.getName()) && sortType.equals(DESC)) {
                stmt.orderBy(COMPETITION_.BEGINTIME.desc());
            }
            if (sortField.equals(COMPETITION_.BEGINTIME.getName()) && sortType.equals(ASC)) {
                stmt.orderBy(COMPETITION_.BEGINTIME.asc());
            }
            if (sortField.equals(COMPETITION_.ENDTIME.getName()) && sortType.equals(DESC)) {
                stmt.orderBy(COMPETITION_.ENDTIME.desc());
            }
            if (sortField.equals(COMPETITION_.ENDTIME.getName()) && sortType.equals(ASC)) {
                stmt.orderBy(COMPETITION_.ENDTIME.asc());
            }
        }

        // 翻页
        if (page != null) {
            stmt.limit(page.getPageSize()).offset(page.getPageSize() * (page.getPageNum() - 1));
        }

        return stmt.fetch();
    }

    public int deleteCompetition(long competitionId) {

        UpdateSetMoreStep<Competition_Record> step = dslContext.update(COMPETITION_)
                .set(COMPETITION_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(COMPETITION_.COMPETITIONID.eq(competitionId)).execute();
    }


}
