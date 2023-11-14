package com.jake.webstore.cloud.base.config;


import com.jake.webstore.cloud.base.interceptor.SubjectInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SubjectInterceptor())
                .excludePathPatterns("/sso/**", "auth/**")
                .pathMatcher(new AntPathMatcher());
    }
}
