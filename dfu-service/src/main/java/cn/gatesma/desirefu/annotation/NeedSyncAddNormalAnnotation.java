package cn.gatesma.desirefu.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeedSyncAddNormalAnnotation {
    String msg() default "";
}
