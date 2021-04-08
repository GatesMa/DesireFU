package cn.gatesma.desirefu.annotation;

import java.lang.annotation.*;


/**
 * 注意: 此切面使用统一在RateLimitMethodService，需要传参(String client, int rate)
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DistributedRateLimit {
    /**
     * 限流唯一标示
     *
     * @return
     */
    String keyOfConfigCenter() default "";

    /**
     * 限流单位时间
     *
     * @return
     */
    int unitSeconds();

    /**
     * 单位时间内限流次数
     *
     * @return
     */
    int defaulCount();

    /**
     * 暴露给调用方的错误信息描述
     *
     * @return
     */
    String noticeMsg() default "该接口被限流，请稍后重试";
}
