package cn.gatesma.desirefu.service.upload;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.domain.api.generate.ReturnCode;
import cn.gatesma.desirefu.domain.api.generate.UploadFileRet;
import cn.gatesma.desirefu.domain.api.generate.UploadFileRetData;
import cn.gatesma.desirefu.repository.UploadFileRepository;
import cn.gatesma.desirefu.service.model.UploadFileModel;
import cn.gatesma.desirefu.service.upload.validator.IMGValidator;
import cn.gatesma.desirefu.service.upload.validator.PDFValidator;
import cn.gatesma.desirefu.service.upload.validator.PPTValidator;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import cn.gatesma.desirefu.utils.UploadUtils;
import cn.hutool.core.util.IdUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * User: gatesma
 * Date: 2021/1/13 4:05 下午
 * Desc:
 */
@Service
public class UploadService {

    @Resource
    private UploadFileRepository uploadRepository;

    @Resource
    private PDFValidator pdfValidator;

    @Resource
    private IMGValidator imgValidator;

    @Resource
    private PPTValidator pptValidator;

    @Resource
    private COSClient cosClient;

    @Value("${tencent.cos.bucketName}")
    private String bucketName;

    @Value("${tencent.cos.region}")
    private String region;

    private static final String DOMAIN = "myqcloud.com";


    public UploadFileRet uploadFile(UploadFileModel fileModel) throws Exception {

        // 参数校验
        UploadFileRet ret = checkParam(fileModel);
        if(RetCodeUtils.isNotOk(ret)) {
            return ret;
        }

        // 获取上传的文件后缀名
        String originalFilename = fileModel.getUpfile().getOriginalFilename();
        int idx = originalFilename.lastIndexOf(".");
        String suffixName = "";
        // 防止有些图片，没有后缀名，但是确实是张图片
        if (idx != -1) {
            suffixName = originalFilename.substring(idx);
        }

        // 1。 上传至COS
        // filename: 如果没传，就使用uuid.后缀名，如果名字重复会覆盖
        if (StringUtils.isBlank(fileModel.getFileName()) || "null".equals(fileModel.getFileName())) {
            fileModel.setFileName(IdUtil.randomUUID() + suffixName);
        }

        // MultipartFile 转 file
        File file = UploadUtils.multipartFileToFile(fileModel.getUpfile(), fileModel.getFileName());

        String key = fileModel.getFileType().toLowerCase() + "/" + fileModel.getFileName();
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        // 下载链接 例如 https://dfu-1257282228.cos.ap-chengdu.myqcloud.com/img/f62d91c6-3007-448f-843c-91b847a86431.png
        String url = "https://" +  bucketName + ".cos." + region + "." + DOMAIN + "/" + key;

        // 2. 插入uploadFile记录
        uploadRepository.createUploadFile(fileModel.getFileType(), fileModel.getAccountId(), fileModel.getAccountType(), fileModel.getFileName(), url);


        // 上传文件成功之后，删除临时文件
        UploadUtils.forceDelete(file);

        UploadFileRetData data = new UploadFileRetData();
        data.setFileUrl(url);

        // 设置返回的url
        ret.data(data);

        return ret;
    }



    public UploadFileRet checkParam(UploadFileModel fileModel) {

        // 检查参数健壮性
        if (fileModel == null) {
            return (UploadFileRet) new UploadFileRet().code(ApiReturnCode.PARAMETER_EMPTY.code()).message("参数为空");
        }
        // 检查账号
        Long accountId = fileModel.getAccountId();
        Integer accountType = fileModel.getAccountType();
        if (accountId == null || accountType == null) {
            return (UploadFileRet) new UploadFileRet().code(ApiReturnCode.ACCOUNT_MISSING_ERROR.code()).message("账号信息为空");
        }
        // 检查文件内容是否为空
        MultipartFile upfile = fileModel.getUpfile();
        if (upfile == null || upfile.isEmpty()) {
            return (UploadFileRet) new UploadFileRet().code(ApiReturnCode.UPLOAD_FILE_EMPTY_ERROR.code()).message("上传的文件为空");
        }
        // 检查文件类型是否与上传内容一致
        ReturnCode retCode = null;
        String fileType = fileModel.getFileType();
        if (UploadUtils.isFileTypePDF(fileType)) {
            retCode = pdfValidator.validate(fileModel);
        } else if (UploadUtils.isFileTypeIMG(fileType)) {
            retCode = imgValidator.validate(fileModel);
        } else if (UploadUtils.isFileTypePPT(fileType)) {
            retCode = pptValidator.validate(fileModel);
        } else {
            // 其他类型
            retCode = RetCodeUtils.ok();
        }
        if (RetCodeUtils.isNotOk(retCode)) {
            return RetCodeUtils.create(new UploadFileRet(), retCode);
        }
        // 校验正常
        return RetCodeUtils.ok(new UploadFileRet());
    }

}
