package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.CanLoginAccountRequest;
import cn.gatesma.desirefu.domain.api.generate.CanLoginAccountRet;
import cn.gatesma.desirefu.domain.api.generate.GetDepartmentRequest;
import cn.gatesma.desirefu.domain.api.generate.GetDepartmentRet;
import cn.gatesma.desirefu.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.jooq.tools.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@Controller
public class LoginApiController implements LoginApi {

    private static final Logger log = LoggerFactory.getLogger(LoginApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Resource
    private LoginService loginService;

    @org.springframework.beans.factory.annotation.Autowired
    public LoginApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CanLoginAccountRet> canLoginAccount(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CanLoginAccountRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            CanLoginAccountRet ret = getCanLoginAccount(body);
            return new ResponseEntity<>(ret, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    private CanLoginAccountRet getCanLoginAccount(CanLoginAccountRequest request) {
        String loginName = request.getLoginName();
        Integer loginNameType = request.getLoginNameType();
        Long userId = request.getUserId();

        // 校验，loginName,loginNameType与userId必须传一个
        if (userId == null) {
            if (loginNameType == null && StringUtils.isBlank(loginName)) {
                throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "loginName,loginNameType与userId必须传一个");
            }
        }

        return loginService.getCanLoginAccount(request);
    }

}
