package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.annotation.NeedSyncAddOrganizeAnnotation;
import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.service.OrganizeService;
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
public class OrganizeApiController implements OrganizeApi {

    private static final Logger log = LoggerFactory.getLogger(OrganizeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Resource
    private OrganizeService organizeService;

    @org.springframework.beans.factory.annotation.Autowired
    public OrganizeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    @NeedSyncAddOrganizeAnnotation
    public ResponseEntity<AddOrganizeRet> addOrganize(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody AddOrganizeRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            AddOrganizeRet response = add(body);
            return new ResponseEntity<AddOrganizeRet>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    @Override
    public ResponseEntity<ListOrganizeRet> listOrganize(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody ListOrganizeRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            ListOrganizeRet response = organizeService.list(body);
            return new ResponseEntity<ListOrganizeRet>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    @Override
    public ResponseEntity<UpdateOrganizeApplicationRet> updateOrganizeApplication(@ApiParam(value = "" ,required=true )  @Valid @RequestBody UpdateOrganizeApplicationRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            UpdateOrganizeApplicationRet response = organizeService.update(body);
            return new ResponseEntity<UpdateOrganizeApplicationRet>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    private AddOrganizeRet add(AddOrganizeRequest request) {

        // 参数校验
        checkParam(request);

        // 账号账号
        Long organizeId = organizeService.createOrganize(request);

        return RetCodeUtils.ok(new AddOrganizeRet()).data(new AddOrganizeRetData().organizeId(organizeId));
    }

    private void checkParam(AddOrganizeRequest request) {
        if (request.getRootUserId() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "userId必须传");
        }

        if (request.getAccountType() == null) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "账号类型必须传");
        }

        if (!request.getAccountType().equals(AccountType.ORGANIZE.getValue())) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "AccountType不是OSS账号");
        }

        // 校验accountType
        if (!AccountType.accountTypeSet.contains(request.getAccountType())) {
            throw new CustomerApiException(ApiReturnCode.ILLEGAL_PARAM, "账号类型超出限制");
        }
    }

    @Override
    public ResponseEntity<GetExamOrganizeRet> getExamOrganizeList() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            GetExamOrganizeRet response = organizeService.getExamOrganizeList();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    @Override
    public ResponseEntity<ListOrganizeMemberRet> listMember(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody ListOrganizeMemberRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            ListOrganizeMemberRet response = organizeService.listMember(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    @Override
    public ResponseEntity<ListOrganizeRet> listFromDB(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody ListOrganizeRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            ListOrganizeRet response = organizeService.listFromDB(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

}
