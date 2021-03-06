/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * 高校可见比赛表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Competitionvisible_ implements Serializable {

    private static final long serialVersionUID = 70781498;

    private Integer   collegeid;
    private Long      competitionid;
    private Integer   deletestatus;
    private Timestamp createdtime;
    private Timestamp lastmodifiedtime;

    public Competitionvisible_() {}

    public Competitionvisible_(Competitionvisible_ value) {
        this.collegeid = value.collegeid;
        this.competitionid = value.competitionid;
        this.deletestatus = value.deletestatus;
        this.createdtime = value.createdtime;
        this.lastmodifiedtime = value.lastmodifiedtime;
    }

    public Competitionvisible_(
        Integer   collegeid,
        Long      competitionid,
        Integer   deletestatus,
        Timestamp createdtime,
        Timestamp lastmodifiedtime
    ) {
        this.collegeid = collegeid;
        this.competitionid = competitionid;
        this.deletestatus = deletestatus;
        this.createdtime = createdtime;
        this.lastmodifiedtime = lastmodifiedtime;
    }

    public Integer getCollegeid() {
        return this.collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    public Long getCompetitionid() {
        return this.competitionid;
    }

    public void setCompetitionid(Long competitionid) {
        this.competitionid = competitionid;
    }

    public Integer getDeletestatus() {
        return this.deletestatus;
    }

    public void setDeletestatus(Integer deletestatus) {
        this.deletestatus = deletestatus;
    }

    public Timestamp getCreatedtime() {
        return this.createdtime;
    }

    public void setCreatedtime(Timestamp createdtime) {
        this.createdtime = createdtime;
    }

    public Timestamp getLastmodifiedtime() {
        return this.lastmodifiedtime;
    }

    public void setLastmodifiedtime(Timestamp lastmodifiedtime) {
        this.lastmodifiedtime = lastmodifiedtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Competitionvisible_ (");

        sb.append(collegeid);
        sb.append(", ").append(competitionid);
        sb.append(", ").append(deletestatus);
        sb.append(", ").append(createdtime);
        sb.append(", ").append(lastmodifiedtime);

        sb.append(")");
        return sb.toString();
    }
}
