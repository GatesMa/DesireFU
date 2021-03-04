package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.constants.status.DeleteStatus;
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
    public Collect_Record getCollectById(long id) {
        SelectConditionStep<Collect_Record> stmt = dslContext
                .selectFrom(COLLECT_)
                .where(COLLECT_.ID.eq(id))
                .and(COLLECT_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        return stmt.fetchOne();
    }

    public List<Collect_Record> queryCollectByAccountId(Long accountId) {
        SelectConditionStep<Collect_Record> stmt = dslContext
                .selectFrom(COLLECT_)
                .where(COLLECT_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        if (accountId != null) {
            stmt.and(COLLECT_.ACCOUNTID.eq(accountId));
        }

        // 按时间倒序
        stmt.orderBy(COLLECT_.CREATEDTIME.desc());
        return stmt.fetch();
    }

    /**
     * 新增Collect
     */
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
    public int deleteCollect(List<Long> ids) {

        UpdateSetMoreStep<Collect_Record> step = dslContext.update(COLLECT_)
                .set(COLLECT_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(COLLECT_.ID.in(ids)).execute();
    }

}
