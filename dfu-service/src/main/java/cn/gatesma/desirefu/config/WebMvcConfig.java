package cn.gatesma.desirefu.config;

import cn.gatesma.desirefu.config.interceptor.InfoInjectInterceptor;
import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author gatesma
 * @date 2020/11/7
 * @desc
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Resource
    private InfoInjectInterceptor infoInjectInterceptor;

    /**
     * 配置监听器
     * 过滤掉swagger相关请求
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 信息注入拦截器
        registry.addInterceptor(infoInjectInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/v2/api-docs",
                        "/configuration/**",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**");
    }

}
