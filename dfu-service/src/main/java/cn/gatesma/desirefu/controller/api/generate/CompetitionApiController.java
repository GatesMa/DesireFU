package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.type.AccountType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.*;
import cn.gatesma.desirefu.service.AccountService;
import cn.gatesma.desirefu.service.CompetitionService;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
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
public class CompetitionApiController implements CompetitionApi {

    private static final Logger log = LoggerFactory.getLogger(CompetitionApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Resource
    private CompetitionService competitionService;

    @Resource
    private AccountService accountService;

    @org.springframework.beans.factory.annotation.Autowired
    public CompetitionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AddCompetitionRet> addCompetition(@ApiParam(value = "创建账号" ,required=true )  @Valid @RequestBody AddCompetitionRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            competitionService.createCompetition(body);
            AddCompetitionRet response = RetCodeUtils.ok(new AddCompetitionRet());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    public ResponseEntity<SelectCompetitionRet> selectScrollCompetition(@ApiParam(value = "" ,required=true )  @Valid @RequestBody SelectCompetitionRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            SelectCompetitionRet response = competitionService.selectCompetition(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    public ResponseEntity<CollectCompetitionRet> collectCompetition(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CollectCompetitionRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            CollectCompetitionRet response = competitionService.collectCompetition(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    public ResponseEntity<GetCollectCompetitionRet> getCollectCompetition(@ApiParam(value = "" ,required=true )  @Valid @RequestBody GetCollectCompetitionRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            GetCollectCompetitionRet response = competitionService.getCollectCompetition(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    public ResponseEntity<CheckCollectCompetitionRet> checkCollectCompetition(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CheckCollectCompetitionRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            CheckCollectCompetitionRet response = competitionService.checkCollectCompetition(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

}
