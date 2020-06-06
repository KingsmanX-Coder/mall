/**
 * Copyright (C), 2020-2020
 * FileName: ThymeleafController
 * Author:   Kingsman
 * Date:     2020/6/6 15:28
 * Description: 将模板文件所需的 description 字段赋值并转发至模板文件
 */

package com.mall.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
    public String hello(HttpServletRequest request, @RequestParam(value = "description",required = false,defaultValue = "springboot-thymeleaf")String description){
        request.setAttribute("description",description);
        return "thymeleaf";
    }
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈将模板文件所需的 description 字段赋值并转发至模板文件〉
 *
 * @author Kingsman
 * @create 2020/6/6
 * @since 1.0.0
 */