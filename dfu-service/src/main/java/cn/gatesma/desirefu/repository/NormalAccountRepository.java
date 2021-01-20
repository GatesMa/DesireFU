package cn.gatesma.desirefu.repository;


import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Normalaccount_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.*;
import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.COMPETITION_;


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

    public List<Normalaccount_Record> queryNormalAccount(Long accountId, Integer collegeId, Integer departmentId,
                                                         String major, String stuId, String realName) {

        SelectConditionStep<Normalaccount_Record> conditionStep = dslContext.selectFrom(NORMALACCOUNT_)
                .where(NORMALACCOUNT_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));

        if (accountId != null) {
            conditionStep.and(NORMALACCOUNT_.ACCOUNTID.eq(accountId));
        }

        if (collegeId != null) {
            conditionStep.and(NORMALACCOUNT_.COLLEGEID.eq(collegeId));
        }

        if (departmentId != null) {
            conditionStep.and(NORMALACCOUNT_.DEPARTMENTID.eq(departmentId));
        }

        if (StringUtils.isNotBlank(major)) {
            conditionStep.and(NORMALACCOUNT_.MAJOR.like("%" + major + "%"));
        }

        // 学号精准查询
        if (StringUtils.isNotBlank(stuId)) {
            conditionStep.and(NORMALACCOUNT_.STUID.eq(stuId));
        }

        if (StringUtils.isNotBlank(realName)) {
            conditionStep.and(NORMALACCOUNT_.REALNAME.like("%" + realName + "%"));
        }

        return conditionStep.fetch();

    }

    /**
     * 新增 NormalAccount
     */
    public boolean addNormalAccount(Long accountId, Integer accountType, Integer collegeId, Integer departmentId,
                                 String major, String stuId, String realName, Long createdUserId) {
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
                        NORMALACCOUNT_.REALNAME,
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
                        realName,
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
