/**
 * Copyright (C), 2020-2020
 * FileName: Controller
 * Author:   Kingsman
 * Date:     2020/6/6 14:55
 * Description: 启动器
 */

package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class Controller {
    @GetMapping("/info")
    @ResponseBody
    public String getInfoFromIdea(){
        return "this is a spring boot project from idea for test";
    }
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈启动器〉
 *
 * @author Kingsman
 * @create 2020/6/6
 * @since 1.0.0
 */