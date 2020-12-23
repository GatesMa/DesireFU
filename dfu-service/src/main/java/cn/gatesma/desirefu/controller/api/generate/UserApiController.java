package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.type.LoginNameType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.service.UserService;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Resource
    private UserService userService;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<AddUserRet> addUser(
            @ApiParam(value = "创建用户", required = true) @Valid @RequestBody AddUserRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            AddUserRet response = add(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    /**
     * 添加User
     */
    private AddUserRet add(AddUserRequest body) {
        // 健壮性检查
        checkParam(body);

        // 创建用户
        Long userId = userService.createUserIfNotExisted(body.getLoginName(), body.getLoginNameType(), body.getCreatedUserId(),
                body.getCellphone(), body.getEmail(), body.getUserName());

        // 拼装返回结果
        return null != userId ? RetCodeUtils.ok(new AddUserRet()).data(new AddUserRetData().userId(userId))
                : RetCodeUtils.create(new AddUserRet(), ApiReturnCode.INNER_ERROR, "创建用户失败");
    }

    /**
     * 检查/user/add接口参数
     */
    private void checkParam(AddUserRequest body) {
        if (StringUtils.isBlank(body.getLoginName())) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "login_name为空");
        }
        Integer loginNameTypeInt = body.getLoginNameType();
        LoginNameType loginNameType = null;
        if (null != loginNameTypeInt) {
            loginNameType = LoginNameType.valueOf(loginNameTypeInt);
        }

        String loginName = body.getLoginName();
        if (null == loginNameType) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "非法的login_name_type值");
        } else if (LoginNameType.LOGIN_NAME_TYPE_QQ == loginNameType) {
            if (!StringUtils.isNumeric(loginName)) {
                throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "QQ号不合法");
            }
        } else if (LoginNameType.LOGIN_NAME_TYPE_WX == loginNameType) {
            if (StringUtils.isBlank(loginName)) {
                throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "WX号不合法");
            }
        }
    }

    @Override
    public ResponseEntity<GetUserRet> getUser(
            @ApiParam(value = "查询用户", required = true) @Valid @RequestBody GetUserRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            GetUserRet response = get(body);
            return new ResponseEntity<GetUserRet>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    private GetUserRet get(GetUserRequest body) {
        // 参数
        Long userId = body.getUserId();
        String loginName = body.getLoginName();
        Integer loginNameType = body.getLoginNameType();
        // 查询
        GetUserRet ret = null;
        if (userId != null) {
            ret = userService.getUser(userId);
        } else {
            if (StringUtils.isBlank(loginName)) {
                return RetCodeUtils.create(new GetUserRet(), ApiReturnCode.INVALID_ARGUMENT, "login_name为空");
            }
            if (LoginNameType.valueOf(loginNameType) == null) {
                return RetCodeUtils.create(new GetUserRet(), ApiReturnCode.INVALID_ARGUMENT, "非法的login_name_type值");
            }
            ret = userService.getUser(new Login()
                    .loginName(loginName)
                    .loginNameType(loginNameType));
        }

        return ret;
    }

}
