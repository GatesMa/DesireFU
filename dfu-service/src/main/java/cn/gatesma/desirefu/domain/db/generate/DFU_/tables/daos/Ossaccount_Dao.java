/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.daos;


import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Ossaccount_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Ossaccount_Record;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * OSS运营人员账号
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Ossaccount_Dao extends DAOImpl<Ossaccount_Record, cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_, Long> {

    /**
     * Create a new Ossaccount_Dao without any configuration
     */
    public Ossaccount_Dao() {
        super(Ossaccount_.OSSACCOUNT_, cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_.class);
    }

    /**
     * Create a new Ossaccount_Dao with an attached configuration
     */
    public Ossaccount_Dao(Configuration configuration) {
        super(Ossaccount_.OSSACCOUNT_, cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_ object) {
        return object.getAccountid();
    }

    /**
     * Fetch records that have <code>accountId IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_> fetchByAccountid(Long... values) {
        return fetch(Ossaccount_.OSSACCOUNT_.ACCOUNTID, values);
    }

    /**
     * Fetch a unique record that has <code>accountId = value</code>
     */
    public cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_ fetchOneByAccountid(Long value) {
        return fetchOne(Ossaccount_.OSSACCOUNT_.ACCOUNTID, value);
    }

    /**
     * Fetch records that have <code>accountType IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_> fetchByAccounttype(Integer... values) {
        return fetch(Ossaccount_.OSSACCOUNT_.ACCOUNTTYPE, values);
    }

    /**
     * Fetch records that have <code>type IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_> fetchByType(Integer... values) {
        return fetch(Ossaccount_.OSSACCOUNT_.TYPE, values);
    }

    /**
     * Fetch records that have <code>createdUserId IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_> fetchByCreateduserid(Long... values) {
        return fetch(Ossaccount_.OSSACCOUNT_.CREATEDUSERID, values);
    }

    /**
     * Fetch records that have <code>createdTime IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_> fetchByCreatedtime(Timestamp... values) {
        return fetch(Ossaccount_.OSSACCOUNT_.CREATEDTIME, values);
    }

    /**
     * Fetch records that have <code>deleteStatus IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_> fetchByDeletestatus(Integer... values) {
        return fetch(Ossaccount_.OSSACCOUNT_.DELETESTATUS, values);
    }

    /**
     * Fetch records that have <code>lastModifiedUserId IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_> fetchByLastmodifieduserid(Long... values) {
        return fetch(Ossaccount_.OSSACCOUNT_.LASTMODIFIEDUSERID, values);
    }

    /**
     * Fetch records that have <code>lastModifiedTime IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Ossaccount_> fetchByLastmodifiedtime(Timestamp... values) {
        return fetch(Ossaccount_.OSSACCOUNT_.LASTMODIFIEDTIME, values);
    }
}
