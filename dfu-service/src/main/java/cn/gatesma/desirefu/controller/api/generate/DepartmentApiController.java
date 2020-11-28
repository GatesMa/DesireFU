package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.service.DepartmentService;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.jooq.tools.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DepartmentApiController implements DepartmentApi {

    private static final Logger log = LoggerFactory.getLogger(DepartmentApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Resource
    private DepartmentService departmentService;

    @org.springframework.beans.factory.annotation.Autowired
    public DepartmentApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<AddDepartmentRet> addDepartment(@ApiParam(value = "创建学院", required = true) @Valid @RequestBody AddDepartmentRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            AddDepartmentRet response = add(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    @Override
    public ResponseEntity<GetDepartmentRet> getDepartment(@ApiParam(value = "查询学院", required = true) @Valid @RequestBody GetDepartmentRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            GetDepartmentRet ret = get(body);
            return new ResponseEntity<>(ret, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    private GetDepartmentRet get(GetDepartmentRequest request) {
        String name = request.getName();
        Integer collegeId = request.getCollegeId();
        Integer departmentId = request.getDepartmentId();
        if (collegeId == null && departmentId == null && StringUtils.isBlank(name)) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "参数不能都为空");
        }

        return departmentService.getDepartment(departmentId, name, collegeId);
    }

    /**
     * 添加College
     */
    private AddDepartmentRet add(AddDepartmentRequest body) {
        // 健壮性检查
        checkParam(body);

        // 创建学校
        int departmentId = departmentService.createDepartmentIfNotExisted(body);

        // 拼装返回结果
        return RetCodeUtils.ok(new AddDepartmentRet()).data(new AddDepartmentData().departmentId(departmentId));
    }

    private void checkParam(AddDepartmentRequest body) {
        if (StringUtils.isBlank(body.getName())) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "学院名称必传");
        }
        if (body.getCollegeId() == null) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "学校Id必传");
        }
    }

}
