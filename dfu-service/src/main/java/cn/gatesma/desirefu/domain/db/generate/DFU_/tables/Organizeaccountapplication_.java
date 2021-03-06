/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables;


import cn.gatesma.desirefu.domain.db.generate.DFU_.Dfu_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Indexes;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Keys;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organizeaccountapplication_Record;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 圈子申请信息表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Organizeaccountapplication_ extends TableImpl<Organizeaccountapplication_Record> {

    private static final long serialVersionUID = -602679199;

    /**
     * The reference instance of <code>DFU_.OrganizeAccountApplication_</code>
     */
    public static final Organizeaccountapplication_ ORGANIZEACCOUNTAPPLICATION_ = new Organizeaccountapplication_();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Organizeaccountapplication_Record> getRecordType() {
        return Organizeaccountapplication_Record.class;
    }

    /**
     * The column <code>DFU_.OrganizeAccountApplication_.id</code>. Id
     */
    public final TableField<Organizeaccountapplication_Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "Id");

    /**
     * The column <code>DFU_.OrganizeAccountApplication_.organizeId</code>. 关系中的organizeId
     */
    public final TableField<Organizeaccountapplication_Record, Long> ORGANIZEID = createField("organizeId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "关系中的organizeId");

    /**
     * The column <code>DFU_.OrganizeAccountApplication_.accountId</code>. 关系中的AccountID
     */
    public final TableField<Organizeaccountapplication_Record, Long> ACCOUNTID = createField("accountId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "关系中的AccountID");

    /**
     * The column <code>DFU_.OrganizeAccountApplication_.accountType</code>. 账号类型
     */
    public final TableField<Organizeaccountapplication_Record, Integer> ACCOUNTTYPE = createField("accountType", org.jooq.impl.SQLDataType.INTEGER, this, "账号类型");

    /**
     * The column <code>DFU_.OrganizeAccountApplication_.status</code>. 申请状态 0:申请中;1:申请成功;2:客户拒绝;3:用户取消;4:申请过期;
     */
    public final TableField<Organizeaccountapplication_Record, Integer> STATUS = createField("status", org.jooq.impl.SQLDataType.INTEGER, this, "申请状态 0:申请中;1:申请成功;2:客户拒绝;3:用户取消;4:申请过期;");

    /**
     * The column <code>DFU_.OrganizeAccountApplication_.createdUserId</code>. 创建人userId
     */
    public final TableField<Organizeaccountapplication_Record, Long> CREATEDUSERID = createField("createdUserId", org.jooq.impl.SQLDataType.BIGINT, this, "创建人userId");

    /**
     * The column <code>DFU_.OrganizeAccountApplication_.createdTime</code>. 创建时间
     */
    public final TableField<Organizeaccountapplication_Record, Timestamp> CREATEDTIME = createField("createdTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "创建时间");

    /**
     * The column <code>DFU_.OrganizeAccountApplication_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public final TableField<Organizeaccountapplication_Record, Integer> DELETESTATUS = createField("deleteStatus", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "删除状态，0-正常，1-删除");

    /**
     * The column <code>DFU_.OrganizeAccountApplication_.lastModifiedUserId</code>. 最后修改人userId
     */
    public final TableField<Organizeaccountapplication_Record, Long> LASTMODIFIEDUSERID = createField("lastModifiedUserId", org.jooq.impl.SQLDataType.BIGINT, this, "最后修改人userId");

    /**
     * The column <code>DFU_.OrganizeAccountApplication_.lastModifiedTime</code>. lastModifiedTime
     */
    public final TableField<Organizeaccountapplication_Record, Timestamp> LASTMODIFIEDTIME = createField("lastModifiedTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "lastModifiedTime");

    /**
     * Create a <code>DFU_.OrganizeAccountApplication_</code> table reference
     */
    public Organizeaccountapplication_() {
        this(DSL.name("OrganizeAccountApplication_"), null);
    }

    /**
     * Create an aliased <code>DFU_.OrganizeAccountApplication_</code> table reference
     */
    public Organizeaccountapplication_(String alias) {
        this(DSL.name(alias), ORGANIZEACCOUNTAPPLICATION_);
    }

    /**
     * Create an aliased <code>DFU_.OrganizeAccountApplication_</code> table reference
     */
    public Organizeaccountapplication_(Name alias) {
        this(alias, ORGANIZEACCOUNTAPPLICATION_);
    }

    private Organizeaccountapplication_(Name alias, Table<Organizeaccountapplication_Record> aliased) {
        this(alias, aliased, null);
    }

    private Organizeaccountapplication_(Name alias, Table<Organizeaccountapplication_Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "圈子申请信息表");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Dfu_.DFU_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ORGANIZEACCOUNTAPPLICATION__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<Organizeaccountapplication_Record, Long> getIdentity() {
        return Keys.IDENTITY_ORGANIZEACCOUNTAPPLICATION_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Organizeaccountapplication_Record> getPrimaryKey() {
        return Keys.KEY_ORGANIZEACCOUNTAPPLICATION__PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Organizeaccountapplication_Record>> getKeys() {
        return Arrays.<UniqueKey<Organizeaccountapplication_Record>>asList(Keys.KEY_ORGANIZEACCOUNTAPPLICATION__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organizeaccountapplication_ as(String alias) {
        return new Organizeaccountapplication_(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organizeaccountapplication_ as(Name alias) {
        return new Organizeaccountapplication_(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Organizeaccountapplication_ rename(String name) {
        return new Organizeaccountapplication_(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Organizeaccountapplication_ rename(Name name) {
        return new Organizeaccountapplication_(name, null);
    }
}
