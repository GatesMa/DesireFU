/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables;


import cn.gatesma.desirefu.domain.db.generate.DFU_.Dfu_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Indexes;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Keys;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Competitioncreatoraccount_Record;

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
public class Competitioncreatoraccount_ extends TableImpl<Competitioncreatoraccount_Record> {

    private static final long serialVersionUID = -211981037;

    /**
     * The reference instance of <code>DFU_.CompetitionCreatorAccount_</code>
     */
    public static final Competitioncreatoraccount_ COMPETITIONCREATORACCOUNT_ = new Competitioncreatoraccount_();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Competitioncreatoraccount_Record> getRecordType() {
        return Competitioncreatoraccount_Record.class;
    }

    /**
     * The column <code>DFU_.CompetitionCreatorAccount_.accountId</code>. 帐号ID
     */
    public final TableField<Competitioncreatoraccount_Record, Long> ACCOUNTID = createField("accountId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "帐号ID");

    /**
     * The column <code>DFU_.CompetitionCreatorAccount_.accountType</code>. 账号类型
     */
    public final TableField<Competitioncreatoraccount_Record, Integer> ACCOUNTTYPE = createField("accountType", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "账号类型");

    /**
     * The column <code>DFU_.CompetitionCreatorAccount_.author</code>. 可以创建比赛的权限
     */
    public final TableField<Competitioncreatoraccount_Record, String> AUTHOR = createField("author", org.jooq.impl.SQLDataType.VARCHAR(4096).defaultValue(DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "可以创建比赛的权限");

    /**
     * The column <code>DFU_.CompetitionCreatorAccount_.createdUserId</code>. 创建人userId
     */
    public final TableField<Competitioncreatoraccount_Record, Long> CREATEDUSERID = createField("createdUserId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "创建人userId");

    /**
     * The column <code>DFU_.CompetitionCreatorAccount_.createdTime</code>. 创建时间
     */
    public final TableField<Competitioncreatoraccount_Record, Timestamp> CREATEDTIME = createField("createdTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "创建时间");

    /**
     * The column <code>DFU_.CompetitionCreatorAccount_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public final TableField<Competitioncreatoraccount_Record, Integer> DELETESTATUS = createField("deleteStatus", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "删除状态，0-正常，1-删除");

    /**
     * The column <code>DFU_.CompetitionCreatorAccount_.lastModifiedUserId</code>. 最后修改人userId
     */
    public final TableField<Competitioncreatoraccount_Record, Long> LASTMODIFIEDUSERID = createField("lastModifiedUserId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "最后修改人userId");

    /**
     * The column <code>DFU_.CompetitionCreatorAccount_.lastModifiedTime</code>. lastModifiedTime
     */
    public final TableField<Competitioncreatoraccount_Record, Timestamp> LASTMODIFIEDTIME = createField("lastModifiedTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "lastModifiedTime");

    /**
     * Create a <code>DFU_.CompetitionCreatorAccount_</code> table reference
     */
    public Competitioncreatoraccount_() {
        this(DSL.name("CompetitionCreatorAccount_"), null);
    }

    /**
     * Create an aliased <code>DFU_.CompetitionCreatorAccount_</code> table reference
     */
    public Competitioncreatoraccount_(String alias) {
        this(DSL.name(alias), COMPETITIONCREATORACCOUNT_);
    }

    /**
     * Create an aliased <code>DFU_.CompetitionCreatorAccount_</code> table reference
     */
    public Competitioncreatoraccount_(Name alias) {
        this(alias, COMPETITIONCREATORACCOUNT_);
    }

    private Competitioncreatoraccount_(Name alias, Table<Competitioncreatoraccount_Record> aliased) {
        this(alias, aliased, null);
    }

    private Competitioncreatoraccount_(Name alias, Table<Competitioncreatoraccount_Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "比赛创建者账号");
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
        return Arrays.<Index>asList(Indexes.COMPETITIONCREATORACCOUNT__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Competitioncreatoraccount_Record> getPrimaryKey() {
        return Keys.KEY_COMPETITIONCREATORACCOUNT__PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Competitioncreatoraccount_Record>> getKeys() {
        return Arrays.<UniqueKey<Competitioncreatoraccount_Record>>asList(Keys.KEY_COMPETITIONCREATORACCOUNT__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Competitioncreatoraccount_ as(String alias) {
        return new Competitioncreatoraccount_(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Competitioncreatoraccount_ as(Name alias) {
        return new Competitioncreatoraccount_(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Competitioncreatoraccount_ rename(String name) {
        return new Competitioncreatoraccount_(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Competitioncreatoraccount_ rename(Name name) {
        return new Competitioncreatoraccount_(name, null);
    }
}
