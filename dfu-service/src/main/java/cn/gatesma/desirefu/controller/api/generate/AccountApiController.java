package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.service.AccountService;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountApiController implements AccountApi {

    private static final Logger log = LoggerFactory.getLogger(AccountApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Resource
    private AccountService accountService;

    @org.springframework.beans.factory.annotation.Autowired
    public AccountApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<AddAccountRet> addAccount(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody AddAccountRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            AddAccountRet response = add(body);
            return new ResponseEntity<AddAccountRet>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    private AddAccountRet add(AddAccountRequest request) {

        if (request.getRootUserId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "userId必须传");
        }

        if (request.getAccountType() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "账号类型必须传");
        }

        // 校验accountType
        if (!AccountType.accountTypeSet.contains(request.getAccountType())) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "账号类型超出限制");
        }

        // 账号账号
        Long accountId = accountService.createAccount(request);

        return RetCodeUtils.ok(new AddAccountRet()).data(new AddAccountRetData().accountId(accountId));
    }

    public ResponseEntity<UpdateAccountRet> updateAccount(@ApiParam(value = "更新账号" ,required=true )  @Valid @RequestBody UpdateAccountRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            UpdateAccountRet response = accountService.updateAccount(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }


}
