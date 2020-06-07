/**
 * Copyright (C), 2020-2020
 * FileName: MallWebMvcConfigurer
 * Author:   Kingsman
 * Date:     2020/6/8 2:27
 * Description:
 */

package com.mall.mall.config;

import com.mall.mall.common.Constants;
import com.mall.mall.config.handler.TokenToMallUserMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MallWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private TokenToMallUserMethodArgumentResolver tokenToMallUserMethodArgumentResolver;

    /**
     * TokenToMallUser 注解处理方法
     *
     * @param argumentResolvers
     */
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(tokenToMallUserMethodArgumentResolver);
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
        registry.addResourceHandler("/goods-img/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true).maxAge(3600);
    }
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈跨域配置〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */