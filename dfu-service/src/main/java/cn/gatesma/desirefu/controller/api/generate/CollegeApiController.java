package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.service.CollegeService;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.jooq.tools.StringUtils;
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
public class CollegeApiController implements CollegeApi {

    private static final Logger log = LoggerFactory.getLogger(CollegeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;


    @Resource
    private CollegeService collegeService;

    @org.springframework.beans.factory.annotation.Autowired
    public CollegeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<AddCollegeRet> addCollege(@ApiParam(value = "创建学校" ,required=true )  @Valid @RequestBody AddCollegeRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            AddCollegeRet response = add(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    @Override
    public ResponseEntity<GetCollegeRet> getCollege(@ApiParam(value = "查询高校" ,required=true )  @Valid @RequestBody GetCollegeRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            GetCollegeRet ret = get(body);
            return new ResponseEntity<>(ret, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    private GetCollegeRet get(GetCollegeRequest request) {
        String identification = request.getIdentification();
        String ministry = request.getMinistry();
        String name = request.getName();
        if (StringUtils.isBlank(identification) && StringUtils.isBlank(ministry) && StringUtils.isBlank(name)) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "参数不能都为空");
        }

        return collegeService.getCollege(name, ministry, identification);
    }

    /**
     * 添加College
     */
    private AddCollegeRet add(AddCollegeRequest body) {
        // 健壮性检查
        checkParam(body);

        // 创建学校
        Integer collegeId = collegeService.createCollegeIfNotExisted(body);

        // 拼装返回结果
        return RetCodeUtils.ok(new AddCollegeRet()).data(new AddCollegeData().collegeId(collegeId));
    }

    private void checkParam(AddCollegeRequest body) {
        if (StringUtils.isBlank(body.getName())) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "学校名称必传");
        }
        if (StringUtils.isBlank(body.getIdentification())) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "学校标识码必传");
        }
        if (StringUtils.isBlank(body.getMinistry())) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "学校主管部门必传");
        }
    }


}
