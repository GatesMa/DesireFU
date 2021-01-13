package cn.gatesma.desirefu.utils;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.type.UploadFileType;
import cn.gatesma.desirefu.controller.api.CustomerApiException;
import cn.gatesma.desirefu.service.model.UploadFileModel;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.trimToEmpty;

/**
 * User: gatesma
 * Date: 2021/1/13 4:22 下午
 * Desc:
 */
public class UploadUtils {

    /**
     * 根据accountId、文件内容md5，生成文件fileId
     *
     * @param accountId
     * @param md5
     * @return
     */
    public static String toFileId(Long accountId, String md5) {
        if (accountId == null || StringUtils.isBlank(md5)) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "生成fileId失败");
        }
        return new StringBuilder().append(accountId).append(":").append(md5).toString();
    }

    /**
     * @param fileId
     * @param fileType
     * @return
     * @throws IOException
     */
    public static String generateCdnFileId(String fileId, String fileType) throws IOException {
        // 判断fileId是否为空
        if (StringUtils.isBlank(fileId)) {
            throw new CustomerApiException(ApiReturnCode.INVALID_ARGUMENT, "fileId为空");
        }
        // 生成cdnFileId
        StringBuilder cdnFileId = new StringBuilder();
        cdnFileId.append(CommonUtils.md5(fileId, StandardCharsets.ISO_8859_1));
        if (StringUtils.isNotBlank(fileType)) {
            cdnFileId.append(".").append(fileType);
        }
        // 返回结果
        return cdnFileId.toString();
    }

    /**
     * 判断上传文件类型是否有效
     *
     * @param fileType
     * @return
     */
    public static boolean isValidFileType(String fileType) {
        return UploadFileType.parse(fileType) != null;
    }

    public static boolean isFileTypePDF(String fileType) {
        return UploadFileType.parse(fileType) == UploadFileType.PDF;
    }

    public static boolean isFileTypeIMG(String fileType) {
        return UploadFileType.parse(fileType) == UploadFileType.IMG;
    }

    public static boolean isFileTypePPT(String fileType) {
        return UploadFileType.parse(fileType) == UploadFileType.PPT;
    }

    /**
     * 根据wiki中PDF的定义，PDF文件开始的4个字节为%PDF，即：hex 25 50 44 46
     *
     * @param content
     * @return
     */
    public static boolean isPDF(byte[] content) {
        return content != null && content.length >= 4 && content[0] == 0x25 && content[1] == 0x50 && content[2] == 0x44 && content[3] == 0x46;
    }

    /**
     * 根据wiki中PDF的定义，PDF文件开始的4个字节为%PDF，即：hex 25 50 44 46
     *
     * @param in
     * @return
     * @throws IOException
     */
    public static boolean isPDF(InputStream in) {
        try (InputStream input = in) {
            return isPDF(IOUtils.toByteArray(input, 4));
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 根据文件类型，返回对应的mimeType
     *
     * @param fileType
     * @return
     */
    private static String mimeType(String fileType) {
        switch (trimToEmpty(fileType)) {
            case "tif":
                return "image/tiff";
            case "fax":
                return "image/fax";
            case "gif":
                return "image/gif";
            case "ico":
                return "image/x-icon";
            case "jfif":
            case "jpe":
            case "jpeg":
            case "jpg":
                return "image/jpeg";
            case "net":
                return "image/pnetvue";
            case "png":
                return "image/png";
            default:
                return "application/octet-stream";
        }
    }

    public static String getDownloadMimeType(UploadFileModel fileModel) {
        String fileType = trimToEmpty(fileModel.getFileType()).toLowerCase();
        if (Objects.equals(fileType, "img")) {
            String originalFilename = fileModel.getUpfile().getOriginalFilename();
            String originalFileType = StringUtils.substringAfter(originalFilename, ".");
            return mimeType(originalFileType);
        } else {
            return mimeType(fileType);
        }
    }

    /**
     * MultipartFile 转 File
     *
     * @param file
     * @throws Exception
     */
    public static File multipartFileToFile(MultipartFile file, String fileName) throws Exception {

        File toFile = null;

        InputStream ins = null;
        ins = file.getInputStream();
        toFile = new File("/tmp/" + fileName);
        inputStreamToFile(ins, toFile);
        ins.close();

        return toFile;
    }

    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 强制删除
     *
     * @param file
     * @return
     */
    public static boolean forceDelete(File file) {
        boolean result = false;
        int tryCount = 0;
        while (!result && tryCount++ < 10) {
            System.gc();
            if (file.exists()) {
                result = file.delete();
            }
        }
        return result;
    }
}

