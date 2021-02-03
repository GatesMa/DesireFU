package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Organize_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organize_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.ORGANIZE_;

/**
 * User: gatesma
 * Date: 2021/1/30 1:31 下午
 * Desc:
 */
@Repository
public class OrganizeRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 获取一个 Organize
     */
    public Organize_Record getOrganizeById(long organizeId) {
        SelectConditionStep<Organize_Record> stmt = dslContext
                .selectFrom(ORGANIZE_)
                .where(ORGANIZE_.ORGANIZEID.eq(organizeId))
                .and(ORGANIZE_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        return stmt.fetchOne();
    }


    public List<Organize_Record> queryOrganize(Long organizeId, Long competitionId, Long srcAccountId) {
        SelectConditionStep<Organize_Record> stmt = dslContext
                .selectFrom(ORGANIZE_)
                .where(ORGANIZE_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        if (organizeId != null) {
            stmt.and(ORGANIZE_.ORGANIZEID.eq(organizeId));
        }
        if (competitionId != null) {
            stmt.and(ORGANIZE_.COMPETITIONID.eq(competitionId));
        }
        if (srcAccountId != null) {
            stmt.and(ORGANIZE_.SRCACCOUNTID.eq(srcAccountId));
        }
        return stmt.fetch();
    }

    /**
     * 新增Organize
     */
    public boolean addOrganize(Long organizeId, Long competitionId, Long srcAccountId, Long createdUserId) {

        Timestamp createdTime = TimeUtils.now();

        int res = dslContext
                .insertInto(
                        ORGANIZE_,
                        ORGANIZE_.ORGANIZEID,
                        ORGANIZE_.COMPETITIONID,
                        ORGANIZE_.SRCACCOUNTID,
                        ORGANIZE_.CREATEDUSERID,
                        ORGANIZE_.CREATEDTIME,
                        ORGANIZE_.LASTMODIFIEDTIME,
                        ORGANIZE_.LASTMODIFIEDUSERID,
                        ORGANIZE_.DELETESTATUS
                )
                .values(
                        organizeId,
                        competitionId,
                        srcAccountId,
                        createdUserId,
                        createdTime,
                        createdTime,
                        createdUserId,
                        DeleteStatus.NORMAL.code()
                ).execute();;
        return res == 1;
    }


    /**
     * 删除Organize_表数据
     */
    public int deleteOrganize(Long organizeId) {

        UpdateSetMoreStep<Organize_Record> step = dslContext.update(ORGANIZE_)
                .set(ORGANIZE_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(ORGANIZE_.ORGANIZEID.eq(organizeId)).execute();
    }

    /**
     * 通过srcAccountId查找Oragnize
     */
    public List<Organize_Record> getOrganizeListBySrcAccountId(Long srcAccountId) {
        SelectConditionStep<Organize_Record> stmt = dslContext
                .selectFrom(ORGANIZE_)
                .where(ORGANIZE_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()))
                .and(ORGANIZE_.SRCACCOUNTID.eq(srcAccountId));

        return stmt.fetch();
    }

}
