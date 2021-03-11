/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_;


import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Account_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Accountuserrole_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Collect_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.College_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Competition_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Competitioncreatoraccount_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Competitionvisible_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Department_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Message_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Normalaccount_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Notification_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Openidqqidx_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Openidwxidx_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Organize_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Organizeaccountapplication_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Organizeaccountrelation_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Ossaccount_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Rootaccount_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Uploadfile_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.User_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Userlogin_;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>DFU_</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ACCOUNTUSERROLE__PRIMARY = Indexes0.ACCOUNTUSERROLE__PRIMARY;
    public static final Index ACCOUNT__PRIMARY = Indexes0.ACCOUNT__PRIMARY;
    public static final Index COLLECT__PRIMARY = Indexes0.COLLECT__PRIMARY;
    public static final Index COLLEGE__PRIMARY = Indexes0.COLLEGE__PRIMARY;
    public static final Index COMPETITIONCREATORACCOUNT__PRIMARY = Indexes0.COMPETITIONCREATORACCOUNT__PRIMARY;
    public static final Index COMPETITIONVISIBLE__PRIMARY = Indexes0.COMPETITIONVISIBLE__PRIMARY;
    public static final Index COMPETITION__PRIMARY = Indexes0.COMPETITION__PRIMARY;
    public static final Index DEPARTMENT__PRIMARY = Indexes0.DEPARTMENT__PRIMARY;
    public static final Index MESSAGE__PRIMARY = Indexes0.MESSAGE__PRIMARY;
    public static final Index NORMALACCOUNT__PRIMARY = Indexes0.NORMALACCOUNT__PRIMARY;
    public static final Index NOTIFICATION__PRIMARY = Indexes0.NOTIFICATION__PRIMARY;
    public static final Index OPENIDQQIDX__PRIMARY = Indexes0.OPENIDQQIDX__PRIMARY;
    public static final Index OPENIDWXIDX__PRIMARY = Indexes0.OPENIDWXIDX__PRIMARY;
    public static final Index ORGANIZEACCOUNTAPPLICATION__PRIMARY = Indexes0.ORGANIZEACCOUNTAPPLICATION__PRIMARY;
    public static final Index ORGANIZEACCOUNTRELATION__PRIMARY = Indexes0.ORGANIZEACCOUNTRELATION__PRIMARY;
    public static final Index ORGANIZE__PRIMARY = Indexes0.ORGANIZE__PRIMARY;
    public static final Index OSSACCOUNT__PRIMARY = Indexes0.OSSACCOUNT__PRIMARY;
    public static final Index ROOTACCOUNT__PRIMARY = Indexes0.ROOTACCOUNT__PRIMARY;
    public static final Index UPLOADFILE__PRIMARY = Indexes0.UPLOADFILE__PRIMARY;
    public static final Index USERLOGIN__PRIMARY = Indexes0.USERLOGIN__PRIMARY;
    public static final Index USER__PRIMARY = Indexes0.USER__PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index ACCOUNTUSERROLE__PRIMARY = Internal.createIndex("PRIMARY", Accountuserrole_.ACCOUNTUSERROLE_, new OrderField[] { Accountuserrole_.ACCOUNTUSERROLE_.ACCOUNTROLEID }, true);
        public static Index ACCOUNT__PRIMARY = Internal.createIndex("PRIMARY", Account_.ACCOUNT_, new OrderField[] { Account_.ACCOUNT_.ACCOUNTID }, true);
        public static Index COLLECT__PRIMARY = Internal.createIndex("PRIMARY", Collect_.COLLECT_, new OrderField[] { Collect_.COLLECT_.ID }, true);
        public static Index COLLEGE__PRIMARY = Internal.createIndex("PRIMARY", College_.COLLEGE_, new OrderField[] { College_.COLLEGE_.COLLEGEID }, true);
        public static Index COMPETITIONCREATORACCOUNT__PRIMARY = Internal.createIndex("PRIMARY", Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_, new OrderField[] { Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_.ACCOUNTID }, true);
        public static Index COMPETITIONVISIBLE__PRIMARY = Internal.createIndex("PRIMARY", Competitionvisible_.COMPETITIONVISIBLE_, new OrderField[] { Competitionvisible_.COMPETITIONVISIBLE_.COMPETITIONID, Competitionvisible_.COMPETITIONVISIBLE_.COLLEGEID }, true);
        public static Index COMPETITION__PRIMARY = Internal.createIndex("PRIMARY", Competition_.COMPETITION_, new OrderField[] { Competition_.COMPETITION_.COMPETITIONID }, true);
        public static Index DEPARTMENT__PRIMARY = Internal.createIndex("PRIMARY", Department_.DEPARTMENT_, new OrderField[] { Department_.DEPARTMENT_.DEPARTMENTID }, true);
        public static Index MESSAGE__PRIMARY = Internal.createIndex("PRIMARY", Message_.MESSAGE_, new OrderField[] { Message_.MESSAGE_.ID }, true);
        public static Index NORMALACCOUNT__PRIMARY = Internal.createIndex("PRIMARY", Normalaccount_.NORMALACCOUNT_, new OrderField[] { Normalaccount_.NORMALACCOUNT_.ACCOUNTID }, true);
        public static Index NOTIFICATION__PRIMARY = Internal.createIndex("PRIMARY", Notification_.NOTIFICATION_, new OrderField[] { Notification_.NOTIFICATION_.NOTICEID }, true);
        public static Index OPENIDQQIDX__PRIMARY = Internal.createIndex("PRIMARY", Openidqqidx_.OPENIDQQIDX_, new OrderField[] { Openidqqidx_.OPENIDQQIDX_.OPENID }, true);
        public static Index OPENIDWXIDX__PRIMARY = Internal.createIndex("PRIMARY", Openidwxidx_.OPENIDWXIDX_, new OrderField[] { Openidwxidx_.OPENIDWXIDX_.OPENID }, true);
        public static Index ORGANIZEACCOUNTAPPLICATION__PRIMARY = Internal.createIndex("PRIMARY", Organizeaccountapplication_.ORGANIZEACCOUNTAPPLICATION_, new OrderField[] { Organizeaccountapplication_.ORGANIZEACCOUNTAPPLICATION_.ID }, true);
        public static Index ORGANIZEACCOUNTRELATION__PRIMARY = Internal.createIndex("PRIMARY", Organizeaccountrelation_.ORGANIZEACCOUNTRELATION_, new OrderField[] { Organizeaccountrelation_.ORGANIZEACCOUNTRELATION_.ID }, true);
        public static Index ORGANIZE__PRIMARY = Internal.createIndex("PRIMARY", Organize_.ORGANIZE_, new OrderField[] { Organize_.ORGANIZE_.ORGANIZEID }, true);
        public static Index OSSACCOUNT__PRIMARY = Internal.createIndex("PRIMARY", Ossaccount_.OSSACCOUNT_, new OrderField[] { Ossaccount_.OSSACCOUNT_.ACCOUNTID }, true);
        public static Index ROOTACCOUNT__PRIMARY = Internal.createIndex("PRIMARY", Rootaccount_.ROOTACCOUNT_, new OrderField[] { Rootaccount_.ROOTACCOUNT_.ACCOUNTID }, true);
        public static Index UPLOADFILE__PRIMARY = Internal.createIndex("PRIMARY", Uploadfile_.UPLOADFILE_, new OrderField[] { Uploadfile_.UPLOADFILE_.FILEID }, true);
        public static Index USERLOGIN__PRIMARY = Internal.createIndex("PRIMARY", Userlogin_.USERLOGIN_, new OrderField[] { Userlogin_.USERLOGIN_.ID }, true);
        public static Index USER__PRIMARY = Internal.createIndex("PRIMARY", User_.USER_, new OrderField[] { User_.USER_.USERID }, true);
    }
}
