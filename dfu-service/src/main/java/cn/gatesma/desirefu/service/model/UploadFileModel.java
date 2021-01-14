package cn.gatesma.desirefu.service.model;

/**
 * User: gatesma
 * Date: 2021/1/13 4:11 下午
 * Desc:
 */
import org.springframework.web.multipart.MultipartFile;

public class UploadFileModel {

    private long accountId;
    private int accountType;
    private long userId;
    private String fileName;
    private String fileType;
    private MultipartFile upfile;
    private byte[] content;

    public long getAccountId() {

        return accountId;
    }

    public void setAccountId(long accountId) {

        this.accountId = accountId;
    }

    public UploadFileModel accountId(long accountId) {
        setAccountId(accountId);
        return this;
    }

    public int getAccountType() {

        return accountType;
    }

    public void setAccountType(int accountType) {

        this.accountType = accountType;
    }

    public UploadFileModel accountType(int accountType) {
        setAccountType(accountType);
        return this;
    }

    public long getUserId() {

        return userId;
    }

    public void setUserId(long userId) {

        this.userId = userId;
    }

    public UploadFileModel userId(long userId) {
        this.setUserId(userId);
        return this;
    }

    public String getFileName() {

        return fileName;
    }

    public void setFileName(String fileName) {

        this.fileName = fileName;
    }

    public UploadFileModel fileName(String fileName) {
        setFileName(fileName);
        return this;
    }

    public String getFileType() {

        return fileType;
    }

    public void setFileType(String fileType) {

        this.fileType = fileType;
    }

    public UploadFileModel fileType(String fileType) {
        setFileType(fileType);
        return this;
    }

    public MultipartFile getUpfile() {

        return upfile;
    }

    public void setUpfile(MultipartFile upfile) {

        this.upfile = upfile;
    }

    public UploadFileModel upfile(MultipartFile upfile) {
        setUpfile(upfile);
        return this;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public UploadFileModel content(byte[] content) {
        setContent(content);
        return this;
    }
}

