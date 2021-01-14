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
public class PPTValidator implements FileFormatValidator {

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
            return validate(IOUtils.toByteArray(input, 8));
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 编码：https://filesignatures.net/index.php?search=PPTX&mode=EXT 或 https://en.wikipedia.org/wiki/List_of_file_signatures#cite_note-13
     */
    public boolean validate(byte[] content) {
        if (ArrayUtils.isEmpty(content) || content.length < 4) {
            return false;
        }
        boolean isPptFormat = content.length >= 8 && content[0] == 0XD0 && content[1] == 0XCF && content[2] == 0X11 && content[3] == 0XE0
                && content[4] == 0XA1 && content[5] == 0XB1 && content[6] == 0X1A && content[7] == 0XE1;
        boolean isPptxFormat = content.length >= 4 && content[0] == 0x50 && content[1] == 0x4B && content[2] == 0x03 && content[3] == 0x04;
        return isPptFormat || isPptxFormat;
    }
}

