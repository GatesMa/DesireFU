/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records;


import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Account_;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record14;
import org.jooq.Row14;
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
public class Account_Record extends UpdatableRecordImpl<Account_Record> implements Record14<Long, Integer, String, Integer, Integer, String, Long, String, Timestamp, Long, Timestamp, Integer, Long, Timestamp> {

    private static final long serialVersionUID = 1448989133;

    /**
     * Setter for <code>DFU_.Account_.accountId</code>. 帐号ID
     */
    public void setAccountid(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>DFU_.Account_.accountId</code>. 帐号ID
     */
    public Long getAccountid() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>DFU_.Account_.accountType</code>. 账号类型
     */
    public void setAccounttype(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>DFU_.Account_.accountType</code>. 账号类型
     */
    public Integer getAccounttype() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>DFU_.Account_.nickName</code>. 账号昵称
     */
    public void setNickname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>DFU_.Account_.nickName</code>. 账号昵称
     */
    public String getNickname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>DFU_.Account_.accountStatus</code>. 账号状态
     */
    public void setAccountstatus(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>DFU_.Account_.accountStatus</code>. 账号状态
     */
    public Integer getAccountstatus() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>DFU_.Account_.approvalStatus</code>. 审核状态
     */
    public void setApprovalstatus(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>DFU_.Account_.approvalStatus</code>. 审核状态
     */
    public Integer getApprovalstatus() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>DFU_.Account_.memo</code>. 备注
     */
    public void setMemo(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>DFU_.Account_.memo</code>. 备注
     */
    public String getMemo() {
        return (String) get(5);
    }

    /**
     * Setter for <code>DFU_.Account_.auditUserId</code>. 审核人userId
     */
    public void setAudituserid(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>DFU_.Account_.auditUserId</code>. 审核人userId
     */
    public Long getAudituserid() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>DFU_.Account_.auditMsg</code>. 审核结果信息
     */
    public void setAuditmsg(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>DFU_.Account_.auditMsg</code>. 审核结果信息
     */
    public String getAuditmsg() {
        return (String) get(7);
    }

    /**
     * Setter for <code>DFU_.Account_.auditedTime</code>. 审核时间
     */
    public void setAuditedtime(Timestamp value) {
        set(8, value);
    }

    /**
     * Getter for <code>DFU_.Account_.auditedTime</code>. 审核时间
     */
    public Timestamp getAuditedtime() {
        return (Timestamp) get(8);
    }

    /**
     * Setter for <code>DFU_.Account_.createdUserId</code>. 创建人userId
     */
    public void setCreateduserid(Long value) {
        set(9, value);
    }

    /**
     * Getter for <code>DFU_.Account_.createdUserId</code>. 创建人userId
     */
    public Long getCreateduserid() {
        return (Long) get(9);
    }

    /**
     * Setter for <code>DFU_.Account_.createdTime</code>. 创建时间
     */
    public void setCreatedtime(Timestamp value) {
        set(10, value);
    }

    /**
     * Getter for <code>DFU_.Account_.createdTime</code>. 创建时间
     */
    public Timestamp getCreatedtime() {
        return (Timestamp) get(10);
    }

    /**
     * Setter for <code>DFU_.Account_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public void setDeletestatus(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>DFU_.Account_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public Integer getDeletestatus() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>DFU_.Account_.lastModifiedUserId</code>. 最后修改人userId
     */
    public void setLastmodifieduserid(Long value) {
        set(12, value);
    }

    /**
     * Getter for <code>DFU_.Account_.lastModifiedUserId</code>. 最后修改人userId
     */
    public Long getLastmodifieduserid() {
        return (Long) get(12);
    }

    /**
     * Setter for <code>DFU_.Account_.lastModifiedTime</code>. CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
     */
    public void setLastmodifiedtime(Timestamp value) {
        set(13, value);
    }

    /**
     * Getter for <code>DFU_.Account_.lastModifiedTime</code>. CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
     */
    public Timestamp getLastmodifiedtime() {
        return (Timestamp) get(13);
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
    // Record14 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<Long, Integer, String, Integer, Integer, String, Long, String, Timestamp, Long, Timestamp, Integer, Long, Timestamp> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<Long, Integer, String, Integer, Integer, String, Long, String, Timestamp, Long, Timestamp, Integer, Long, Timestamp> valuesRow() {
        return (Row14) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Account_.ACCOUNT_.ACCOUNTID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Account_.ACCOUNT_.ACCOUNTTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Account_.ACCOUNT_.NICKNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Account_.ACCOUNT_.ACCOUNTSTATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Account_.ACCOUNT_.APPROVALSTATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Account_.ACCOUNT_.MEMO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return Account_.ACCOUNT_.AUDITUSERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Account_.ACCOUNT_.AUDITMSG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field9() {
        return Account_.ACCOUNT_.AUDITEDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field10() {
        return Account_.ACCOUNT_.CREATEDUSERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field11() {
        return Account_.ACCOUNT_.CREATEDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field12() {
        return Account_.ACCOUNT_.DELETESTATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field13() {
        return Account_.ACCOUNT_.LASTMODIFIEDUSERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field14() {
        return Account_.ACCOUNT_.LASTMODIFIEDTIME;
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
        return getNickname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getAccountstatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getApprovalstatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getMemo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component7() {
        return getAudituserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getAuditmsg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component9() {
        return getAuditedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component10() {
        return getCreateduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component11() {
        return getCreatedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component12() {
        return getDeletestatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component13() {
        return getLastmodifieduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component14() {
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
        return getNickname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getAccountstatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getApprovalstatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getMemo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getAudituserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getAuditmsg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value9() {
        return getAuditedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value10() {
        return getCreateduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value11() {
        return getCreatedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value12() {
        return getDeletestatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value13() {
        return getLastmodifieduserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value14() {
        return getLastmodifiedtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value1(Long value) {
        setAccountid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value2(Integer value) {
        setAccounttype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value3(String value) {
        setNickname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value4(Integer value) {
        setAccountstatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value5(Integer value) {
        setApprovalstatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value6(String value) {
        setMemo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value7(Long value) {
        setAudituserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value8(String value) {
        setAuditmsg(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value9(Timestamp value) {
        setAuditedtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value10(Long value) {
        setCreateduserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value11(Timestamp value) {
        setCreatedtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value12(Integer value) {
        setDeletestatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value13(Long value) {
        setLastmodifieduserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record value14(Timestamp value) {
        setLastmodifiedtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account_Record values(Long value1, Integer value2, String value3, Integer value4, Integer value5, String value6, Long value7, String value8, Timestamp value9, Long value10, Timestamp value11, Integer value12, Long value13, Timestamp value14) {
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
        value13(value13);
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached Account_Record
     */
    public Account_Record() {
        super(Account_.ACCOUNT_);
    }

    /**
     * Create a detached, initialised Account_Record
     */
    public Account_Record(Long accountid, Integer accounttype, String nickname, Integer accountstatus, Integer approvalstatus, String memo, Long audituserid, String auditmsg, Timestamp auditedtime, Long createduserid, Timestamp createdtime, Integer deletestatus, Long lastmodifieduserid, Timestamp lastmodifiedtime) {
        super(Account_.ACCOUNT_);

        set(0, accountid);
        set(1, accounttype);
        set(2, nickname);
        set(3, accountstatus);
        set(4, approvalstatus);
        set(5, memo);
        set(6, audituserid);
        set(7, auditmsg);
        set(8, auditedtime);
        set(9, createduserid);
        set(10, createdtime);
        set(11, deletestatus);
        set(12, lastmodifieduserid);
        set(13, lastmodifiedtime);
    }
}