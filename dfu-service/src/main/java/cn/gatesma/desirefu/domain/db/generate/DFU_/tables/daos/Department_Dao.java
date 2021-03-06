/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.daos;


import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Department_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Department_Record;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * 学院信息
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Department_Dao extends DAOImpl<Department_Record, cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Department_, Integer> {

    /**
     * Create a new Department_Dao without any configuration
     */
    public Department_Dao() {
        super(Department_.DEPARTMENT_, cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Department_.class);
    }

    /**
     * Create a new Department_Dao with an attached configuration
     */
    public Department_Dao(Configuration configuration) {
        super(Department_.DEPARTMENT_, cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Department_.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Department_ object) {
        return object.getDepartmentid();
    }

    /**
     * Fetch records that have <code>departmentId IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Department_> fetchByDepartmentid(Integer... values) {
        return fetch(Department_.DEPARTMENT_.DEPARTMENTID, values);
    }

    /**
     * Fetch a unique record that has <code>departmentId = value</code>
     */
    public cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Department_ fetchOneByDepartmentid(Integer value) {
        return fetchOne(Department_.DEPARTMENT_.DEPARTMENTID, value);
    }

    /**
     * Fetch records that have <code>collegeId IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Department_> fetchByCollegeid(Integer... values) {
        return fetch(Department_.DEPARTMENT_.COLLEGEID, values);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Department_> fetchByName(String... values) {
        return fetch(Department_.DEPARTMENT_.NAME, values);
    }

    /**
     * Fetch records that have <code>createdTime IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Department_> fetchByCreatedtime(Timestamp... values) {
        return fetch(Department_.DEPARTMENT_.CREATEDTIME, values);
    }

    /**
     * Fetch records that have <code>deleteStatus IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Department_> fetchByDeletestatus(Integer... values) {
        return fetch(Department_.DEPARTMENT_.DELETESTATUS, values);
    }

    /**
     * Fetch records that have <code>lastModifiedTime IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Department_> fetchByLastmodifiedtime(Timestamp... values) {
        return fetch(Department_.DEPARTMENT_.LASTMODIFIEDTIME, values);
    }
}
