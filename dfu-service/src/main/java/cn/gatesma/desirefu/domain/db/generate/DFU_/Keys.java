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
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Account_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Accountuserrole_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Collect_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.College_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Competition_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Competitioncreatoraccount_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Competitionvisible_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Department_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Message_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Normalaccount_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Notification_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Openidqqidx_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Openidwxidx_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organize_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organizeaccountapplication_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Organizeaccountrelation_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Ossaccount_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Rootaccount_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Uploadfile_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.User_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Userlogin_Record;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>DFU_</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<Accountuserrole_Record, Long> IDENTITY_ACCOUNTUSERROLE_ = Identities0.IDENTITY_ACCOUNTUSERROLE_;
    public static final Identity<Account_Record, Long> IDENTITY_ACCOUNT_ = Identities0.IDENTITY_ACCOUNT_;
    public static final Identity<Collect_Record, Long> IDENTITY_COLLECT_ = Identities0.IDENTITY_COLLECT_;
    public static final Identity<College_Record, Integer> IDENTITY_COLLEGE_ = Identities0.IDENTITY_COLLEGE_;
    public static final Identity<Competition_Record, Long> IDENTITY_COMPETITION_ = Identities0.IDENTITY_COMPETITION_;
    public static final Identity<Department_Record, Integer> IDENTITY_DEPARTMENT_ = Identities0.IDENTITY_DEPARTMENT_;
    public static final Identity<Message_Record, Long> IDENTITY_MESSAGE_ = Identities0.IDENTITY_MESSAGE_;
    public static final Identity<Notification_Record, Integer> IDENTITY_NOTIFICATION_ = Identities0.IDENTITY_NOTIFICATION_;
    public static final Identity<Organizeaccountapplication_Record, Long> IDENTITY_ORGANIZEACCOUNTAPPLICATION_ = Identities0.IDENTITY_ORGANIZEACCOUNTAPPLICATION_;
    public static final Identity<Organizeaccountrelation_Record, Long> IDENTITY_ORGANIZEACCOUNTRELATION_ = Identities0.IDENTITY_ORGANIZEACCOUNTRELATION_;
    public static final Identity<Uploadfile_Record, Integer> IDENTITY_UPLOADFILE_ = Identities0.IDENTITY_UPLOADFILE_;
    public static final Identity<Userlogin_Record, Long> IDENTITY_USERLOGIN_ = Identities0.IDENTITY_USERLOGIN_;
    public static final Identity<User_Record, Long> IDENTITY_USER_ = Identities0.IDENTITY_USER_;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<Accountuserrole_Record> KEY_ACCOUNTUSERROLE__PRIMARY = UniqueKeys0.KEY_ACCOUNTUSERROLE__PRIMARY;
    public static final UniqueKey<Account_Record> KEY_ACCOUNT__PRIMARY = UniqueKeys0.KEY_ACCOUNT__PRIMARY;
    public static final UniqueKey<Collect_Record> KEY_COLLECT__PRIMARY = UniqueKeys0.KEY_COLLECT__PRIMARY;
    public static final UniqueKey<College_Record> KEY_COLLEGE__PRIMARY = UniqueKeys0.KEY_COLLEGE__PRIMARY;
    public static final UniqueKey<Competitioncreatoraccount_Record> KEY_COMPETITIONCREATORACCOUNT__PRIMARY = UniqueKeys0.KEY_COMPETITIONCREATORACCOUNT__PRIMARY;
    public static final UniqueKey<Competitionvisible_Record> KEY_COMPETITIONVISIBLE__PRIMARY = UniqueKeys0.KEY_COMPETITIONVISIBLE__PRIMARY;
    public static final UniqueKey<Competition_Record> KEY_COMPETITION__PRIMARY = UniqueKeys0.KEY_COMPETITION__PRIMARY;
    public static final UniqueKey<Department_Record> KEY_DEPARTMENT__PRIMARY = UniqueKeys0.KEY_DEPARTMENT__PRIMARY;
    public static final UniqueKey<Message_Record> KEY_MESSAGE__PRIMARY = UniqueKeys0.KEY_MESSAGE__PRIMARY;
    public static final UniqueKey<Normalaccount_Record> KEY_NORMALACCOUNT__PRIMARY = UniqueKeys0.KEY_NORMALACCOUNT__PRIMARY;
    public static final UniqueKey<Notification_Record> KEY_NOTIFICATION__PRIMARY = UniqueKeys0.KEY_NOTIFICATION__PRIMARY;
    public static final UniqueKey<Openidqqidx_Record> KEY_OPENIDQQIDX__PRIMARY = UniqueKeys0.KEY_OPENIDQQIDX__PRIMARY;
    public static final UniqueKey<Openidwxidx_Record> KEY_OPENIDWXIDX__PRIMARY = UniqueKeys0.KEY_OPENIDWXIDX__PRIMARY;
    public static final UniqueKey<Organizeaccountapplication_Record> KEY_ORGANIZEACCOUNTAPPLICATION__PRIMARY = UniqueKeys0.KEY_ORGANIZEACCOUNTAPPLICATION__PRIMARY;
    public static final UniqueKey<Organizeaccountrelation_Record> KEY_ORGANIZEACCOUNTRELATION__PRIMARY = UniqueKeys0.KEY_ORGANIZEACCOUNTRELATION__PRIMARY;
    public static final UniqueKey<Organize_Record> KEY_ORGANIZE__PRIMARY = UniqueKeys0.KEY_ORGANIZE__PRIMARY;
    public static final UniqueKey<Ossaccount_Record> KEY_OSSACCOUNT__PRIMARY = UniqueKeys0.KEY_OSSACCOUNT__PRIMARY;
    public static final UniqueKey<Rootaccount_Record> KEY_ROOTACCOUNT__PRIMARY = UniqueKeys0.KEY_ROOTACCOUNT__PRIMARY;
    public static final UniqueKey<Uploadfile_Record> KEY_UPLOADFILE__PRIMARY = UniqueKeys0.KEY_UPLOADFILE__PRIMARY;
    public static final UniqueKey<Userlogin_Record> KEY_USERLOGIN__PRIMARY = UniqueKeys0.KEY_USERLOGIN__PRIMARY;
    public static final UniqueKey<User_Record> KEY_USER__PRIMARY = UniqueKeys0.KEY_USER__PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<Accountuserrole_Record, Long> IDENTITY_ACCOUNTUSERROLE_ = Internal.createIdentity(Accountuserrole_.ACCOUNTUSERROLE_, Accountuserrole_.ACCOUNTUSERROLE_.ACCOUNTROLEID);
        public static Identity<Account_Record, Long> IDENTITY_ACCOUNT_ = Internal.createIdentity(Account_.ACCOUNT_, Account_.ACCOUNT_.ACCOUNTID);
        public static Identity<Collect_Record, Long> IDENTITY_COLLECT_ = Internal.createIdentity(Collect_.COLLECT_, Collect_.COLLECT_.ID);
        public static Identity<College_Record, Integer> IDENTITY_COLLEGE_ = Internal.createIdentity(College_.COLLEGE_, College_.COLLEGE_.COLLEGEID);
        public static Identity<Competition_Record, Long> IDENTITY_COMPETITION_ = Internal.createIdentity(Competition_.COMPETITION_, Competition_.COMPETITION_.COMPETITIONID);
        public static Identity<Department_Record, Integer> IDENTITY_DEPARTMENT_ = Internal.createIdentity(Department_.DEPARTMENT_, Department_.DEPARTMENT_.DEPARTMENTID);
        public static Identity<Message_Record, Long> IDENTITY_MESSAGE_ = Internal.createIdentity(Message_.MESSAGE_, Message_.MESSAGE_.ID);
        public static Identity<Notification_Record, Integer> IDENTITY_NOTIFICATION_ = Internal.createIdentity(Notification_.NOTIFICATION_, Notification_.NOTIFICATION_.NOTICEID);
        public static Identity<Organizeaccountapplication_Record, Long> IDENTITY_ORGANIZEACCOUNTAPPLICATION_ = Internal.createIdentity(Organizeaccountapplication_.ORGANIZEACCOUNTAPPLICATION_, Organizeaccountapplication_.ORGANIZEACCOUNTAPPLICATION_.ID);
        public static Identity<Organizeaccountrelation_Record, Long> IDENTITY_ORGANIZEACCOUNTRELATION_ = Internal.createIdentity(Organizeaccountrelation_.ORGANIZEACCOUNTRELATION_, Organizeaccountrelation_.ORGANIZEACCOUNTRELATION_.ID);
        public static Identity<Uploadfile_Record, Integer> IDENTITY_UPLOADFILE_ = Internal.createIdentity(Uploadfile_.UPLOADFILE_, Uploadfile_.UPLOADFILE_.FILEID);
        public static Identity<Userlogin_Record, Long> IDENTITY_USERLOGIN_ = Internal.createIdentity(Userlogin_.USERLOGIN_, Userlogin_.USERLOGIN_.ID);
        public static Identity<User_Record, Long> IDENTITY_USER_ = Internal.createIdentity(User_.USER_, User_.USER_.USERID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<Accountuserrole_Record> KEY_ACCOUNTUSERROLE__PRIMARY = Internal.createUniqueKey(Accountuserrole_.ACCOUNTUSERROLE_, "KEY_AccountUserRole__PRIMARY", Accountuserrole_.ACCOUNTUSERROLE_.ACCOUNTROLEID);
        public static final UniqueKey<Account_Record> KEY_ACCOUNT__PRIMARY = Internal.createUniqueKey(Account_.ACCOUNT_, "KEY_Account__PRIMARY", Account_.ACCOUNT_.ACCOUNTID);
        public static final UniqueKey<Collect_Record> KEY_COLLECT__PRIMARY = Internal.createUniqueKey(Collect_.COLLECT_, "KEY_Collect__PRIMARY", Collect_.COLLECT_.ID);
        public static final UniqueKey<College_Record> KEY_COLLEGE__PRIMARY = Internal.createUniqueKey(College_.COLLEGE_, "KEY_College__PRIMARY", College_.COLLEGE_.COLLEGEID);
        public static final UniqueKey<Competitioncreatoraccount_Record> KEY_COMPETITIONCREATORACCOUNT__PRIMARY = Internal.createUniqueKey(Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_, "KEY_CompetitionCreatorAccount__PRIMARY", Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_.ACCOUNTID);
        public static final UniqueKey<Competitionvisible_Record> KEY_COMPETITIONVISIBLE__PRIMARY = Internal.createUniqueKey(Competitionvisible_.COMPETITIONVISIBLE_, "KEY_CompetitionVisible__PRIMARY", Competitionvisible_.COMPETITIONVISIBLE_.COMPETITIONID, Competitionvisible_.COMPETITIONVISIBLE_.COLLEGEID);
        public static final UniqueKey<Competition_Record> KEY_COMPETITION__PRIMARY = Internal.createUniqueKey(Competition_.COMPETITION_, "KEY_Competition__PRIMARY", Competition_.COMPETITION_.COMPETITIONID);
        public static final UniqueKey<Department_Record> KEY_DEPARTMENT__PRIMARY = Internal.createUniqueKey(Department_.DEPARTMENT_, "KEY_Department__PRIMARY", Department_.DEPARTMENT_.DEPARTMENTID);
        public static final UniqueKey<Message_Record> KEY_MESSAGE__PRIMARY = Internal.createUniqueKey(Message_.MESSAGE_, "KEY_Message__PRIMARY", Message_.MESSAGE_.ID);
        public static final UniqueKey<Normalaccount_Record> KEY_NORMALACCOUNT__PRIMARY = Internal.createUniqueKey(Normalaccount_.NORMALACCOUNT_, "KEY_NormalAccount__PRIMARY", Normalaccount_.NORMALACCOUNT_.ACCOUNTID);
        public static final UniqueKey<Notification_Record> KEY_NOTIFICATION__PRIMARY = Internal.createUniqueKey(Notification_.NOTIFICATION_, "KEY_Notification__PRIMARY", Notification_.NOTIFICATION_.NOTICEID);
        public static final UniqueKey<Openidqqidx_Record> KEY_OPENIDQQIDX__PRIMARY = Internal.createUniqueKey(Openidqqidx_.OPENIDQQIDX_, "KEY_OpenIdQQIdx__PRIMARY", Openidqqidx_.OPENIDQQIDX_.OPENID);
        public static final UniqueKey<Openidwxidx_Record> KEY_OPENIDWXIDX__PRIMARY = Internal.createUniqueKey(Openidwxidx_.OPENIDWXIDX_, "KEY_OpenIdWXIdx__PRIMARY", Openidwxidx_.OPENIDWXIDX_.OPENID);
        public static final UniqueKey<Organizeaccountapplication_Record> KEY_ORGANIZEACCOUNTAPPLICATION__PRIMARY = Internal.createUniqueKey(Organizeaccountapplication_.ORGANIZEACCOUNTAPPLICATION_, "KEY_OrganizeAccountApplication__PRIMARY", Organizeaccountapplication_.ORGANIZEACCOUNTAPPLICATION_.ID);
        public static final UniqueKey<Organizeaccountrelation_Record> KEY_ORGANIZEACCOUNTRELATION__PRIMARY = Internal.createUniqueKey(Organizeaccountrelation_.ORGANIZEACCOUNTRELATION_, "KEY_OrganizeAccountRelation__PRIMARY", Organizeaccountrelation_.ORGANIZEACCOUNTRELATION_.ID);
        public static final UniqueKey<Organize_Record> KEY_ORGANIZE__PRIMARY = Internal.createUniqueKey(Organize_.ORGANIZE_, "KEY_Organize__PRIMARY", Organize_.ORGANIZE_.ORGANIZEID);
        public static final UniqueKey<Ossaccount_Record> KEY_OSSACCOUNT__PRIMARY = Internal.createUniqueKey(Ossaccount_.OSSACCOUNT_, "KEY_OSSAccount__PRIMARY", Ossaccount_.OSSACCOUNT_.ACCOUNTID);
        public static final UniqueKey<Rootaccount_Record> KEY_ROOTACCOUNT__PRIMARY = Internal.createUniqueKey(Rootaccount_.ROOTACCOUNT_, "KEY_RootAccount__PRIMARY", Rootaccount_.ROOTACCOUNT_.ACCOUNTID);
        public static final UniqueKey<Uploadfile_Record> KEY_UPLOADFILE__PRIMARY = Internal.createUniqueKey(Uploadfile_.UPLOADFILE_, "KEY_UploadFile__PRIMARY", Uploadfile_.UPLOADFILE_.FILEID);
        public static final UniqueKey<Userlogin_Record> KEY_USERLOGIN__PRIMARY = Internal.createUniqueKey(Userlogin_.USERLOGIN_, "KEY_UserLogin__PRIMARY", Userlogin_.USERLOGIN_.ID);
        public static final UniqueKey<User_Record> KEY_USER__PRIMARY = Internal.createUniqueKey(User_.USER_, "KEY_User__PRIMARY", User_.USER_.USERID);
    }
}
