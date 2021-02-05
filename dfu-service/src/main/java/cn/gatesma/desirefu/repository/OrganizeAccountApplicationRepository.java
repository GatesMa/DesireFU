package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.api.generate.Page;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organize_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organizeaccountapplication_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.ORGANIZEACCOUNTAPPLICATION_;
import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.ORGANIZE_;

/**
 * User: gatesma
 * Date: 2021/1/30 1:31 下午
 * Desc:
 */
@Repository
public class OrganizeAccountApplicationRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 获取一个 OrganizeAccountApplication
     */
    public Organizeaccountapplication_Record getOrganizeAccountApplicationById(long id) {
        SelectConditionStep<Organizeaccountapplication_Record> stmt = dslContext
                .selectFrom(ORGANIZEACCOUNTAPPLICATION_)
                .where(ORGANIZEACCOUNTAPPLICATION_.ID.eq(id))
                .and(ORGANIZEACCOUNTAPPLICATION_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        return stmt.fetchOne();
    }


    public List<Organizeaccountapplication_Record> queryOrganizeAccountApplication(List<Long> organizeId, Long accountId, Integer accountType, Integer status) {
        SelectConditionStep<Organizeaccountapplication_Record> stmt = dslContext
                .selectFrom(ORGANIZEACCOUNTAPPLICATION_)
                .where(ORGANIZEACCOUNTAPPLICATION_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        if (organizeId != null) {
            stmt.and(ORGANIZEACCOUNTAPPLICATION_.ORGANIZEID.in(organizeId));
        }
        if (accountId != null) {
            stmt.and(ORGANIZEACCOUNTAPPLICATION_.ACCOUNTID.eq(accountId));
        }
        if (accountType != null) {
            stmt.and(ORGANIZEACCOUNTAPPLICATION_.ACCOUNTTYPE.eq(accountType));
        }
        if (status != null) {
            stmt.and(ORGANIZEACCOUNTAPPLICATION_.STATUS.eq(status));
        }

        // 根据时间倒排
        stmt.orderBy(ORGANIZEACCOUNTAPPLICATION_.CREATEDTIME.desc());

        return stmt.fetch();
    }

    /**
     * 更新申请的状态
     */
    public int updateApplication(Long id, Integer status, Long userId) {
        Timestamp modifiedTime = TimeUtils.now();
        UpdateSetMoreStep<Organizeaccountapplication_Record> stmt = dslContext.update(ORGANIZEACCOUNTAPPLICATION_).set(ORGANIZEACCOUNTAPPLICATION_.LASTMODIFIEDUSERID, userId == null ? 0 : userId)
                .set(ORGANIZEACCOUNTAPPLICATION_.LASTMODIFIEDTIME, modifiedTime)
                .set(ORGANIZEACCOUNTAPPLICATION_.STATUS, status);

        return stmt.where(ORGANIZEACCOUNTAPPLICATION_.ID.eq(id))
                .and(ORGANIZEACCOUNTAPPLICATION_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()))
                .execute();
    }

    /**
     * 新增 OrganizeAccountApplication
     */
    public long addOrganizeAccountApplication(Long organizeId, Long accountId, Integer accountType, Integer status, Long createdUserId) {

        Timestamp createdTime = TimeUtils.now();

        Organizeaccountapplication_Record record = dslContext
                .insertInto(
                        ORGANIZEACCOUNTAPPLICATION_,
                        ORGANIZEACCOUNTAPPLICATION_.ORGANIZEID,
                        ORGANIZEACCOUNTAPPLICATION_.ACCOUNTID,
                        ORGANIZEACCOUNTAPPLICATION_.ACCOUNTTYPE,
                        ORGANIZEACCOUNTAPPLICATION_.STATUS,
                        ORGANIZEACCOUNTAPPLICATION_.CREATEDUSERID,
                        ORGANIZEACCOUNTAPPLICATION_.CREATEDTIME,
                        ORGANIZEACCOUNTAPPLICATION_.LASTMODIFIEDTIME,
                        ORGANIZEACCOUNTAPPLICATION_.LASTMODIFIEDUSERID,
                        ORGANIZEACCOUNTAPPLICATION_.DELETESTATUS
                )
                .values(
                        organizeId,
                        accountId,
                        accountType,
                        status,
                        createdUserId,
                        createdTime,
                        createdTime,
                        createdUserId,
                        DeleteStatus.NORMAL.code()
                ).returning(ORGANIZEACCOUNTAPPLICATION_.ORGANIZEID).fetchOne();
        return record.getValue(ORGANIZEACCOUNTAPPLICATION_.ORGANIZEID);
    }


    /**
     * 删除 OrganizeAccountApplication 表数据
     */
    public int deleteOrganizeAccountApplication(Long id) {

        UpdateSetMoreStep<Organizeaccountapplication_Record> step = dslContext.update(ORGANIZEACCOUNTAPPLICATION_)
                .set(ORGANIZEACCOUNTAPPLICATION_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(ORGANIZEACCOUNTAPPLICATION_.ID.eq(id)).execute();
    }

}
