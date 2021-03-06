/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.daos;


import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Openidqqidx_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Openidqqidx_Record;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * 用于存储openId对应qq关联关系
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Openidqqidx_Dao extends DAOImpl<Openidqqidx_Record, cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Openidqqidx_, String> {

    /**
     * Create a new Openidqqidx_Dao without any configuration
     */
    public Openidqqidx_Dao() {
        super(Openidqqidx_.OPENIDQQIDX_, cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Openidqqidx_.class);
    }

    /**
     * Create a new Openidqqidx_Dao with an attached configuration
     */
    public Openidqqidx_Dao(Configuration configuration) {
        super(Openidqqidx_.OPENIDQQIDX_, cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Openidqqidx_.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Openidqqidx_ object) {
        return object.getOpenid();
    }

    /**
     * Fetch records that have <code>openId IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Openidqqidx_> fetchByOpenid(String... values) {
        return fetch(Openidqqidx_.OPENIDQQIDX_.OPENID, values);
    }

    /**
     * Fetch a unique record that has <code>openId = value</code>
     */
    public cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Openidqqidx_ fetchOneByOpenid(String value) {
        return fetchOne(Openidqqidx_.OPENIDQQIDX_.OPENID, value);
    }

    /**
     * Fetch records that have <code>qqNumber IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Openidqqidx_> fetchByQqnumber(String... values) {
        return fetch(Openidqqidx_.OPENIDQQIDX_.QQNUMBER, values);
    }

    /**
     * Fetch records that have <code>deleteStatus IN (values)</code>
     */
    public List<cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos.Openidqqidx_> fetchByDeletestatus(Integer... values) {
        return fetch(Openidqqidx_.OPENIDQQIDX_.DELETESTATUS, values);
    }
}
