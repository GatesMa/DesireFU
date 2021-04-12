package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.config.aspect.annotation.DIAccessMo;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organizeaccountrelation_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.ORGANIZEACCOUNTRELATION_;

/**
 * User: gatesma
 * Date: 2021/1/30 1:31 下午
 * Desc:
 */
@Repository
public class OrganizeAccountRelationRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 获取一个 Organizeaccountrelation
     */
    @DIAccessMo(table = "OrganizeAccountRelation_", db = "DFU_")
    public Organizeaccountrelation_Record getOrganizeAccountRelationById(long id) {
        SelectConditionStep<Organizeaccountrelation_Record> stmt = dslContext
                .selectFrom(ORGANIZEACCOUNTRELATION_)
                .where(ORGANIZEACCOUNTRELATION_.ID.eq(id))
                .and(ORGANIZEACCOUNTRELATION_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        return stmt.fetchOne();
    }

    @DIAccessMo(table = "OrganizeAccountRelation_", db = "DFU_")
    public List<Organizeaccountrelation_Record> queryOrganizeAccountRelation(Long organizeId, Long accountId, Integer accountType, Integer isOwnerAccount) {
        SelectConditionStep<Organizeaccountrelation_Record> stmt = dslContext
                .selectFrom(ORGANIZEACCOUNTRELATION_)
                .where(ORGANIZEACCOUNTRELATION_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        if (organizeId != null) {
            stmt.and(ORGANIZEACCOUNTRELATION_.ORGANIZEID.eq(organizeId));
        }
        if (accountId != null) {
            stmt.and(ORGANIZEACCOUNTRELATION_.ACCOUNTID.eq(accountId));
        }
        if (accountType != null) {
            stmt.and(ORGANIZEACCOUNTRELATION_.ACCOUNTTYPE.eq(accountType));
        }
        if (isOwnerAccount != null) {
            stmt.and(ORGANIZEACCOUNTRELATION_.ISOWNERACCOUNT.eq(isOwnerAccount));
        }
        return stmt.fetch();
    }

    /**
     * 新增 OrganizeAccountRelation
     */
    @DIAccessMo(table = "OrganizeAccountRelation_", db = "DFU_")
    public long addOrganizeAccountRelation(Long organizeId, Long accountId, Integer accountType, Integer isOwnerAccount, Long createdUserId) {

        Timestamp createdTime = TimeUtils.now();

        Organizeaccountrelation_Record record = dslContext
                .insertInto(
                        ORGANIZEACCOUNTRELATION_,
                        ORGANIZEACCOUNTRELATION_.ORGANIZEID,
                        ORGANIZEACCOUNTRELATION_.ACCOUNTID,
                        ORGANIZEACCOUNTRELATION_.ACCOUNTTYPE,
                        ORGANIZEACCOUNTRELATION_.ISOWNERACCOUNT,
                        ORGANIZEACCOUNTRELATION_.CREATEDUSERID,
                        ORGANIZEACCOUNTRELATION_.CREATEDTIME,
                        ORGANIZEACCOUNTRELATION_.LASTMODIFIEDTIME,
                        ORGANIZEACCOUNTRELATION_.LASTMODIFIEDUSERID,
                        ORGANIZEACCOUNTRELATION_.DELETESTATUS
                )
                .values(
                        organizeId,
                        accountId,
                        accountType,
                        isOwnerAccount,
                        createdUserId,
                        createdTime,
                        createdTime,
                        createdUserId,
                        DeleteStatus.NORMAL.code()
                ).returning(ORGANIZEACCOUNTRELATION_.ORGANIZEID).fetchOne();
        return record.getValue(ORGANIZEACCOUNTRELATION_.ORGANIZEID);
    }


    /**
     * 删除 OrganizeAccountRelation 表数据
     */
    @DIAccessMo(table = "OrganizeAccountRelation_", db = "DFU_")
    public int deleteOrganizeAccountRelation(Long id) {

        UpdateSetMoreStep<Organizeaccountrelation_Record> step = dslContext.update(ORGANIZEACCOUNTRELATION_)
                .set(ORGANIZEACCOUNTRELATION_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(ORGANIZEACCOUNTRELATION_.ID.eq(id)).execute();
    }

}
