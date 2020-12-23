package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.service.CompetitionCreatorAccountService;
import cn.gatesma.desirefu.service.OssAccountService;
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
public class OssAccountApiController implements OssAccountApi {

    private static final Logger log = LoggerFactory.getLogger(OssAccountApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Resource
    private OssAccountService ossAccountService;

    @org.springframework.beans.factory.annotation.Autowired
    public OssAccountApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AddOSSAccountRet> addOSSAccount(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody AddOSSAccountRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            AddOSSAccountRet response = add(body);
            return new ResponseEntity<AddOSSAccountRet>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    private AddOSSAccountRet add(AddOSSAccountRequest request) {

        // 参数校验
        checkParam(request);

        // 账号账号
        Long accountId = ossAccountService.createOssAccount(request);

        return RetCodeUtils.ok(new AddOSSAccountRet()).data(new AddOSSAccountRetData().accountId(accountId));
    }

    private void checkParam(AddOSSAccountRequest request) {
        if (request.getRootUserId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "userId必须传");
        }

        if (request.getAccountType() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "账号类型必须传");
        }

        if (!request.getAccountType().equals(AccountType.OSS.getValue())) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "AccountType不是OSS账号");
        }

        // 校验accountType
        if (!AccountType.accountTypeSet.contains(request.getAccountType())) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "账号类型超出限制");
        }
    }

}
