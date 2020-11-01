package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.domain.api.generate.AddUserRequest;
import cn.gatesma.desirefu.domain.api.generate.AddUserRet;
import cn.gatesma.desirefu.domain.api.generate.GetUserRequest;
import cn.gatesma.desirefu.domain.api.generate.GetUserRet;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AddUserRet> addUser(
            @ApiParam(value = "创建用户", required = true) @Valid @RequestBody AddUserRequest body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<AddUserRet>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GetUserRet> getUser(
            @ApiParam(value = "查询用户", required = true) @Valid @RequestBody GetUserRequest body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<GetUserRet>(HttpStatus.NOT_IMPLEMENTED);
    }

}
