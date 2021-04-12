package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.config.aspect.annotation.DIAccessMo;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.api.generate.Page;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Collect_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.COLLECT_;

/**
 * User: gatesma
 * Date: 2021/3/4 19:47 下午
 * Desc:
 */
@Repository
public class CollectRepository {


    @Resource
    private DSLContext dslContext;

    /**
     * ID GET
     */
    @DIAccessMo(table = "Collect_", db = "DFU_")
    public Collect_Record getCollectById(long id) {
        SelectConditionStep<Collect_Record> stmt = dslContext
                .selectFrom(COLLECT_)
                .where(COLLECT_.ID.eq(id))
                .and(COLLECT_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        return stmt.fetchOne();
    }

    @DIAccessMo(table = "Collect_", db = "DFU_")
    public List<Collect_Record> queryCollectByAccountId(Long accountId, Long competitionId, Page page) {
        SelectConditionStep<Collect_Record> stmt = dslContext
                .selectFrom(COLLECT_)
                .where(COLLECT_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        if (accountId != null) {
            stmt.and(COLLECT_.ACCOUNTID.eq(accountId));
        }

        if (competitionId != null) {
            stmt.and(COLLECT_.COMPETITIONID.eq(competitionId));
        }

        // 翻页
        if (page != null) {
            stmt.limit(page.getPageSize()).offset(page.getPageSize() * (page.getPageNum() - 1));
        }

        // 按时间倒序
        stmt.orderBy(COLLECT_.CREATEDTIME.desc());
        return stmt.fetch();
    }

    /**
     * 新增Collect
     */
    @DIAccessMo(table = "Collect_", db = "DFU_")
    public int addCollect(Long accountId, Long competitionId) {

        Timestamp createdTime = TimeUtils.now();

        return dslContext
                .insertInto(
                        COLLECT_,
                        COLLECT_.ACCOUNTID,
                        COLLECT_.COMPETITIONID,
                        COLLECT_.CREATEDTIME,
                        COLLECT_.LASTMODIFIEDTIME,
                        COLLECT_.DELETESTATUS
                )
                .values(
                        accountId,
                        competitionId,
                        createdTime,
                        createdTime,
                        DeleteStatus.NORMAL.code()
                ).execute();
    }


    /**
     * 删除Collect_表数据
     */
    @DIAccessMo(table = "Collect_", db = "DFU_")
    public int deleteCollect(List<Long> ids) {

        UpdateSetMoreStep<Collect_Record> step = dslContext.update(COLLECT_)
                .set(COLLECT_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(COLLECT_.ID.in(ids)).execute();
    }

    /**
     * 删除Collect_表数据
     */
    @DIAccessMo(table = "Collect_", db = "DFU_")
    public void deleteCollect(Long accountId, Long competitionId) {

        UpdateSetMoreStep<Collect_Record> step = dslContext.update(COLLECT_)
                .set(COLLECT_.DELETESTATUS, DeleteStatus.DELETED.code());

        step.where(COLLECT_.ACCOUNTID.eq(accountId))
            .and(COLLECT_.COMPETITIONID.eq(competitionId)).execute();
    }

}
