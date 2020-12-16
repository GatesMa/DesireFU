/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * 用户登录表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Userlogin_ implements Serializable {

    private static final long serialVersionUID = 164393845;

    private Long      id;
    private Long      userid;
    private String    loginname;
    private Integer   loginnametype;
    private Integer   deletestatus;
    private Timestamp createdtime;
    private Long      createduserid;
    private Long      lastmodifieduserid;
    private Timestamp lastmodifiedtime;

    public Userlogin_() {}

    public Userlogin_(Userlogin_ value) {
        this.id = value.id;
        this.userid = value.userid;
        this.loginname = value.loginname;
        this.loginnametype = value.loginnametype;
        this.deletestatus = value.deletestatus;
        this.createdtime = value.createdtime;
        this.createduserid = value.createduserid;
        this.lastmodifieduserid = value.lastmodifieduserid;
        this.lastmodifiedtime = value.lastmodifiedtime;
    }

    public Userlogin_(
        Long      id,
        Long      userid,
        String    loginname,
        Integer   loginnametype,
        Integer   deletestatus,
        Timestamp createdtime,
        Long      createduserid,
        Long      lastmodifieduserid,
        Timestamp lastmodifiedtime
    ) {
        this.id = id;
        this.userid = userid;
        this.loginname = loginname;
        this.loginnametype = loginnametype;
        this.deletestatus = deletestatus;
        this.createdtime = createdtime;
        this.createduserid = createduserid;
        this.lastmodifieduserid = lastmodifieduserid;
        this.lastmodifiedtime = lastmodifiedtime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return this.userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getLoginname() {
        return this.loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public Integer getLoginnametype() {
        return this.loginnametype;
    }

    public void setLoginnametype(Integer loginnametype) {
        this.loginnametype = loginnametype;
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

    public Long getCreateduserid() {
        return this.createduserid;
    }

    public void setCreateduserid(Long createduserid) {
        this.createduserid = createduserid;
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
        StringBuilder sb = new StringBuilder("Userlogin_ (");

        sb.append(id);
        sb.append(", ").append(userid);
        sb.append(", ").append(loginname);
        sb.append(", ").append(loginnametype);
        sb.append(", ").append(deletestatus);
        sb.append(", ").append(createdtime);
        sb.append(", ").append(createduserid);
        sb.append(", ").append(lastmodifieduserid);
        sb.append(", ").append(lastmodifiedtime);

        sb.append(")");
        return sb.toString();
    }
}
