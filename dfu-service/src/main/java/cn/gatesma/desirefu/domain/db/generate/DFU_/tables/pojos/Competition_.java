/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


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
public class Competition_ implements Serializable {

    private static final long serialVersionUID = 1147237727;

    private Long      competitionid;
    private Long      accountid;
    private Integer   accounttype;
    private Integer   type;
    private String    title;
    private String    founder;
    private String    content;
    private Integer   pv;
    private Timestamp begintime;
    private Timestamp endtime;
    private Integer   deletestatus;
    private Long      createduserid;
    private Timestamp createdtime;
    private Long      lastmodifieduserid;
    private Timestamp lastmodifiedtime;

    public Competition_() {}

    public Competition_(Competition_ value) {
        this.competitionid = value.competitionid;
        this.accountid = value.accountid;
        this.accounttype = value.accounttype;
        this.type = value.type;
        this.title = value.title;
        this.founder = value.founder;
        this.content = value.content;
        this.pv = value.pv;
        this.begintime = value.begintime;
        this.endtime = value.endtime;
        this.deletestatus = value.deletestatus;
        this.createduserid = value.createduserid;
        this.createdtime = value.createdtime;
        this.lastmodifieduserid = value.lastmodifieduserid;
        this.lastmodifiedtime = value.lastmodifiedtime;
    }

    public Competition_(
        Long      competitionid,
        Long      accountid,
        Integer   accounttype,
        Integer   type,
        String    title,
        String    founder,
        String    content,
        Integer   pv,
        Timestamp begintime,
        Timestamp endtime,
        Integer   deletestatus,
        Long      createduserid,
        Timestamp createdtime,
        Long      lastmodifieduserid,
        Timestamp lastmodifiedtime
    ) {
        this.competitionid = competitionid;
        this.accountid = accountid;
        this.accounttype = accounttype;
        this.type = type;
        this.title = title;
        this.founder = founder;
        this.content = content;
        this.pv = pv;
        this.begintime = begintime;
        this.endtime = endtime;
        this.deletestatus = deletestatus;
        this.createduserid = createduserid;
        this.createdtime = createdtime;
        this.lastmodifieduserid = lastmodifieduserid;
        this.lastmodifiedtime = lastmodifiedtime;
    }

    public Long getCompetitionid() {
        return this.competitionid;
    }

    public void setCompetitionid(Long competitionid) {
        this.competitionid = competitionid;
    }

    public Long getAccountid() {
        return this.accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public Integer getAccounttype() {
        return this.accounttype;
    }

    public void setAccounttype(Integer accounttype) {
        this.accounttype = accounttype;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFounder() {
        return this.founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPv() {
        return this.pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Timestamp getBegintime() {
        return this.begintime;
    }

    public void setBegintime(Timestamp begintime) {
        this.begintime = begintime;
    }

    public Timestamp getEndtime() {
        return this.endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public Integer getDeletestatus() {
        return this.deletestatus;
    }

    public void setDeletestatus(Integer deletestatus) {
        this.deletestatus = deletestatus;
    }

    public Long getCreateduserid() {
        return this.createduserid;
    }

    public void setCreateduserid(Long createduserid) {
        this.createduserid = createduserid;
    }

    public Timestamp getCreatedtime() {
        return this.createdtime;
    }

    public void setCreatedtime(Timestamp createdtime) {
        this.createdtime = createdtime;
    }

    public Long getLastmodifieduserid() {
        return this.lastmodifieduserid;
    }

    public void setLastmodifieduserid(Long lastmodifieduserid) {
        this.lastmodifieduserid = lastmodifieduserid;
    }

    public Timestamp getLastmodifiedtime() {
        return this.lastmodifiedtime;
    }

    public void setLastmodifiedtime(Timestamp lastmodifiedtime) {
        this.lastmodifiedtime = lastmodifiedtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Competition_ (");

        sb.append(competitionid);
        sb.append(", ").append(accountid);
        sb.append(", ").append(accounttype);
        sb.append(", ").append(type);
        sb.append(", ").append(title);
        sb.append(", ").append(founder);
        sb.append(", ").append(content);
        sb.append(", ").append(pv);
        sb.append(", ").append(begintime);
        sb.append(", ").append(endtime);
        sb.append(", ").append(deletestatus);
        sb.append(", ").append(createduserid);
        sb.append(", ").append(createdtime);
        sb.append(", ").append(lastmodifieduserid);
        sb.append(", ").append(lastmodifiedtime);

        sb.append(")");
        return sb.toString();
    }
}
