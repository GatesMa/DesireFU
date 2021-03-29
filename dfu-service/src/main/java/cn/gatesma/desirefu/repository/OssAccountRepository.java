package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.config.aspect.annotation.DIAccessMo;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Ossaccount_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.OSSACCOUNT_;

/**
 * User: gatesma
 * Date: 2020/12/22 1:17 下午
 * Desc:
 */
@Repository
public class OssAccountRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 通过id查询账号
     */
    @DIAccessMo(table = "OssAccount_", db = "DFU_")
    public Ossaccount_Record getAccountById(Long accountId, DeleteStatus deleteStatus) {
        SelectConditionStep<Ossaccount_Record> stmt = dslContext
                .selectFrom(OSSACCOUNT_)
                .where(OSSACCOUNT_.ACCOUNTID.eq(accountId));
        if (deleteStatus != null) {
            stmt.and(OSSACCOUNT_.DELETESTATUS.eq(deleteStatus.code()));
        }
        return stmt.fetchOne();
    }

    /**
     * 新增 OssAccount
     */
    @DIAccessMo(table = "OssAccount_", db = "DFU_")
    public boolean addOssAccount(Long accountId, Integer accountType, Integer type, Long createdUserId) {
        Timestamp now = TimeUtils.now();
        int res = dslContext
                .insertInto(
                        OSSACCOUNT_,
                        OSSACCOUNT_.ACCOUNTID,
                        OSSACCOUNT_.ACCOUNTTYPE,
                        OSSACCOUNT_.TYPE,
                        OSSACCOUNT_.CREATEDUSERID,
                        OSSACCOUNT_.CREATEDTIME,
                        OSSACCOUNT_.DELETESTATUS,
                        OSSACCOUNT_.LASTMODIFIEDUSERID,
                        OSSACCOUNT_.LASTMODIFIEDTIME
                )
                .values(
                        accountId,
                        accountType,
                        type,
                        createdUserId,
                        now,
                        DeleteStatus.NORMAL.code(),
                        createdUserId,
                        now
                ).execute();
        return res == 1;
    }


    /**
     * 删除 OssAccount 表数据
     */
    @DIAccessMo(table = "OssAccount_", db = "DFU_")
    public int deleteAccount(long accountId) {

        UpdateSetMoreStep<Ossaccount_Record> step = dslContext.update(OSSACCOUNT_)
                .set(OSSACCOUNT_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(OSSACCOUNT_.ACCOUNTID.eq(accountId)).execute();
    }

}
