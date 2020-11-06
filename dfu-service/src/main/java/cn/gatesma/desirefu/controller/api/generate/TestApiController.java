package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.domain.api.generate.HelloRet;
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

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@Controller
public class TestApiController implements TestApi {

    private static final Logger log = LoggerFactory.getLogger(TestApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TestApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<HelloRet> hello() {

        HelloRet ret = RetCodeUtils.ok(new HelloRet());;
        ret.setData("Hello! It's DesireFu!");
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

}
