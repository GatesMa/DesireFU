/*
 * This file is generated by jOOQ.
*/
package cn.gatesma.desirefu.domain.db.generate.DFU_;


import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Account_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Accountuserrole_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.College_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Competition_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Competitioncreatoraccount_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Competitionvisible_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Department_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Normalaccount_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Openidqqidx_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Openidwxidx_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Ossaccount_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Rootaccount_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.User_;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.Userlogin_;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in DFU_
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * 用于存储账号对应用户和角色信息
     */
    public static final Accountuserrole_ ACCOUNTUSERROLE_ = Accountuserrole_.ACCOUNTUSERROLE_;

    /**
     * The table <code>DFU_.Account_</code>.
     */
    public static final Account_ ACCOUNT_ = Account_.ACCOUNT_;

    /**
     * 高校信息
     */
    public static final College_ COLLEGE_ = College_.COLLEGE_;

    /**
     * 比赛创建者账号
     */
    public static final Competitioncreatoraccount_ COMPETITIONCREATORACCOUNT_ = Competitioncreatoraccount_.COMPETITIONCREATORACCOUNT_;

    /**
     * 高校可见比赛表
     */
    public static final Competitionvisible_ COMPETITIONVISIBLE_ = Competitionvisible_.COMPETITIONVISIBLE_;

    /**
     * 比赛
     */
    public static final Competition_ COMPETITION_ = Competition_.COMPETITION_;

    /**
     * 学院信息
     */
    public static final Department_ DEPARTMENT_ = Department_.DEPARTMENT_;

    /**
     * 普通学生账号
     */
    public static final Normalaccount_ NORMALACCOUNT_ = Normalaccount_.NORMALACCOUNT_;

    /**
     * 用于存储openId对应qq关联关系
     */
    public static final Openidqqidx_ OPENIDQQIDX_ = Openidqqidx_.OPENIDQQIDX_;

    /**
     * 用于存储openId对应wx关联关系
     */
    public static final Openidwxidx_ OPENIDWXIDX_ = Openidwxidx_.OPENIDWXIDX_;

    /**
     * OSS运营人员账号
     */
    public static final Ossaccount_ OSSACCOUNT_ = Ossaccount_.OSSACCOUNT_;

    /**
     * ROOT账号
     */
    public static final Rootaccount_ ROOTACCOUNT_ = Rootaccount_.ROOTACCOUNT_;

    /**
     * 用户登录表
     */
    public static final Userlogin_ USERLOGIN_ = Userlogin_.USERLOGIN_;

    /**
     * The table <code>DFU_.User_</code>.
     */
    public static final User_ USER_ = User_.USER_;
}
