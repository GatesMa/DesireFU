package cn.gatesma.desirefu.config.api.generate;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("DFU_API_DOC")
                .description("DesireFU后端接口文档。")
                .license("")
                .licenseUrl("http://unlicense.org")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("", "", ""))
                .build();
    }

    @Bean
    public Docket customImplementation() {
        Tag[] tags = getTagsSorted();
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.gatesma.desirefu.controller.api.generate"))
                .paths(PathSelectors.any())
                .build()
                .tags(tags[0], ArrayUtils.subarray(tags,1,tags.length))
                .apiInfo(apiInfo());
    }

    private Tag[] getTagsSorted() {
        return new Tag[]{
                new Tag("测试","测试",100),
                new Tag("用户","用户",200),
        };
    }


}
