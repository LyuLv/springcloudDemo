package com.lyu.springbootjwt.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Lyu
 * @Description: 注册自定义拦截器
 * @Date: Created in 9:59 2020/11/6
 * @Modified By:
 */
@Configuration
public class JwtInterceptorRegister implements WebMvcConfigurer {
    /**
     * 注册jwt拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getJwtInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public JwtInterceptor getJwtInterceptor() {
        return new JwtInterceptor();
    }
}
