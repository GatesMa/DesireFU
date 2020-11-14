/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records;


import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.User_;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User_Record extends UpdatableRecordImpl<User_Record> implements Record9<Long, String, String, String, Timestamp, Integer, Long, Timestamp, Long> {

    private static final long serialVersionUID = -1933488011;

    /**
     * Setter for <code>DFU_.User_.userId</code>. 用户ID
     */
    public void setUserid(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>DFU_.User_.userId</code>. 用户ID
     */
    public Long getUserid() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>DFU_.User_.userName</code>. userName
     */
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>DFU_.User_.userName</code>. userName
     */
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>DFU_.User_.cellphone</code>. 手机号
     */
    public void setCellphone(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>DFU_.User_.cellphone</code>. 手机号
     */
    public String getCellphone() {
        return (String) get(2);
    }

    /**
     * Setter for <code>DFU_.User_.email</code>. 邮箱地址
     */
    public void setEmail(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>DFU_.User_.email</code>. 邮箱地址
     */
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>DFU_.User_.createdTime</code>. 创建时间
     */
    public void setCreatedtime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>DFU_.User_.createdTime</code>. 创建时间
     */
    public Timestamp getCreatedtime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>DFU_.User_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public void setDeletestatus(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>DFU_.User_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public Integer getDeletestatus() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>DFU_.User_.lastModifiedUserId</code>. 最后修改人userId
     */
    public void setLastmodifieduserid(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>DFU_.User_.lastModifiedUserId</code>. 最后修改人userId
     */
    public Long getLastmodifieduserid() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>DFU_.User_.lastModifiedTime</code>. CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
     */
    public void setLastmodifiedtime(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>DFU_.User_.lastModifiedTime</code>. CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
     */
    public Timestamp getLastmodifiedtime() {
        return (Timestamp) get(7);
    }

    /**
     * Setter for <code>DFU_.User_.createdUserId</code>. 创建者userId
     */
    public void setCreateduserid(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>DFU_.User_.createdUserId</code>. 创建者userId
     */
    public Long getCreateduserid() {
        return (Long) get(8);
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
    public Row9<Long, String, String, String, Timestamp, Integer, Long, Timestamp, Long> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, String, String, String, Timestamp, Integer, Long, Timestamp, Long> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return User_.USER_.USERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return User_.USER_.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return User_.USER_.CELLPHONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return User_.USER_.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return User_.USER_.CREATEDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return User_.USER_.DELETESTATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return User_.USER_.LASTMODIFIEDUSERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return User_.USER_.LASTMODIFIEDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field9() {
        return User_.USER_.CREATEDUSERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getCellphone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getCreatedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getDeletestatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component7() {
        return getLastmodifieduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component8() {
        return getLastmodifiedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component9() {
        return getCreateduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getCellphone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getCreatedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getDeletestatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getLastmodifieduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getLastmodifiedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value9() {
        return getCreateduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User_Record value1(Long value) {
        setUserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User_Record value2(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User_Record value3(String value) {
        setCellphone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User_Record value4(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User_Record value5(Timestamp value) {
        setCreatedtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User_Record value6(Integer value) {
        setDeletestatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User_Record value7(Long value) {
        setLastmodifieduserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User_Record value8(Timestamp value) {
        setLastmodifiedtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User_Record value9(Long value) {
        setCreateduserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User_Record values(Long value1, String value2, String value3, String value4, Timestamp value5, Integer value6, Long value7, Timestamp value8, Long value9) {
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
     * Create a detached User_Record
     */
    public User_Record() {
        super(User_.USER_);
    }

    /**
     * Create a detached, initialised User_Record
     */
    public User_Record(Long userid, String username, String cellphone, String email, Timestamp createdtime, Integer deletestatus, Long lastmodifieduserid, Timestamp lastmodifiedtime, Long createduserid) {
        super(User_.USER_);

        set(0, userid);
        set(1, username);
        set(2, cellphone);
        set(3, email);
        set(4, createdtime);
        set(5, deletestatus);
        set(6, lastmodifieduserid);
        set(7, lastmodifiedtime);
        set(8, createduserid);
    }
}