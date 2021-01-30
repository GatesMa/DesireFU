/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables;


import cn.gatesma.desirefu.domain.db.generate.DFU_.Dfu_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Indexes;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Keys;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organizeaccountrelation_Record;

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
 * OrganizeAccount关系表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Organizeaccountrelation_ extends TableImpl<Organizeaccountrelation_Record> {

    private static final long serialVersionUID = -1356947385;

    /**
     * The reference instance of <code>DFU_.OrganizeAccountRelation_</code>
     */
    public static final Organizeaccountrelation_ ORGANIZEACCOUNTRELATION_ = new Organizeaccountrelation_();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Organizeaccountrelation_Record> getRecordType() {
        return Organizeaccountrelation_Record.class;
    }

    /**
     * The column <code>DFU_.OrganizeAccountRelation_.id</code>. 圈子Id
     */
    public final TableField<Organizeaccountrelation_Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "圈子Id");

    /**
     * The column <code>DFU_.OrganizeAccountRelation_.organizeId</code>. 关系中的organizeId
     */
    public final TableField<Organizeaccountrelation_Record, Long> ORGANIZEID = createField("organizeId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "关系中的organizeId");

    /**
     * The column <code>DFU_.OrganizeAccountRelation_.accountId</code>. 关系中的AccountID
     */
    public final TableField<Organizeaccountrelation_Record, Long> ACCOUNTID = createField("accountId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "关系中的AccountID");

    /**
     * The column <code>DFU_.OrganizeAccountRelation_.accountType</code>. 账号类型
     */
    public final TableField<Organizeaccountrelation_Record, Integer> ACCOUNTTYPE = createField("accountType", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "账号类型");

    /**
     * The column <code>DFU_.OrganizeAccountRelation_.isOwnerAccount</code>. accountId是否是开户账号
     */
    public final TableField<Organizeaccountrelation_Record, Integer> ISOWNERACCOUNT = createField("isOwnerAccount", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "accountId是否是开户账号");

    /**
     * The column <code>DFU_.OrganizeAccountRelation_.createdUserId</code>. 创建人userId
     */
    public final TableField<Organizeaccountrelation_Record, Long> CREATEDUSERID = createField("createdUserId", org.jooq.impl.SQLDataType.BIGINT, this, "创建人userId");

    /**
     * The column <code>DFU_.OrganizeAccountRelation_.createdTime</code>. 创建时间
     */
    public final TableField<Organizeaccountrelation_Record, Timestamp> CREATEDTIME = createField("createdTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "创建时间");

    /**
     * The column <code>DFU_.OrganizeAccountRelation_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public final TableField<Organizeaccountrelation_Record, Integer> DELETESTATUS = createField("deleteStatus", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "删除状态，0-正常，1-删除");

    /**
     * The column <code>DFU_.OrganizeAccountRelation_.lastModifiedUserId</code>. 最后修改人userId
     */
    public final TableField<Organizeaccountrelation_Record, Long> LASTMODIFIEDUSERID = createField("lastModifiedUserId", org.jooq.impl.SQLDataType.BIGINT, this, "最后修改人userId");

    /**
     * The column <code>DFU_.OrganizeAccountRelation_.lastModifiedTime</code>. lastModifiedTime
     */
    public final TableField<Organizeaccountrelation_Record, Timestamp> LASTMODIFIEDTIME = createField("lastModifiedTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "lastModifiedTime");

    /**
     * Create a <code>DFU_.OrganizeAccountRelation_</code> table reference
     */
    public Organizeaccountrelation_() {
        this(DSL.name("OrganizeAccountRelation_"), null);
    }

    /**
     * Create an aliased <code>DFU_.OrganizeAccountRelation_</code> table reference
     */
    public Organizeaccountrelation_(String alias) {
        this(DSL.name(alias), ORGANIZEACCOUNTRELATION_);
    }

    /**
     * Create an aliased <code>DFU_.OrganizeAccountRelation_</code> table reference
     */
    public Organizeaccountrelation_(Name alias) {
        this(alias, ORGANIZEACCOUNTRELATION_);
    }

    private Organizeaccountrelation_(Name alias, Table<Organizeaccountrelation_Record> aliased) {
        this(alias, aliased, null);
    }

    private Organizeaccountrelation_(Name alias, Table<Organizeaccountrelation_Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "OrganizeAccount关系表");
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
        return Arrays.<Index>asList(Indexes.ORGANIZEACCOUNTRELATION__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<Organizeaccountrelation_Record, Long> getIdentity() {
        return Keys.IDENTITY_ORGANIZEACCOUNTRELATION_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Organizeaccountrelation_Record> getPrimaryKey() {
        return Keys.KEY_ORGANIZEACCOUNTRELATION__PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Organizeaccountrelation_Record>> getKeys() {
        return Arrays.<UniqueKey<Organizeaccountrelation_Record>>asList(Keys.KEY_ORGANIZEACCOUNTRELATION__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organizeaccountrelation_ as(String alias) {
        return new Organizeaccountrelation_(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organizeaccountrelation_ as(Name alias) {
        return new Organizeaccountrelation_(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Organizeaccountrelation_ rename(String name) {
        return new Organizeaccountrelation_(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Organizeaccountrelation_ rename(Name name) {
        return new Organizeaccountrelation_(name, null);
    }
}