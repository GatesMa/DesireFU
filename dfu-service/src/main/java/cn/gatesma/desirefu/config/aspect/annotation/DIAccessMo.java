
package cn.gatesma.desirefu.config.aspect.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface DIAccessMo {
  String table() default "";
  String db() default "";
  String crud() default "";
}

