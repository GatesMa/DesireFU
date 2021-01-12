package cn.gatesma.desirefu.domain.config;

/**
 * User: gatesma
 * Date: 2021/1/12 6:36 下午
 * Desc:
 */
public class CosProperties {

    private String secretId;
    private String secretKey;
    private String region;
    private String bucketName;

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
