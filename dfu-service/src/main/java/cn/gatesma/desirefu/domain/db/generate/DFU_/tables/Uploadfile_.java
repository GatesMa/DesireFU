/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables;


import cn.gatesma.desirefu.domain.db.generate.DFU_.Dfu_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Indexes;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Keys;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Uploadfile_Record;

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
 * 文件上传表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Uploadfile_ extends TableImpl<Uploadfile_Record> {

    private static final long serialVersionUID = -727174986;

    /**
     * The reference instance of <code>DFU_.UploadFile_</code>
     */
    public static final Uploadfile_ UPLOADFILE_ = new Uploadfile_();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Uploadfile_Record> getRecordType() {
        return Uploadfile_Record.class;
    }

    /**
     * The column <code>DFU_.UploadFile_.fileId</code>. 文件ID
     */
    public final TableField<Uploadfile_Record, Integer> FILEID = createField("fileId", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "文件ID");

    /**
     * The column <code>DFU_.UploadFile_.fileType</code>. 文件类型
     */
    public final TableField<Uploadfile_Record, String> FILETYPE = createField("fileType", org.jooq.impl.SQLDataType.VARCHAR(32), this, "文件类型");

    /**
     * The column <code>DFU_.UploadFile_.accountId</code>. 比赛归属帐号ID
     */
    public final TableField<Uploadfile_Record, Long> ACCOUNTID = createField("accountId", org.jooq.impl.SQLDataType.BIGINT, this, "比赛归属帐号ID");

    /**
     * The column <code>DFU_.UploadFile_.accountType</code>. 比赛归属账号类型
     */
    public final TableField<Uploadfile_Record, Integer> ACCOUNTTYPE = createField("accountType", org.jooq.impl.SQLDataType.INTEGER, this, "比赛归属账号类型");

    /**
     * The column <code>DFU_.UploadFile_.fileName</code>. 文件名称
     */
    public final TableField<Uploadfile_Record, String> FILENAME = createField("fileName", org.jooq.impl.SQLDataType.VARCHAR(255), this, "文件名称");

    /**
     * The column <code>DFU_.UploadFile_.fileURL</code>. 文件Url
     */
    public final TableField<Uploadfile_Record, String> FILEURL = createField("fileURL", org.jooq.impl.SQLDataType.VARCHAR(1024), this, "文件Url");

    /**
     * The column <code>DFU_.UploadFile_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public final TableField<Uploadfile_Record, Integer> DELETESTATUS = createField("deleteStatus", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "删除状态，0-正常，1-删除");

    /**
     * The column <code>DFU_.UploadFile_.createdTime</code>. 创建时间
     */
    public final TableField<Uploadfile_Record, Timestamp> CREATEDTIME = createField("createdTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "创建时间");

    /**
     * The column <code>DFU_.UploadFile_.lastModifiedTime</code>. lastModifiedTime
     */
    public final TableField<Uploadfile_Record, Timestamp> LASTMODIFIEDTIME = createField("lastModifiedTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "lastModifiedTime");

    /**
     * Create a <code>DFU_.UploadFile_</code> table reference
     */
    public Uploadfile_() {
        this(DSL.name("UploadFile_"), null);
    }

    /**
     * Create an aliased <code>DFU_.UploadFile_</code> table reference
     */
    public Uploadfile_(String alias) {
        this(DSL.name(alias), UPLOADFILE_);
    }

    /**
     * Create an aliased <code>DFU_.UploadFile_</code> table reference
     */
    public Uploadfile_(Name alias) {
        this(alias, UPLOADFILE_);
    }

    private Uploadfile_(Name alias, Table<Uploadfile_Record> aliased) {
        this(alias, aliased, null);
    }

    private Uploadfile_(Name alias, Table<Uploadfile_Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "文件上传表");
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
        return Arrays.<Index>asList(Indexes.UPLOADFILE__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<Uploadfile_Record, Integer> getIdentity() {
        return Keys.IDENTITY_UPLOADFILE_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Uploadfile_Record> getPrimaryKey() {
        return Keys.KEY_UPLOADFILE__PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Uploadfile_Record>> getKeys() {
        return Arrays.<UniqueKey<Uploadfile_Record>>asList(Keys.KEY_UPLOADFILE__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Uploadfile_ as(String alias) {
        return new Uploadfile_(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Uploadfile_ as(Name alias) {
        return new Uploadfile_(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Uploadfile_ rename(String name) {
        return new Uploadfile_(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Uploadfile_ rename(Name name) {
        return new Uploadfile_(name, null);
    }
}