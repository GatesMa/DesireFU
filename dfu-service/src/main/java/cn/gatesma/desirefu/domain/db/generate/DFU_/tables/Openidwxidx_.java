/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables;


import cn.gatesma.desirefu.domain.db.generate.DFU_.Dfu_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Indexes;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Keys;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Openidwxidx_Record;

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
public class Openidwxidx_ extends TableImpl<Openidwxidx_Record> {

    private static final long serialVersionUID = -1413659711;

    /**
     * The reference instance of <code>DFU_.OpenIdWXIdx_</code>
     */
    public static final Openidwxidx_ OPENIDWXIDX_ = new Openidwxidx_();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Openidwxidx_Record> getRecordType() {
        return Openidwxidx_Record.class;
    }

    /**
     * The column <code>DFU_.OpenIdWXIdx_.openId</code>. wx对应生成的openId
     */
    public final TableField<Openidwxidx_Record, String> OPENID = createField("openId", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "wx对应生成的openId");

    /**
     * The column <code>DFU_.OpenIdWXIdx_.wxId</code>. 微信ID
     */
    public final TableField<Openidwxidx_Record, String> WXID = createField("wxId", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "微信ID");

    /**
     * The column <code>DFU_.OpenIdWXIdx_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public final TableField<Openidwxidx_Record, Integer> DELETESTATUS = createField("deleteStatus", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "删除状态，0-正常，1-删除");

    /**
     * Create a <code>DFU_.OpenIdWXIdx_</code> table reference
     */
    public Openidwxidx_() {
        this(DSL.name("OpenIdWXIdx_"), null);
    }

    /**
     * Create an aliased <code>DFU_.OpenIdWXIdx_</code> table reference
     */
    public Openidwxidx_(String alias) {
        this(DSL.name(alias), OPENIDWXIDX_);
    }

    /**
     * Create an aliased <code>DFU_.OpenIdWXIdx_</code> table reference
     */
    public Openidwxidx_(Name alias) {
        this(alias, OPENIDWXIDX_);
    }

    private Openidwxidx_(Name alias, Table<Openidwxidx_Record> aliased) {
        this(alias, aliased, null);
    }

    private Openidwxidx_(Name alias, Table<Openidwxidx_Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "用于存储openId对应wx关联关系");
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
        return Arrays.<Index>asList(Indexes.OPENIDWXIDX__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Openidwxidx_Record> getPrimaryKey() {
        return Keys.KEY_OPENIDWXIDX__PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Openidwxidx_Record>> getKeys() {
        return Arrays.<UniqueKey<Openidwxidx_Record>>asList(Keys.KEY_OPENIDWXIDX__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Openidwxidx_ as(String alias) {
        return new Openidwxidx_(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Openidwxidx_ as(Name alias) {
        return new Openidwxidx_(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Openidwxidx_ rename(String name) {
        return new Openidwxidx_(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Openidwxidx_ rename(Name name) {
        return new Openidwxidx_(name, null);
    }
}
