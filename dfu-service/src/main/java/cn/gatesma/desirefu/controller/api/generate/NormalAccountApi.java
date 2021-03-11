/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.8).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.domain.api.generate.*;
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
@Api(value = "NormalAccount", tags={ "普通账号", }, description = "the NormalAccount API")
public interface NormalAccountApi {

    @ApiOperation(value = "创建普通学生账号", nickname = "addAccount", notes = "创建普通学生账号，返回\"账号ID\"", response = AddNormalAccountRet.class, tags={ "普通账号", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AddNormalAccountRet.class),
        @ApiResponse(code = 400, message = "Invalid RequestBody supplied"),
        @ApiResponse(code = 404, message = "RequestBody not found") })
    @RequestMapping(value = "/normal_account/add",
        produces = { "application/json" },
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<AddNormalAccountRet> addNormalAccount(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody AddNormalAccountRequest body);

    @ApiOperation(value = "搜索学生账号", nickname = "getNormalAccount", notes = "搜索学生账号", response = GetNormalAccountRet.class, tags={ "普通账号", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = GetNormalAccountRet.class),
            @ApiResponse(code = 400, message = "Invalid RequestBody supplied"),
            @ApiResponse(code = 404, message = "RequestBody not found") })
    @RequestMapping(value = "/normal_account/get",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<GetNormalAccountRet> getNormalAccount(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody GetNormalAccountRequest body);

    @ApiOperation(value = "获取未审核学生账号", nickname = "getExamList", notes = "获取未审核学生账号", response = GetExamAccountRet.class, tags={ "普通账号", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = GetExamAccountRet.class),
            @ApiResponse(code = 400, message = "Invalid RequestBody supplied"),
            @ApiResponse(code = 404, message = "RequestBody not found") })
    @RequestMapping(value = "/normal_account/getExamList",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<GetExamAccountRet> getExamList();

    @ApiOperation(value = "学生系统获取账号基本数据", nickname = "getNormalBasicData", notes = "学生系统获取账号基本数据", response = GetNormalBasicDataRet.class, tags={ "NormalAccount", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = GetNormalBasicDataRet.class),
            @ApiResponse(code = 400, message = "Invalid RequestBody supplied"),
            @ApiResponse(code = 404, message = "RequestBody not found") })
    @RequestMapping(value = "/normal_account/get_basic_number",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<GetNormalBasicDataRet> getNormalBasicData(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody GetNormalBasicDataRequest body);


}
