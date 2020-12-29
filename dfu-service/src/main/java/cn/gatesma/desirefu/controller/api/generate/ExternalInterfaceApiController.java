package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.type.LoginNameType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.service.ExternalInterfaceService;
import cn.gatesma.desirefu.utils.EnvUtil;
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
public class ExternalInterfaceApiController implements ExternalInterfaceApi {

    private static final Logger log = LoggerFactory.getLogger(ExternalInterfaceApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Resource
    private ExternalInterfaceService externalInterfaceService;

    @org.springframework.beans.factory.annotation.Autowired
    public ExternalInterfaceApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CodeToWxOpenIdRet> codeToWxOpenId(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CodeToWxOpenIdRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            CodeToWxOpenIdRet response = get(body);
            return new ResponseEntity<CodeToWxOpenIdRet>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    private CodeToWxOpenIdRet get(CodeToWxOpenIdRequest body) {


        CodeToWxOpenIdRet ret = RetCodeUtils.ok(new CodeToWxOpenIdRet());

        // 开发环境直接返回我的微信号即可
        if (EnvUtil.isDevEnv()) {
            ret.setData(new CodeToWxOpenIdData().code(body.getCode()).openId("oNMqH5BpVtDgoo7zdvcjej_w-mwE"));
        } else {
            String openId = externalInterfaceService.code2WXOpenId(body);
            ret.setData(new CodeToWxOpenIdData().code(body.getCode()).openId(openId));
        }

        return ret;
    }


}
