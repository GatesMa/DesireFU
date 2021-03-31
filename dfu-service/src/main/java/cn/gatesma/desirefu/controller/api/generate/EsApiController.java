package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.domain.api.generate.AddAccountRet;
import cn.gatesma.desirefu.domain.api.generate.AddAccountRetData;
import cn.gatesma.desirefu.domain.api.generate.ReturnCode;
import cn.gatesma.desirefu.service.processor.BatchSyncAccountToEsProcessor;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Controller
public class EsApiController implements EsApi {

    private static final Logger log = LoggerFactory.getLogger(EsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Resource
    private BatchSyncAccountToEsProcessor sycnAccountToEsProcessor;

    @org.springframework.beans.factory.annotation.Autowired
    public EsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ReturnCode> syncSubNormalAccount(@NotNull @ApiParam(value = "账号ID，;分割", required = true) @Valid @RequestParam(value = "accountIds", required = true) String accountIds) {
        List<Long> accountIdList = new ArrayList<>();

        String[] array = accountIds.split(";");
        for (String id : array) {
            accountIdList.add(Long.valueOf(id));
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                sycnAccountToEsProcessor.syncSubAccountToEs(accountIdList);
            }
        }).start();

        ReturnCode returnCode = RetCodeUtils.create(ApiReturnCode.OK.code(), "account批量同步中，请不要重复调用");
        return new ResponseEntity<ReturnCode>(returnCode, HttpStatus.OK);
    }

    public ResponseEntity<ReturnCode> syncAllNormalAccount() {


        sycnAccountToEsProcessor.syncAllAccountToEs();


        ReturnCode returnCode = RetCodeUtils.create(ApiReturnCode.OK.code(), "account批量同步中，请不要重复调用");
        return new ResponseEntity<ReturnCode>(returnCode, HttpStatus.OK);
    }

}
