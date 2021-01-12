package cn.gatesma.desirefu.config.cos;

import cn.gatesma.desirefu.domain.config.CosProperties;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.File;

/**
 * User: gatesma
 * Date: 2021/1/12 2:40 下午
 * Desc: 腾讯对象存储服务
 */
@Configuration
public class COSConfig {

    // COS配置信息
    @Bean
    @Scope(scopeName = "singleton")
    @ConfigurationProperties(prefix = "tencent.cos")
    public CosProperties cosProperties() {
        return new CosProperties();
    }


    // COS 客户端
    @Bean
    public COSClient cosClient() {
        CosProperties cosProperties = cosProperties();
        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = cosProperties.getSecretId();
        String secretKey = cosProperties.getSecretKey();
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region(cosProperties.getRegion());
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        return new COSClient(cred, clientConfig);
    }


    public static void main(String[] args) {
        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDrUrfMuHFF1YsvmB4MN5dqmRs2TKSmIPS";
        String secretKey = "C8GUYFhsmQowpaXK2GFyQeuDGCsISLz7";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-chengdu");
        ClientConfig clientConfig = new ClientConfig(region);
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 指定要上传的文件
        File localFile = new File("/Users/gatesma/Pictures/LBJ/1280x720-387102-lebron-james-images-background.jpg");
        // 指定要上传到的存储桶
        String bucketName = "img-dfu-1257282228";
        // 指定要上传到 COS 上对象键
        String key = "tmp/lbj-bg.jpg";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println(putObjectResult);
    }

}
