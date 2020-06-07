package com.mall.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@MapperScan("com.com.mall.dao")
@SpringBootApplication
public class MallAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAPIApplication.class, args);
    }

}