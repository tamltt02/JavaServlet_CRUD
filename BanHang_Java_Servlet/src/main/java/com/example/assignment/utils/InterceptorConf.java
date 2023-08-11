package com.example.assignment.utils;

import com.example.assignment.Interceptor.Authen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConf implements WebMvcConfigurer {

    @Autowired
    private Authen authen;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authen).addPathPatterns("/admin/**","/doimk","/quenmk","/giohang/**","/thanhtoan")
                .excludePathPatterns("/dangki","/dangnhap","/trangchu","sanpham/**");
    }
}
