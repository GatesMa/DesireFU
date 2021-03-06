/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables;


import cn.gatesma.desirefu.domain.db.generate.DFU_.Dfu_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Indexes;
import cn.gatesma.desirefu.domain.db.generate.DFU_.Keys;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Department_Record;

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
 * 学院信息
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Department_ extends TableImpl<Department_Record> {

    private static final long serialVersionUID = 1279872270;

    /**
     * The reference instance of <code>DFU_.Department_</code>
     */
    public static final Department_ DEPARTMENT_ = new Department_();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Department_Record> getRecordType() {
        return Department_Record.class;
    }

    /**
     * The column <code>DFU_.Department_.departmentId</code>. 学院Id
     */
    public final TableField<Department_Record, Integer> DEPARTMENTID = createField("departmentId", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "学院Id");

    /**
     * The column <code>DFU_.Department_.collegeId</code>. 高校id
     */
    public final TableField<Department_Record, Integer> COLLEGEID = createField("collegeId", org.jooq.impl.SQLDataType.INTEGER.defaultValue(DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "高校id");

    /**
     * The column <code>DFU_.Department_.name</code>. 学院名称
     */
    public final TableField<Department_Record, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(1024).defaultValue(DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "学院名称");

    /**
     * The column <code>DFU_.Department_.createdTime</code>. 创建时间
     */
    public final TableField<Department_Record, Timestamp> CREATEDTIME = createField("createdTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "创建时间");

    /**
     * The column <code>DFU_.Department_.deleteStatus</code>. 删除状态，0-正常，1-删除
     */
    public final TableField<Department_Record, Integer> DELETESTATUS = createField("deleteStatus", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "删除状态，0-正常，1-删除");

    /**
     * The column <code>DFU_.Department_.lastModifiedTime</code>. lastModifiedTime
     */
    public final TableField<Department_Record, Timestamp> LASTMODIFIEDTIME = createField("lastModifiedTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "lastModifiedTime");

    /**
     * Create a <code>DFU_.Department_</code> table reference
     */
    public Department_() {
        this(DSL.name("Department_"), null);
    }

    /**
     * Create an aliased <code>DFU_.Department_</code> table reference
     */
    public Department_(String alias) {
        this(DSL.name(alias), DEPARTMENT_);
    }

    /**
     * Create an aliased <code>DFU_.Department_</code> table reference
     */
    public Department_(Name alias) {
        this(alias, DEPARTMENT_);
    }

    private Department_(Name alias, Table<Department_Record> aliased) {
        this(alias, aliased, null);
    }

    private Department_(Name alias, Table<Department_Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "学院信息");
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
        return Arrays.<Index>asList(Indexes.DEPARTMENT__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<Department_Record, Integer> getIdentity() {
        return Keys.IDENTITY_DEPARTMENT_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Department_Record> getPrimaryKey() {
        return Keys.KEY_DEPARTMENT__PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Department_Record>> getKeys() {
        return Arrays.<UniqueKey<Department_Record>>asList(Keys.KEY_DEPARTMENT__PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Department_ as(String alias) {
        return new Department_(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Department_ as(Name alias) {
        return new Department_(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Department_ rename(String name) {
        return new Department_(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Department_ rename(Name name) {
        return new Department_(name, null);
    }
}
