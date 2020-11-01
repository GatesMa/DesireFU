package cn.gatesma.desirefu;

/**
 * @author gatesma
 * @date 2020/11/1
 * @desc
 */

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableScheduling
@EnableCaching
@EnableAsync
@ComponentScan(basePackages = { "cn.gatesma.desirefu","cn.gatesma.desirefu.controller.api", "cn.gatesma.desirefu.controller.api.generate" })
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .profiles(System.getProperty("env", "dev"))
                .run(args);
    }

}