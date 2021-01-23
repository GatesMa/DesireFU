/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.8).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.domain.api.generate.AddNotificationRequest;
import cn.gatesma.desirefu.domain.api.generate.AddNotificationRet;
import cn.gatesma.desirefu.domain.api.generate.SelectNotificationRequest;
import cn.gatesma.desirefu.domain.api.generate.SelectNotificationRet;
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
@Api(value = "Notification", tags={ "公告", }, description = "the Notification API")
public interface NotificationApi {

    @ApiOperation(value = "创建公告", nickname = "addNotification", notes = "创建公告", response = AddNotificationRet.class, tags={ "公告", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AddNotificationRet.class),
        @ApiResponse(code = 400, message = "Invalid RequestBody supplied"),
        @ApiResponse(code = 404, message = "RequestBody not found") })
    @RequestMapping(value = "/notification/add",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<AddNotificationRet> addNotification(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody AddNotificationRequest body);

    @ApiOperation(value = "获取公告", nickname = "selectNotification", notes = "获取公告", response = SelectNotificationRet.class, tags={ "公告", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = SelectNotificationRet.class),
            @ApiResponse(code = 400, message = "Invalid RequestBody supplied"),
            @ApiResponse(code = 404, message = "RequestBody not found") })
    @RequestMapping(value = "/notification/select",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<SelectNotificationRet> selectNotification(@ApiParam(value = "" ,required=true )  @Valid @RequestBody SelectNotificationRequest body);


}