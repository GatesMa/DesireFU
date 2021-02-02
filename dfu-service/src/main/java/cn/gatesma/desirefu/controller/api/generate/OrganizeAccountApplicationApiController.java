package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.repository.OrganizeAccountApplicationRepository;
import cn.gatesma.desirefu.service.OrganizeApplicationService;
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
public class OrganizeAccountApplicationApiController implements OrganizeAccountApplicationApi {

    private static final Logger log = LoggerFactory.getLogger(OrganizeAccountApplicationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Resource
    private OrganizeApplicationService organizeApplicationService;

    @org.springframework.beans.factory.annotation.Autowired
    public OrganizeAccountApplicationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AddOrganizeApplicationRet> addOrganizeApplication(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody AddOrganizeApplicationRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            AddOrganizeApplicationRet ret = organizeApplicationService.createOrganizeApplication(body);
            return new ResponseEntity<>(ret, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    public ResponseEntity<SelectOrganizeApplicationRet> selectOrganizeApplication(@ApiParam(value = "" ,required=true )  @Valid @RequestBody SelectOrganizeApplicationRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            SelectOrganizeApplicationRet response = organizeApplicationService.list(body);
            return new ResponseEntity<SelectOrganizeApplicationRet>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

}
