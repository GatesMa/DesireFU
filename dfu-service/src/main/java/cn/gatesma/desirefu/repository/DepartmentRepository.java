package cn.gatesma.desirefu.repository;

import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Department_Record;
import cn.gatesma.desirefu.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static cn.gatesma.desirefu.domain.db.generate.DFU_.Tables.DEPARTMENT_;


/**
 * User: gatesma
 * Date: 2020-11-28
 * Desc:
 */
@Repository
public class DepartmentRepository {

    @Resource
    private DSLContext dslContext;

    /**
     * 查询学校，名称和部门模糊，标识码精确
     *
     * @return
     */
    public List<Department_Record> queryDepartment(Integer departmentId, String name, Integer collegeId) {
        SelectConditionStep<Department_Record> stmt = dslContext
                .selectFrom(DEPARTMENT_)
                .where(DEPARTMENT_.DELETESTATUS.eq(DeleteStatus.NORMAL.code()));
        if (StringUtils.isNoneBlank(name)) {
            stmt.and(DEPARTMENT_.NAME.like("%" + name + "%"));
        }
        if (departmentId != null) {
            stmt.and(DEPARTMENT_.DEPARTMENTID.eq(departmentId));
        }
        if (collegeId != null) {
            stmt.and(DEPARTMENT_.COLLEGEID.eq(collegeId));
        }
        return stmt.fetch();
    }

    /**
     * 新增Department
     */
    public int addDepartment(String name, Integer collegeId) {

        Timestamp createdTime = TimeUtils.now();

        Department_Record record = dslContext
                .insertInto(
                        DEPARTMENT_,
                        DEPARTMENT_.NAME,
                        DEPARTMENT_.COLLEGEID,
                        DEPARTMENT_.CREATEDTIME,
                        DEPARTMENT_.LASTMODIFIEDTIME,
                        DEPARTMENT_.DELETESTATUS
                )
                .values(
                        name,
                        collegeId,
                        createdTime,
                        createdTime,
                        DeleteStatus.NORMAL.code()
                ).returning(DEPARTMENT_.DEPARTMENTID).fetchOne();
        return record.getValue(DEPARTMENT_.DEPARTMENTID);
    }


    /**
     * 删除Department_表数据
     */
    public int deleteDepartment(int departmentId) {

        UpdateSetMoreStep<Department_Record> step = dslContext.update(DEPARTMENT_)
                .set(DEPARTMENT_.DELETESTATUS, DeleteStatus.DELETED.code());

        return step.where(DEPARTMENT_.DEPARTMENTID.eq(departmentId)).execute();
    }


}
