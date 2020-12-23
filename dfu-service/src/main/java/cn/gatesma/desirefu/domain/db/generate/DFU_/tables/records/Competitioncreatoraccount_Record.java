/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records;


import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Competitioncreatoraccount_;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 比赛创建者账号
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Competitioncreatoraccount_Record extends UpdatableRecordImpl<Competitioncreatoraccount_Record> implements Record8<Long, Integer, String, Long, Timestamp, Integer, Long, Timestamp> {

    private static final long serialVersionUID = -258994965;

    /**
     * Setter for <code>DFU_.CompetitionCreatorAccount_.accountId</code>. 帐号ID
     */
    public void setAccountid(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>DFU_.CompetitionCreatorAccount_.accountId</code>. 帐号ID
     */
    public Long getAccountid() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>DFU_.CompetitionCreatorAccount_.accountType</code>. 账号类型
     */
    public void setAccounttype(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>DFU_.CompetitionCreatorAccount_.accountType</code>. 账号类型
     */
    public Integer getAccounttype() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>DFU_.CompetitionCreatorAccount_.author</code>. 可以创建比赛的权限
     */
    public void setAuthor(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>DFU_.CompetitionCreatorAccount_.author</code>. 可以创建比赛的权限
     */
    public String getAuthor() {
        return (String) get(2);
    }

    /**
     * Setter for <code>DFU_.CompetitionCreatorAccount_.createdUserId</code>. 创建人userId
     */
    public void setCreateduserid(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>DFU_.CompetitionCreatorAccount_.createdUserId</code>. 创建人userId
     */
    public Long getCreateduserid() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>DFU_.CompetitionCreatorAccount_.createdTime</code>. 创建时间
     */
    public void setCreatedtime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>DFU_.CompetitionCreatorAccount_.createdTime</code>. 创建时间
     */
    public Timestamp getCreatedtime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>DFU_.CompetitionCreatorAccount_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public void setDeletestatus(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>DFU_.CompetitionCreatorAccount_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public Integer getDeletestatus() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>DFU_.CompetitionCreatorAccount_.lastModifiedUserId</code>. 最后修改人userId
     */
    public void setLastmodifieduserid(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>DFU_.CompetitionCreatorAccount_.lastModifiedUserId</code>. 最后修改人userId
     */
    public Long getLastmodifieduserid() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>DFU_.CompetitionCreatorAccount_.lastModifiedTime</code>. lastModifiedTime
     */
    public void setLastmodifiedtime(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>DFU_.CompetitionCreatorAccount_.lastModifiedTime</code>. lastModifiedTime
     */
    public Timestamp getLastmodifiedtime() {
        return (Timestamp) get(7);
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
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, Integer, String, Long, Timestamp, Integer, Long, Timestamp> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, Integer, String, Long, Timestamp, Integer, Long, Timestamp> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_.ACCOUNTID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_.ACCOUNTTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_.AUTHOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field4() {
        return Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_.CREATEDUSERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_.CREATEDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_.DELETESTATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_.LASTMODIFIEDUSERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_.LASTMODIFIEDTIME;
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
    public String component3() {
        return getAuthor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component4() {
        return getCreateduserid();
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
    public String value3() {
        return getAuthor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value4() {
        return getCreateduserid();
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
    public Competitioncreatoraccount_Record value1(Long value) {
        setAccountid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Competitioncreatoraccount_Record value2(Integer value) {
        setAccounttype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Competitioncreatoraccount_Record value3(String value) {
        setAuthor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Competitioncreatoraccount_Record value4(Long value) {
        setCreateduserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Competitioncreatoraccount_Record value5(Timestamp value) {
        setCreatedtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Competitioncreatoraccount_Record value6(Integer value) {
        setDeletestatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Competitioncreatoraccount_Record value7(Long value) {
        setLastmodifieduserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Competitioncreatoraccount_Record value8(Timestamp value) {
        setLastmodifiedtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Competitioncreatoraccount_Record values(Long value1, Integer value2, String value3, Long value4, Timestamp value5, Integer value6, Long value7, Timestamp value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached Competitioncreatoraccount_Record
     */
    public Competitioncreatoraccount_Record() {
        super(Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_);
    }

    /**
     * Create a detached, initialised Competitioncreatoraccount_Record
     */
    public Competitioncreatoraccount_Record(Long accountid, Integer accounttype, String author, Long createduserid, Timestamp createdtime, Integer deletestatus, Long lastmodifieduserid, Timestamp lastmodifiedtime) {
        super(Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_);

        set(0, accountid);
        set(1, accounttype);
        set(2, author);
        set(3, createduserid);
        set(4, createdtime);
        set(5, deletestatus);
        set(6, lastmodifieduserid);
        set(7, lastmodifiedtime);
    }
}
