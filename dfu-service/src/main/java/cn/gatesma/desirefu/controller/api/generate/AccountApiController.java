package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.type.AccountTypeEnum;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.service.AccountService;
import cn.gatesma.desirefu.service.CollegeService;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
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
        if (!AccountTypeEnum.accountTypeSet.contains(request.getAccountType())) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "账号类型超出限制");
        }

        // 账号账号
        Long accountId = accountService.createAccount(request);

        return RetCodeUtils.ok(new AddAccountRet()).data(new AddAccountRetData().accountId(accountId));
    }


}
