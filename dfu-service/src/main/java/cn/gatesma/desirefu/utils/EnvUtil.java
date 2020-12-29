package cn.gatesma.desirefu.utils;

/**
 * User: gatesma
 * Date: 2020/12/24 5:26 下午
 * Desc: 环境
 */
public class EnvUtil {

    private static final String ENV_DEV = "dev"; // 开发环境
    private static final String ENV_TEST = "test"; // 测试环境
    private static final String ENV_PREVIEW = "preview"; // 预发布环境
    private static final String ENV_PROD = "prod"; // 线上环境

    /**
     * 历史遗留，用的地方太多了，实际上就是个测试环境，等同于test
     */
    private static final String ENV_DNS = "dns";

    private static final String env = System.getProperty("env", ENV_DEV);

    public static boolean isProdEnv() {
        return ENV_PROD.equalsIgnoreCase(env);
    }

    public static boolean isDevEnv() {
        return ENV_DEV.equalsIgnoreCase(env);
    }

    public static boolean isTestEnv() {
        return ENV_TEST.equalsIgnoreCase(env) || ENV_DNS.equalsIgnoreCase(env);
    }

    public static boolean isPreviewEnv() {
        return ENV_PREVIEW.equalsIgnoreCase(env);
    }


}
