package cn.gatesma.desirefu.controller.api.generate;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.UploadFileRet;
import cn.gatesma.desirefu.service.model.UploadFileModel;
import cn.gatesma.desirefu.service.upload.UploadService;
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

import javax.annotation.Resource;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class UploadApiController implements UploadApi {

    private static final Logger log = LoggerFactory.getLogger(UploadApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Resource
    private UploadService uploadService;

    @org.springframework.beans.factory.annotation.Autowired
    public UploadApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<UploadFileRet> uploadFile(@ApiParam(value = "", required = true) @RequestParam(value = "account_id", required = true) Long accountId,
                                                    @ApiParam(value = "", required = true) @RequestParam(value = "account_type", required = true) Integer accountType,
                                                    @ApiParam(value = "", required = false) @RequestParam(value = "file_name", required = false) String fileName,
                                                    @ApiParam(value = "", required = true) @RequestParam(value = "file_type", required = true) String fileType,
                                                    @ApiParam(value = "file detail") @Valid @RequestPart("file") MultipartFile upfile) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            UploadFileRet response = upload(accountId, accountType, fileName, fileType, upfile);
            return new ResponseEntity<UploadFileRet>(response, HttpStatus.OK);
        } else {
            throw new CustomerApiException(ApiReturnCode.HEADER_ACCEPT_MISSING, "Accept 'application/json' was expected");
        }
    }

    private UploadFileRet upload(Long accountId, Integer accountType, String fileName, String fileType, MultipartFile upfile) {
        try {
            if (upfile == null || upfile.isEmpty()) {
                return (UploadFileRet) new UploadFileRet().code(ApiReturnCode.UPLOAD_FILE_EMPTY_ERROR.code()).message("上传的文件为空");
            }

            return uploadService.uploadFile(new UploadFileModel()
                    .accountId(accountId)
                    .accountType(accountType)
                    .fileName(fileName)
                    .fileType(fileType)
                    .upfile(upfile)
                    .content(upfile.getBytes()));
        } catch (CustomerApiException e) {
            throw e;
        } catch (Throwable e) {
            log.error("upload File error!", e);
            throw new CustomerApiException(ApiReturnCode.INNER_ERROR, e.getMessage() == null ? e.toString() : e.getMessage());
        }
    }


}
