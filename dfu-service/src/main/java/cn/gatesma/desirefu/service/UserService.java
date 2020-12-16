package cn.gatesma.desirefu.service;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.config.TimeFmt;
import cn.gatesma.desirefu.constants.status.DeleteStatus;
import cn.gatesma.desirefu.constants.type.LoginNameType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.User_Record;
import cn.gatesma.desirefu.domain.db.generate.DFU_.tables.records.Userlogin_Record;
import cn.gatesma.desirefu.repository.UserLoginRepository;
import cn.gatesma.desirefu.repository.UserRepository;
import cn.gatesma.desirefu.utils.DistributedSynchronizer;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import cn.gatesma.desirefu.utils.TimeUtils;
import cn.gatesma.desirefu.utils.user.UserUtils;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * User: gatesma
 * Date: 2020-11-14
 * Desc:
 */
@Service
public class UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserLoginRepository userLoginRepository;

    @Resource
    private DistributedSynchronizer synchronizer;

    private final static int EXPIRE_AFTER_MIL_SEC = 600;


    public Long createUserIfNotExisted(String loginName, Integer loginNameType, Long createdUserId, String cellphone, String email, String userName) {
        LOGGER.info("createUserIfNotExisted loginName={}, loginNameType={}, createdUserId={}, " +
                "cellphone={}, email={}, userName={}", loginName, loginNameType, createdUserId, cellphone, email, userName);
        if (Strings.isNullOrEmpty(loginName) || null == loginNameType
                || null == LoginNameType.valueOf(loginNameType)) {
            LOGGER.error("参数loginName loginNameType 不合法");
            return null;
        }

        // 参数
        Login login = new Login().loginName(loginName).loginNameType(loginNameType);
        try {
            // 检查login对应的user是否已存在
            GetUserRet getUserRet = getUser(login);
            if (RetCodeUtils.isOk(getUserRet)) {
                if (UserUtils.isUserNotEmpty(getUserRet)) {
                    // user已存在，则返回user
                    User getRetData = getUserRet.getData();
                    return getRetData.getUserId();
                } else {
                    // user不存在，则新增user
                    return addUser(login, createdUserId, cellphone, email, userName);
                }
            }
        } catch (Throwable e) {
            LOGGER.error("loginName {} loginNameType {} 创建用户失败 ", loginName, loginNameType, e);
        }

        return null;
    }

    /**
     * 创建User
     */
    public Long addUser(Login login, Long createdUserId, String cellphone, String email, String userName) {

        if (null == login || Strings.isNullOrEmpty(login.getLoginName()) || null == login.getLoginNameType()) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "参数有误");
        }

        String loginName = login.getLoginName();
        Integer loginNameType = login.getLoginNameType();
        Timestamp createdTime = TimeUtils.now();

        // 加锁
        return synchronizer.synchronizeByUser(loginName, loginNameType, EXPIRE_AFTER_MIL_SEC, () -> {
            // 参数检查
            if (null == login.getLoginName() || null == login.getLoginNameType()) {
                throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "添加用户数据login信息不能为空");
            }

            // 这里也先校验一次，对应的user不存在，防止出现脏数据
            Userlogin_Record record = userLoginRepository.getLoginUser(loginName, loginNameType, DeleteStatus.NORMAL);
            if (record != null) {
                return record.getUserid();
            }

            // 新增User_表
            Long userId = insertUser(userName, cellphone, email, createdUserId, createdTime);

            // 新增或者更新UserLogin_表
            insertOrUpdateUserLogin(userId, createdUserId, login);

            // 返回结果
            return userId;
        });
    }

    /**
     * 新增或更新User_表，返回主键
     */
    private Long insertUser(String userName, String cellphone, String email, Long createdUserId, Timestamp createdTime) {
        boolean success;

        userName = userName == null ? StringUtils.EMPTY : userName;
        cellphone = cellphone == null ? StringUtils.EMPTY : cellphone;
        email = email == null ? StringUtils.EMPTY : email;
        createdUserId = createdUserId == null ? 0 : createdUserId;

        Long userId = userRepository.insertUser(createdUserId, createdTime, cellphone, email, userName);

        if (null == userId) {
            throw new CustomerApiException(ApiReturnCode.INNER_ERROR, "写入User_表失败");
        }
        return userId;
    }

    /**
     * 新增或更新UserLogin_表
     */
    public void insertOrUpdateUserLogin(Long userId, Long createdUserId, Login login) {
        String loginName = login.getLoginName();
        int loginNameType = login.getLoginNameType();
        // 查询记录，如果存在
        Userlogin_Record loginUser = userLoginRepository.getLoginUser(loginName, loginNameType, null);
        if (loginUser == null) {
            // 新增记录
            userLoginRepository.insertUserLogin(loginName, loginNameType, userId, createdUserId);
        } else {
            if (isUserLoginRecordFieldChanged(loginUser, createdUserId)
                    || (loginUser.getDeletestatus() == DeleteStatus.DELETED.code())) {
                // 真的有字段变更，则修改记录
                userLoginRepository.updateUserLogin(loginUser.getId(), userId, createdUserId, DeleteStatus.NORMAL);
            }
        }
    }

    private boolean isUserLoginRecordFieldChanged(Userlogin_Record record, Long createdUserId) {
        long createdUserIdInInt = createdUserId == null ? 0 : createdUserId;
        long createdUserIdOfRecord = record.getCreateduserid();
        return createdUserIdInInt != createdUserIdOfRecord;
    }


    /**
     * 通过login信息获取user
     */
    public GetUserRet getUser(Login login) {

        String loginName = login.getLoginName();
        Integer loginNameType = login.getLoginNameType();
        // 查询库表
        User data = getUser(loginName, loginNameType);

        // 返回结果
        return (GetUserRet) new GetUserRet().data(data)
                .code(ApiReturnCode.OK.code())
                .message(ApiReturnCode.OK.name());
    }

    /**
     * 根据userId获取User信息
     */
    public GetUserRet getUser(Long userId) {
        // 查询库表
        GetUserRet ret = RetCodeUtils.ok(new GetUserRet());
        User user = getUserById(userId);
        if (null != user) {
            ret.setData(user);
        }
        //返回结果
        return ret;
    }

    public User getUser(String loginName, Integer loginNameType) {
        Userlogin_Record record = userLoginRepository.getLoginUser(loginName, loginNameType, DeleteStatus.NORMAL);
        if (null != record) {
            long userId = record.getUserid();
            return getUserById(userId);
        }
        return null;
    }

    public User getUserById(long userId) {
        User_Record userRecord = userRepository.getUser(userId, DeleteStatus.NORMAL);
        if (null == userRecord) {
            return null;
        }

        User user = new User().userId(userId)
                .deleteStatus(userRecord.getDeletestatus())
                .createdUserId(userRecord.getCreateduserid())
                .createdTime(TimeUtils.convertDateToString(userRecord.getCreatedtime(), TimeFmt.getTimeFmt()))
                .lastModifiedUserId(userRecord.getLastmodifieduserid())
                .lastModifiedTime(TimeUtils.convertDateToString(userRecord.getLastmodifiedtime(), TimeFmt.getTimeFmt()))
                .cellphone(userRecord.getCellphone())
                .userName(userRecord.getUsername())
                .email(userRecord.getEmail());

        List<LoginInfo> logins = new ArrayList<>();

        List<Userlogin_Record> recordList = userLoginRepository.getUserLoginList(userId, DeleteStatus.NORMAL);
        for (Userlogin_Record record : recordList) {
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setLoginName(record.getLoginname());
            loginInfo.setLoginNameType(record.getLoginnametype().intValue());
            logins.add(loginInfo);
        }

        user.setLogins(logins);
        return user;
    }


}
