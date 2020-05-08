package com.sly.c2cpay.config;

import com.sly.c2cpay.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**").
                excludePathPatterns("/user/login").excludePathPatterns("/user/register").
                excludePathPatterns("/user/find_one").excludePathPatterns("/user/exists");
    }
}
