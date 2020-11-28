package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.constants.type.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.College_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.User_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.COLLEGE_;
import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.USER_;


/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc:
 */
@Repository
public class CollegeRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 获取一个College
     */
    public College_Record getCollegeById(int collegeId, DeleteStatus deleteStatus) {
        SelectConditionStep<College_Record> stmt = dslContext
                .selectFrom(COLLEGE_)
                .where(COLLEGE_.COLLEGEID.eq(collegeId));
        if (deleteStatus != null) {
            stmt.and(COLLEGE_.DELETESTATUS.eq(deleteStatus.code()));
        }
        return stmt.fetchOne();
    }

    /**
     * 获取一个College
     */
    public College_Record getCollegeByIdentification(String identification) {
        SelectConditionStep<College_Record> stmt = dslContext
                .selectFrom(COLLEGE_)
                .where(COLLEGE_.IDENTIFICATION.eq(identification))
                .and(COLLEGE_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        return stmt.fetchOne();
    }

    /**
     * 查询学校，名称和部门模糊，标识码精确
     * @return
     */
    public List<College_Record> queryCollege(String name, String ministry, String identification) {
        SelectConditionStep<College_Record> stmt = dslContext
                .selectFrom(COLLEGE_)
                .where(COLLEGE_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        if (StringUtils.isNoneBlank(name)) {
            stmt.and(COLLEGE_.NAME.like("%" + name + "%"));
        }
        if (StringUtils.isNoneBlank(ministry)) {
            stmt.and(COLLEGE_.MINISTRY.like("%" + ministry + "%"));
        }
        if (StringUtils.isNoneBlank(name)) {
            stmt.and(COLLEGE_.NAME.like("%" + name + "%"));
        }
        if (StringUtils.isNoneBlank(identification)) {
            stmt.and(COLLEGE_.IDENTIFICATION.eq(identification));
        }
        return stmt.fetch();
    }

    /**
     * 新增College
     */
    public int addCollege(String name, String ministry, String identification, String location, String level, String memo) {

        Timestamp createdTime = TimeUtils.now();

        College_Record record = dslContext
                .insertInto(
                        COLLEGE_,
                        COLLEGE_.NAME,
                        COLLEGE_.MINISTRY,
                        COLLEGE_.IDENTIFICATION,
                        COLLEGE_.LOCATION,
                        COLLEGE_.LEVEL,
                        COLLEGE_.MEMO,
                        COLLEGE_.CREATEDTIME,
                        COLLEGE_.LASTMODIFIEDTIME,
                        COLLEGE_.DELETESTATUS
                )
                .values(
                        name,
                        ministry,
                        identification,
                        location,
                        level,
                        memo,
                        createdTime,
                        createdTime,
                        DeleteStatus.NORMAL.code()
                ).returning(COLLEGE_.COLLEGEID).fetchOne();
        return record.getValue(COLLEGE_.COLLEGEID);
    }


    /**
     * 删除College_表数据
     */
    public int deleteCollege(int collegeId) {

        UpdateSetMoreStep<College_Record> step = dslContext.update(COLLEGE_)
                .set(COLLEGE_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(COLLEGE_.COLLEGEID.eq(collegeId)).execute();
    }



}
