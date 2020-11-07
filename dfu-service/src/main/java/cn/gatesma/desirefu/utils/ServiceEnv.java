package cn.gatesma.desirefu.utils;

import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author gatesma
 * @date 2020/11/7
 * @desc 返回当前环境信息
 */
@Component
public class ServiceEnv {

    private static final String DEV="dev";
    private static final String DNS="dns";
    private static final String SST="sst";
    private static final String SANDBOX="sandbox";
    private static final String PREVIEW="preview";
    private static final String PROD="prod";
    private static final String UT="ut";

    private String[] activeProfiles;

    @Resource
    private Environment env;

    @PostConstruct
    public void init(){
        String profiles= Arrays.toString(env.getActiveProfiles()).toLowerCase();
        if(profiles.length()>2) {
            activeProfiles=profiles.substring(1,profiles.length()-1).split(",");
        }else {
            activeProfiles=new String[0];
        }

    }

    public boolean isDev() {
        return ArrayUtils.contains(activeProfiles, DEV);
    }

    public boolean isDns() {
        return ArrayUtils.contains(activeProfiles, DNS);
    }

    public boolean isSst() {
        return ArrayUtils.contains(activeProfiles, SST);
    }

    public boolean isUt(){
        return ArrayUtils.contains(activeProfiles,UT);
    }

    public boolean isSandBox() {
        return ArrayUtils.contains(activeProfiles, SANDBOX);
    }

    public boolean isPreview() {
        return ArrayUtils.contains(activeProfiles, PREVIEW);
    }

    public boolean isProd() {
        return ArrayUtils.contains(activeProfiles, PROD);
    }

}
