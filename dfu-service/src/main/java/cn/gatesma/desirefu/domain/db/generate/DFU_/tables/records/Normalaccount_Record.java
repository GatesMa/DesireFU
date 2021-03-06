/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records;


import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Normalaccount_;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 普通学生账号
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Normalaccount_Record extends UpdatableRecordImpl<Normalaccount_Record> implements Record12<Long, Integer, Integer, Integer, String, String, String, Long, Timestamp, Integer, Long, Timestamp> {

    private static final long serialVersionUID = 2059362744;

    /**
     * Setter for <code>DFU_.NormalAccount_.accountId</code>. 帐号ID
     */
    public void setAccountid(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>DFU_.NormalAccount_.accountId</code>. 帐号ID
     */
    public Long getAccountid() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>DFU_.NormalAccount_.accountType</code>. 账号类型
     */
    public void setAccounttype(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>DFU_.NormalAccount_.accountType</code>. 账号类型
     */
    public Integer getAccounttype() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>DFU_.NormalAccount_.collegeId</code>. 学校Id
     */
    public void setCollegeid(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>DFU_.NormalAccount_.collegeId</code>. 学校Id
     */
    public Integer getCollegeid() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>DFU_.NormalAccount_.departmentId</code>. 学院Id
     */
    public void setDepartmentid(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>DFU_.NormalAccount_.departmentId</code>. 学院Id
     */
    public Integer getDepartmentid() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>DFU_.NormalAccount_.major</code>. 专业
     */
    public void setMajor(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>DFU_.NormalAccount_.major</code>. 专业
     */
    public String getMajor() {
        return (String) get(4);
    }

    /**
     * Setter for <code>DFU_.NormalAccount_.stuId</code>. 学号
     */
    public void setStuid(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>DFU_.NormalAccount_.stuId</code>. 学号
     */
    public String getStuid() {
        return (String) get(5);
    }

    /**
     * Setter for <code>DFU_.NormalAccount_.realName</code>. 真实姓名
     */
    public void setRealname(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>DFU_.NormalAccount_.realName</code>. 真实姓名
     */
    public String getRealname() {
        return (String) get(6);
    }

    /**
     * Setter for <code>DFU_.NormalAccount_.createdUserId</code>. 创建人userId
     */
    public void setCreateduserid(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>DFU_.NormalAccount_.createdUserId</code>. 创建人userId
     */
    public Long getCreateduserid() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>DFU_.NormalAccount_.createdTime</code>. 创建时间
     */
    public void setCreatedtime(Timestamp value) {
        set(8, value);
    }

    /**
     * Getter for <code>DFU_.NormalAccount_.createdTime</code>. 创建时间
     */
    public Timestamp getCreatedtime() {
        return (Timestamp) get(8);
    }

    /**
     * Setter for <code>DFU_.NormalAccount_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public void setDeletestatus(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>DFU_.NormalAccount_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public Integer getDeletestatus() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>DFU_.NormalAccount_.lastModifiedUserId</code>. 最后修改人userId
     */
    public void setLastmodifieduserid(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>DFU_.NormalAccount_.lastModifiedUserId</code>. 最后修改人userId
     */
    public Long getLastmodifieduserid() {
        return (Long) get(10);
    }

    /**
     * Setter for <code>DFU_.NormalAccount_.lastModifiedTime</code>. lastModifiedTime
     */
    public void setLastmodifiedtime(Timestamp value) {
        set(11, value);
    }

    /**
     * Getter for <code>DFU_.NormalAccount_.lastModifiedTime</code>. lastModifiedTime
     */
    public Timestamp getLastmodifiedtime() {
        return (Timestamp) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<Long, Integer, Integer, Integer, String, String, String, Long, Timestamp, Integer, Long, Timestamp> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<Long, Integer, Integer, Integer, String, String, String, Long, Timestamp, Integer, Long, Timestamp> valuesRow() {
        return (Row12) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Normalaccount_.NORMALACCOUNT_.ACCOUNTID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Normalaccount_.NORMALACCOUNT_.ACCOUNTTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Normalaccount_.NORMALACCOUNT_.COLLEGEID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Normalaccount_.NORMALACCOUNT_.DEPARTMENTID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Normalaccount_.NORMALACCOUNT_.MAJOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Normalaccount_.NORMALACCOUNT_.STUID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Normalaccount_.NORMALACCOUNT_.REALNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return Normalaccount_.NORMALACCOUNT_.CREATEDUSERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field9() {
        return Normalaccount_.NORMALACCOUNT_.CREATEDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field10() {
        return Normalaccount_.NORMALACCOUNT_.DELETESTATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field11() {
        return Normalaccount_.NORMALACCOUNT_.LASTMODIFIEDUSERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field12() {
        return Normalaccount_.NORMALACCOUNT_.LASTMODIFIEDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getAccountid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getAccounttype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getCollegeid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getDepartmentid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getMajor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getStuid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getRealname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getCreateduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component9() {
        return getCreatedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component10() {
        return getDeletestatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component11() {
        return getLastmodifieduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component12() {
        return getLastmodifiedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getAccountid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getAccounttype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getCollegeid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getDepartmentid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getMajor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getStuid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getRealname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getCreateduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value9() {
        return getCreatedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value10() {
        return getDeletestatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value11() {
        return getLastmodifieduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value12() {
        return getLastmodifiedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record value1(Long value) {
        setAccountid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record value2(Integer value) {
        setAccounttype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record value3(Integer value) {
        setCollegeid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record value4(Integer value) {
        setDepartmentid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record value5(String value) {
        setMajor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record value6(String value) {
        setStuid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record value7(String value) {
        setRealname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record value8(Long value) {
        setCreateduserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record value9(Timestamp value) {
        setCreatedtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record value10(Integer value) {
        setDeletestatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record value11(Long value) {
        setLastmodifieduserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record value12(Timestamp value) {
        setLastmodifiedtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalaccount_Record values(Long value1, Integer value2, Integer value3, Integer value4, String value5, String value6, String value7, Long value8, Timestamp value9, Integer value10, Long value11, Timestamp value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached Normalaccount_Record
     */
    public Normalaccount_Record() {
        super(Normalaccount_.NORMALACCOUNT_);
    }

    /**
     * Create a detached, initialised Normalaccount_Record
     */
    public Normalaccount_Record(Long accountid, Integer accounttype, Integer collegeid, Integer departmentid, String major, String stuid, String realname, Long createduserid, Timestamp createdtime, Integer deletestatus, Long lastmodifieduserid, Timestamp lastmodifiedtime) {
        super(Normalaccount_.NORMALACCOUNT_);

        set(0, accountid);
        set(1, accounttype);
        set(2, collegeid);
        set(3, departmentid);
        set(4, major);
        set(5, stuid);
        set(6, realname);
        set(7, createduserid);
        set(8, createdtime);
        set(9, deletestatus);
        set(10, lastmodifieduserid);
        set(11, lastmodifiedtime);
    }
}
