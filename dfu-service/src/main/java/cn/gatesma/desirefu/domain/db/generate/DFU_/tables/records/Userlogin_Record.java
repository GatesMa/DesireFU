/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records;


import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Userlogin_;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 用户登录表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Userlogin_Record extends UpdatableRecordImpl<Userlogin_Record> implements Record9<Long, Long, String, Integer, Integer, Timestamp, Long, Long, Timestamp> {

    private static final long serialVersionUID = 139202468;

    /**
     * Setter for <code>DFU_.UserLogin_.id</code>. ID
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>DFU_.UserLogin_.id</code>. ID
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>DFU_.UserLogin_.userId</code>. 用户ID
     */
    public void setUserid(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>DFU_.UserLogin_.userId</code>. 用户ID
     */
    public Long getUserid() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>DFU_.UserLogin_.loginName</code>. 请求帐号时的登录名字或者Id
     */
    public void setLoginname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>DFU_.UserLogin_.loginName</code>. 请求帐号时的登录名字或者Id
     */
    public String getLoginname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>DFU_.UserLogin_.loginNameType</code>. 用户登录账号类型
     */
    public void setLoginnametype(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>DFU_.UserLogin_.loginNameType</code>. 用户登录账号类型
     */
    public Integer getLoginnametype() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>DFU_.UserLogin_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public void setDeletestatus(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>DFU_.UserLogin_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public Integer getDeletestatus() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>DFU_.UserLogin_.createdTime</code>. 创建时间
     */
    public void setCreatedtime(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>DFU_.UserLogin_.createdTime</code>. 创建时间
     */
    public Timestamp getCreatedtime() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>DFU_.UserLogin_.createdUserId</code>. 创建人ID
     */
    public void setCreateduserid(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>DFU_.UserLogin_.createdUserId</code>. 创建人ID
     */
    public Long getCreateduserid() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>DFU_.UserLogin_.lastModifiedUserId</code>. 最后修改人userId
     */
    public void setLastmodifieduserid(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>DFU_.UserLogin_.lastModifiedUserId</code>. 最后修改人userId
     */
    public Long getLastmodifieduserid() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>DFU_.UserLogin_.lastModifiedTime</code>. CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
     */
    public void setLastmodifiedtime(Timestamp value) {
        set(8, value);
    }

    /**
     * Getter for <code>DFU_.UserLogin_.lastModifiedTime</code>. CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
     */
    public Timestamp getLastmodifiedtime() {
        return (Timestamp) get(8);
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
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, Long, String, Integer, Integer, Timestamp, Long, Long, Timestamp> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, Long, String, Integer, Integer, Timestamp, Long, Long, Timestamp> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Userlogin_.USERLOGIN_.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Userlogin_.USERLOGIN_.USERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Userlogin_.USERLOGIN_.LOGINNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Userlogin_.USERLOGIN_.LOGINNAMETYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Userlogin_.USERLOGIN_.DELETESTATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Userlogin_.USERLOGIN_.CREATEDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return Userlogin_.USERLOGIN_.CREATEDUSERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return Userlogin_.USERLOGIN_.LASTMODIFIEDUSERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field9() {
        return Userlogin_.USERLOGIN_.LASTMODIFIEDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getLoginname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getLoginnametype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getDeletestatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getCreatedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component7() {
        return getCreateduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getLastmodifieduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component9() {
        return getLastmodifiedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getLoginname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getLoginnametype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getDeletestatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getCreatedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getCreateduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getLastmodifieduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value9() {
        return getLastmodifiedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Userlogin_Record value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Userlogin_Record value2(Long value) {
        setUserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Userlogin_Record value3(String value) {
        setLoginname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Userlogin_Record value4(Integer value) {
        setLoginnametype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Userlogin_Record value5(Integer value) {
        setDeletestatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Userlogin_Record value6(Timestamp value) {
        setCreatedtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Userlogin_Record value7(Long value) {
        setCreateduserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Userlogin_Record value8(Long value) {
        setLastmodifieduserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Userlogin_Record value9(Timestamp value) {
        setLastmodifiedtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Userlogin_Record values(Long value1, Long value2, String value3, Integer value4, Integer value5, Timestamp value6, Long value7, Long value8, Timestamp value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached Userlogin_Record
     */
    public Userlogin_Record() {
        super(Userlogin_.USERLOGIN_);
    }

    /**
     * Create a detached, initialised Userlogin_Record
     */
    public Userlogin_Record(Long id, Long userid, String loginname, Integer loginnametype, Integer deletestatus, Timestamp createdtime, Long createduserid, Long lastmodifieduserid, Timestamp lastmodifiedtime) {
        super(Userlogin_.USERLOGIN_);

        set(0, id);
        set(1, userid);
        set(2, loginname);
        set(3, loginnametype);
        set(4, deletestatus);
        set(5, createdtime);
        set(6, createduserid);
        set(7, lastmodifieduserid);
        set(8, lastmodifiedtime);
    }
}
