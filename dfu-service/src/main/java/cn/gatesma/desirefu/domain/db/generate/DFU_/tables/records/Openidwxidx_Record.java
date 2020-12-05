/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records;


import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Openidwxidx_;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 用于存储openId对应wx关联关系
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Openidwxidx_Record extends UpdatableRecordImpl<Openidwxidx_Record> implements Record3<String, String, Integer> {

    private static final long serialVersionUID = -332538109;

    /**
     * Setter for <code>dfu_.openidwxidx_.openId</code>. wx对应生成的openId
     */
    public void setOpenid(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>dfu_.openidwxidx_.openId</code>. wx对应生成的openId
     */
    public String getOpenid() {
        return (String) get(0);
    }

    /**
     * Setter for <code>dfu_.openidwxidx_.wxId</code>. 微信ID
     */
    public void setWxid(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>dfu_.openidwxidx_.wxId</code>. 微信ID
     */
    public String getWxid() {
        return (String) get(1);
    }

    /**
     * Setter for <code>dfu_.openidwxidx_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public void setDeletestatus(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>dfu_.openidwxidx_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public Integer getDeletestatus() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Openidwxidx_.OPENIDWXIDX_.OPENID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Openidwxidx_.OPENIDWXIDX_.WXID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Openidwxidx_.OPENIDWXIDX_.DELETESTATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getOpenid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getWxid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getDeletestatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getOpenid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getWxid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getDeletestatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Openidwxidx_Record value1(String value) {
        setOpenid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Openidwxidx_Record value2(String value) {
        setWxid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Openidwxidx_Record value3(Integer value) {
        setDeletestatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Openidwxidx_Record values(String value1, String value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached Openidwxidx_Record
     */
    public Openidwxidx_Record() {
        super(Openidwxidx_.OPENIDWXIDX_);
    }

    /**
     * Create a detached, initialised Openidwxidx_Record
     */
    public Openidwxidx_Record(String openid, String wxid, Integer deletestatus) {
        super(Openidwxidx_.OPENIDWXIDX_);

        set(0, openid);
        set(1, wxid);
        set(2, deletestatus);
    }
}
