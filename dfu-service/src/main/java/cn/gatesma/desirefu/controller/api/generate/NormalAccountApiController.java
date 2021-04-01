package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.service.AccountService;
import cn.gatesma.desirefu.service.NormalAccountService;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
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
public class NormalAccountApiController implements NormalAccountApi {

    private static final Logger log = LoggerFactory.getLogger(NormalAccountApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Resource
    private NormalAccountService normalAccountService;

    @org.springframework.beans.factory.annotation.Autowired
    public NormalAccountApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AddNormalAccountRet> addNormalAccount(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody AddNormalAccountRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            AddNormalAccountRet response = add(body);
            return new ResponseEntity<AddNormalAccountRet>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    public ResponseEntity<GetNormalAccountRet> getNormalAccount(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody GetNormalAccountRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            GetNormalAccountRet response = normalAccountService.get(body);
            return new ResponseEntity<GetNormalAccountRet>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }



    private AddNormalAccountRet add(AddNormalAccountRequest request) {

        // 参数校验
        checkParam(request);

        // 账号账号
        Long accountId = normalAccountService.createNormalAccount(request);

        return RetCodeUtils.ok(new AddNormalAccountRet()).data(new AddNormalAccountRetData().accountId(accountId));
    }

    private void checkParam(AddNormalAccountRequest request) {
        if (request.getRootUserId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "userId必须传");
        }

        if (request.getAccountType() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "账号类型必须传");
        }

        if (request.getCollegeId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "学校必须传");
        }

        if (request.getDepartmentId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "学院必须传");
        }

        if (request.getMajor() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "专业必须传");
        }

        if (request.getStuId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "学号必须传");
        }

        if (StringUtils.isBlank(request.getRealName())) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "真实姓名需要传");
        }

        // 校验accountType
        if (!AccountType.accountTypeSet.contains(request.getAccountType())) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "账号类型超出限制");
        }
    }

    public ResponseEntity<GetExamAccountRet> getExamList() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            GetExamAccountRet response = normalAccountService.getExamList();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    public ResponseEntity<GetNormalBasicDataRet> getNormalBasicData(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody GetNormalBasicDataRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            GetNormalBasicDataRet response = normalAccountService.getNormalBasicData(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    public ResponseEntity<GetNormalAccountRet> getNormalAccountFromDB(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody GetNormalAccountRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            GetNormalAccountRet response = normalAccountService.getFromDB(body);
            return new ResponseEntity<GetNormalAccountRet>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }



}
