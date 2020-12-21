/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.8).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.domain.api.generate.CodeToWxOpenIdRequest;
import cn.gatesma.desirefu.domain.api.generate.CodeToWxOpenIdRet;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@Api(value = "ExternalInterface", tags = {"外部接口"}, description = "the ExternalInterface API")
public interface ExternalInterfaceApi {

    @ApiOperation(value = "通过code，调用微信接口获取微信账号的openId", nickname = "codeToWxOpenId", notes = "获取微信账号的openId", response = CodeToWxOpenIdRet.class, tags = {"外部接口"})
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CodeToWxOpenIdRet.class),
        @ApiResponse(code = 400, message = "Invalid RequestBody supplied"),
        @ApiResponse(code = 404, message = "RequestBody not found") })
    @RequestMapping(value = "/external/code_2_wx_openid",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<CodeToWxOpenIdRet> codeToWxOpenId(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CodeToWxOpenIdRequest body);

}