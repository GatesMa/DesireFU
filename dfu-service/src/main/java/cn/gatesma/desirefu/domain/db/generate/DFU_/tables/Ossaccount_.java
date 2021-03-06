/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables;


import cn.gatesma.desirefu.domain.db.generate.DFU_.Dfu_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Indexes;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Keys;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Ossaccount_Record;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Ossaccount_ extends TableImpl<Ossaccount_Record> {

    private static final long serialVersionUID = -764274139;

    /**
     * The reference instance of <code>DFU_.OSSAccount_</code>
     */
    public static final Ossaccount_ OSSACCOUNT_ = new Ossaccount_();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Ossaccount_Record> getRecordType() {
        return Ossaccount_Record.class;
    }

    /**
     * The column <code>DFU_.OSSAccount_.accountId</code>. 帐号ID
     */
    public final TableField<Ossaccount_Record, Long> ACCOUNTID = createField("accountId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "帐号ID");

    /**
     * The column <code>DFU_.OSSAccount_.accountType</code>. 账号类型
     */
    public final TableField<Ossaccount_Record, Integer> ACCOUNTTYPE = createField("accountType", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "账号类型");

    /**
     * The column <code>DFU_.OSSAccount_.type</code>. 什么类型的运营账号，操作者观察者
     */
    public final TableField<Ossaccount_Record, Integer> TYPE = createField("type", org.jooq.impl.SQLDataType.INTEGER, this, "什么类型的运营账号，操作者观察者");

    /**
     * The column <code>DFU_.OSSAccount_.createdUserId</code>. 创建人userId
     */
    public final TableField<Ossaccount_Record, Long> CREATEDUSERID = createField("createdUserId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "创建人userId");

    /**
     * The column <code>DFU_.OSSAccount_.createdTime</code>. 创建时间
     */
    public final TableField<Ossaccount_Record, Timestamp> CREATEDTIME = createField("createdTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "创建时间");

    /**
     * The column <code>DFU_.OSSAccount_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public final TableField<Ossaccount_Record, Integer> DELETESTATUS = createField("deleteStatus", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "删除状态，0-正常，1-删除");

    /**
     * The column <code>DFU_.OSSAccount_.lastModifiedUserId</code>. 最后修改人userId
     */
    public final TableField<Ossaccount_Record, Long> LASTMODIFIEDUSERID = createField("lastModifiedUserId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "最后修改人userId");

    /**
     * The column <code>DFU_.OSSAccount_.lastModifiedTime</code>. lastModifiedTime
     */
    public final TableField<Ossaccount_Record, Timestamp> LASTMODIFIEDTIME = createField("lastModifiedTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "lastModifiedTime");

    /**
     * Create a <code>DFU_.OSSAccount_</code> table reference
     */
    public Ossaccount_() {
        this(DSL.name("OSSAccount_"), null);
    }

    /**
     * Create an aliased <code>DFU_.OSSAccount_</code> table reference
     */
    public Ossaccount_(String alias) {
        this(DSL.name(alias), OSSACCOUNT_);
    }

    /**
     * Create an aliased <code>DFU_.OSSAccount_</code> table reference
     */
    public Ossaccount_(Name alias) {
        this(alias, OSSACCOUNT_);
    }

    private Ossaccount_(Name alias, Table<Ossaccount_Record> aliased) {
        this(alias, aliased, null);
    }

    private Ossaccount_(Name alias, Table<Ossaccount_Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "OSS运营人员账号");
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
        return Arrays.<Index>asList(Indexes.OSSACCOUNT__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Ossaccount_Record> getPrimaryKey() {
        return Keys.KEY_OSSACCOUNT__PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Ossaccount_Record>> getKeys() {
        return Arrays.<UniqueKey<Ossaccount_Record>>asList(Keys.KEY_OSSACCOUNT__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ossaccount_ as(String alias) {
        return new Ossaccount_(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ossaccount_ as(Name alias) {
        return new Ossaccount_(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Ossaccount_ rename(String name) {
        return new Ossaccount_(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Ossaccount_ rename(Name name) {
        return new Ossaccount_(name, null);
    }
}
