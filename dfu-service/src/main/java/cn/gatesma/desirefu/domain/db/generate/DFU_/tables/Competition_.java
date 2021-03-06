/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables;


import cn.gatesma.desirefu.domain.db.generate.DFU_.Dfu_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Indexes;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Keys;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Competition_Record;

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
 * 比赛
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Competition_ extends TableImpl<Competition_Record> {

    private static final long serialVersionUID = 132650206;

    /**
     * The reference instance of <code>DFU_.Competition_</code>
     */
    public static final Competition_ COMPETITION_ = new Competition_();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Competition_Record> getRecordType() {
        return Competition_Record.class;
    }

    /**
     * The column <code>DFU_.Competition_.competitionId</code>. 帐号ID
     */
    public final TableField<Competition_Record, Long> COMPETITIONID = createField("competitionId", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "帐号ID");

    /**
     * The column <code>DFU_.Competition_.accountId</code>. 比赛归属帐号ID
     */
    public final TableField<Competition_Record, Long> ACCOUNTID = createField("accountId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "比赛归属帐号ID");

    /**
     * The column <code>DFU_.Competition_.accountType</code>. 比赛归属账号类型
     */
    public final TableField<Competition_Record, Integer> ACCOUNTTYPE = createField("accountType", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "比赛归属账号类型");

    /**
     * The column <code>DFU_.Competition_.status</code>. 0-草稿，1-可见
     */
    public final TableField<Competition_Record, Integer> STATUS = createField("status", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "0-草稿，1-可见");

    /**
     * The column <code>DFU_.Competition_.type</code>. 比赛类型 - 省级、校级等
     */
    public final TableField<Competition_Record, Integer> TYPE = createField("type", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "比赛类型 - 省级、校级等");

    /**
     * The column <code>DFU_.Competition_.title</code>. 比赛名称
     */
    public final TableField<Competition_Record, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(255).defaultValue(DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "比赛名称");

    /**
     * The column <code>DFU_.Competition_.founder</code>. 创办方
     */
    public final TableField<Competition_Record, String> FOUNDER = createField("founder", org.jooq.impl.SQLDataType.VARCHAR(255), this, "创办方");

    /**
     * The column <code>DFU_.Competition_.content</code>. 具体通知内容，富文本
     */
    public final TableField<Competition_Record, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.CLOB, this, "具体通知内容，富文本");

    /**
     * The column <code>DFU_.Competition_.pv</code>. 浏览人数
     */
    public final TableField<Competition_Record, Integer> PV = createField("pv", org.jooq.impl.SQLDataType.INTEGER.defaultValue(DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "浏览人数");

    /**
     * The column <code>DFU_.Competition_.overviewText</code>. 概览文字
     */
    public final TableField<Competition_Record, String> OVERVIEWTEXT = createField("overviewText", org.jooq.impl.SQLDataType.VARCHAR(255), this, "概览文字");

    /**
     * The column <code>DFU_.Competition_.overviewImg</code>. 概览图片url
     */
    public final TableField<Competition_Record, String> OVERVIEWIMG = createField("overviewImg", org.jooq.impl.SQLDataType.VARCHAR(1024), this, "概览图片url");

    /**
     * The column <code>DFU_.Competition_.beginTime</code>. 比赛开始时间
     */
    public final TableField<Competition_Record, Timestamp> BEGINTIME = createField("beginTime", org.jooq.impl.SQLDataType.TIMESTAMP, this, "比赛开始时间");

    /**
     * The column <code>DFU_.Competition_.endTime</code>. 比赛结束时间
     */
    public final TableField<Competition_Record, Timestamp> ENDTIME = createField("endTime", org.jooq.impl.SQLDataType.TIMESTAMP, this, "比赛结束时间");

    /**
     * The column <code>DFU_.Competition_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public final TableField<Competition_Record, Integer> DELETESTATUS = createField("deleteStatus", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "删除状态，0-正常，1-删除");

    /**
     * The column <code>DFU_.Competition_.createdUserId</code>. 创建人userId
     */
    public final TableField<Competition_Record, Long> CREATEDUSERID = createField("createdUserId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "创建人userId");

    /**
     * The column <code>DFU_.Competition_.createdTime</code>. 创建时间
     */
    public final TableField<Competition_Record, Timestamp> CREATEDTIME = createField("createdTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "创建时间");

    /**
     * The column <code>DFU_.Competition_.lastModifiedUserId</code>. 最后修改人userId
     */
    public final TableField<Competition_Record, Long> LASTMODIFIEDUSERID = createField("lastModifiedUserId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "最后修改人userId");

    /**
     * The column <code>DFU_.Competition_.lastModifiedTime</code>. lastModifiedTime
     */
    public final TableField<Competition_Record, Timestamp> LASTMODIFIEDTIME = createField("lastModifiedTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "lastModifiedTime");

    /**
     * Create a <code>DFU_.Competition_</code> table reference
     */
    public Competition_() {
        this(DSL.name("Competition_"), null);
    }

    /**
     * Create an aliased <code>DFU_.Competition_</code> table reference
     */
    public Competition_(String alias) {
        this(DSL.name(alias), COMPETITION_);
    }

    /**
     * Create an aliased <code>DFU_.Competition_</code> table reference
     */
    public Competition_(Name alias) {
        this(alias, COMPETITION_);
    }

    private Competition_(Name alias, Table<Competition_Record> aliased) {
        this(alias, aliased, null);
    }

    private Competition_(Name alias, Table<Competition_Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "比赛");
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
        return Arrays.<Index>asList(Indexes.COMPETITION__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<Competition_Record, Long> getIdentity() {
        return Keys.IDENTITY_COMPETITION_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Competition_Record> getPrimaryKey() {
        return Keys.KEY_COMPETITION__PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Competition_Record>> getKeys() {
        return Arrays.<UniqueKey<Competition_Record>>asList(Keys.KEY_COMPETITION__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Competition_ as(String alias) {
        return new Competition_(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Competition_ as(Name alias) {
        return new Competition_(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Competition_ rename(String name) {
        return new Competition_(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Competition_ rename(Name name) {
        return new Competition_(name, null);
    }
}
