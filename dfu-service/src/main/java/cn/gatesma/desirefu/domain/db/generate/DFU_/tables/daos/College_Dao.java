/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.daos;


import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.College_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.College_Record;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * 高校信息
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class College_Dao extends DAOImpl<College_Record, cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_, Integer> {

    /**
     * Create a new College_Dao without any configuration
     */
    public College_Dao() {
        super(College_.COLLEGE_, cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_.class);
    }

    /**
     * Create a new College_Dao with an attached configuration
     */
    public College_Dao(Configuration configuration) {
        super(College_.COLLEGE_, cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_ object) {
        return object.getCollegeid();
    }

    /**
     * Fetch records that have <code>collegeId IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_> fetchByCollegeid(Integer... values) {
        return fetch(College_.COLLEGE_.COLLEGEID, values);
    }

    /**
     * Fetch a unique record that has <code>collegeId = value</code>
     */
    public cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_ fetchOneByCollegeid(Integer value) {
        return fetchOne(College_.COLLEGE_.COLLEGEID, value);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_> fetchByName(String... values) {
        return fetch(College_.COLLEGE_.NAME, values);
    }

    /**
     * Fetch records that have <code>ministry IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_> fetchByMinistry(String... values) {
        return fetch(College_.COLLEGE_.MINISTRY, values);
    }

    /**
     * Fetch records that have <code>identification IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_> fetchByIdentification(String... values) {
        return fetch(College_.COLLEGE_.IDENTIFICATION, values);
    }

    /**
     * Fetch records that have <code>location IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_> fetchByLocation(String... values) {
        return fetch(College_.COLLEGE_.LOCATION, values);
    }

    /**
     * Fetch records that have <code>level IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_> fetchByLevel(String... values) {
        return fetch(College_.COLLEGE_.LEVEL, values);
    }

    /**
     * Fetch records that have <code>memo IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_> fetchByMemo(String... values) {
        return fetch(College_.COLLEGE_.MEMO, values);
    }

    /**
     * Fetch records that have <code>createdTime IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_> fetchByCreatedtime(Timestamp... values) {
        return fetch(College_.COLLEGE_.CREATEDTIME, values);
    }

    /**
     * Fetch records that have <code>deleteStatus IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_> fetchByDeletestatus(Integer... values) {
        return fetch(College_.COLLEGE_.DELETESTATUS, values);
    }

    /**
     * Fetch records that have <code>lastModifiedTime IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.College_> fetchByLastmodifiedtime(Timestamp... values) {
        return fetch(College_.COLLEGE_.LASTMODIFIEDTIME, values);
    }
}