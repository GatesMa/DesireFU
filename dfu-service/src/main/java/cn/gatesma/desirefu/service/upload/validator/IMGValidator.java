
package cn.gatesma.desirefu.service.upload.validator;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.domain.api.generate.ReturnCode;
import cn.gatesma.desirefu.service.model.UploadFileModel;
import cn.gatesma.desirefu.utils.RetCodeUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Component
public class IMGValidator implements FileFormatValidator {



    @Override
    public ReturnCode validate(UploadFileModel fileModel) {
        try {
            MultipartFile upfile = fileModel.getUpfile();
            long fileSize = upfile.getSize();
//            if (fileSize > fileSizeLimit) {
//                return RetCodeUtils.create(ApiReturnCode.UPLOAD_FILE_EXCEEDS_LIMIT, "图片大小超过限制");
//            }
            //
            byte[] fileContent = fileModel.getContent();
            return (ArrayUtils.isEmpty(fileContent) ? validate(upfile.getInputStream()) : validate(fileContent))
                    ? RetCodeUtils.ok()
                    : RetCodeUtils.create(ApiReturnCode.UPLOAD_FILE_TYPE_INCONSISTENT, "文件与指定类型不一致");
        } catch (Exception e) {
            return RetCodeUtils.create(ApiReturnCode.UPLOAD_FILE_TYPE_INCONSISTENT, "文件与指定类型不一致");
        }
    }


    public boolean validate(InputStream in) throws IOException {
        try (InputStream input = in) {
            return validate(IOUtils.toByteArray(input));
        }
    }


    public boolean validate(byte[] content) throws IOException {
        ImageInputStream imgInputStream = ImageIO.createImageInputStream(new ByteArrayInputStream(content));
        Iterator<ImageReader> imgReaders = ImageIO.getImageReaders(imgInputStream);
        return imgReaders != null && imgReaders.hasNext();
    }


}

