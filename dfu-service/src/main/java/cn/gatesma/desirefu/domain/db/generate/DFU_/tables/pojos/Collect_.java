/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * 收藏表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Collect_ implements Serializable {

    private static final long serialVersionUID = -1053677706;

    private Long      id;
    private Long      accountid;
    private Long      competitionid;
    private Timestamp createdtime;
    private Integer   deletestatus;
    private Timestamp lastmodifiedtime;

    public Collect_() {}

    public Collect_(Collect_ value) {
        this.id = value.id;
        this.accountid = value.accountid;
        this.competitionid = value.competitionid;
        this.createdtime = value.createdtime;
        this.deletestatus = value.deletestatus;
        this.lastmodifiedtime = value.lastmodifiedtime;
    }

    public Collect_(
        Long      id,
        Long      accountid,
        Long      competitionid,
        Timestamp createdtime,
        Integer   deletestatus,
        Timestamp lastmodifiedtime
    ) {
        this.id = id;
        this.accountid = accountid;
        this.competitionid = competitionid;
        this.createdtime = createdtime;
        this.deletestatus = deletestatus;
        this.lastmodifiedtime = lastmodifiedtime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountid() {
        return this.accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public Long getCompetitionid() {
        return this.competitionid;
    }

    public void setCompetitionid(Long competitionid) {
        this.competitionid = competitionid;
    }

    public Timestamp getCreatedtime() {
        return this.createdtime;
    }

    public void setCreatedtime(Timestamp createdtime) {
        this.createdtime = createdtime;
    }

    public Integer getDeletestatus() {
        return this.deletestatus;
    }

    public void setDeletestatus(Integer deletestatus) {
        this.deletestatus = deletestatus;
    }

    public Timestamp getLastmodifiedtime() {
        return this.lastmodifiedtime;
    }

    public void setLastmodifiedtime(Timestamp lastmodifiedtime) {
        this.lastmodifiedtime = lastmodifiedtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Collect_ (");

        sb.append(id);
        sb.append(", ").append(accountid);
        sb.append(", ").append(competitionid);
        sb.append(", ").append(createdtime);
        sb.append(", ").append(deletestatus);
        sb.append(", ").append(lastmodifiedtime);

        sb.append(")");
        return sb.toString();
    }
}
