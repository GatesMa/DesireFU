
package cn.gatesma.desirefu.service.upload.validator;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.domain.api.generate.ReturnCode;
import cn.gatesma.desirefu.service.model.UploadFileModel;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Component
public class PDFValidator implements FileFormatValidator {

    @Override
    public ReturnCode validate(UploadFileModel fileModel) {
        try {
            MultipartFile upfile = fileModel.getUpfile();
            byte[] fileContent = fileModel.getContent();
            return (ArrayUtils.isEmpty(fileContent) ? validate(upfile.getInputStream()) : validate(fileContent))
                    ? RetCodeUtils.ok()
                    : RetCodeUtils.create(ApiReturnCode.UPLOAD_FILE_TYPE_INCONSISTENT, "文件与指定类型不一致");
        } catch (IOException e) {
            return RetCodeUtils.create(ApiReturnCode.UPLOAD_FILE_TYPE_INCONSISTENT, "文件与指定类型不一致");
        }
    }

    public boolean validate(InputStream in) {
        try (InputStream input = in) {
            return validate(IOUtils.toByteArray(input, 4));
        } catch (IOException e) {
            return false;
        }
    }

    public boolean validate(byte[] content) {
        return content != null && content.length >= 4 && content[0] == 0x25 && content[1] == 0x50 && content[2] == 0x44 && content[3] == 0x46;
    }

}

