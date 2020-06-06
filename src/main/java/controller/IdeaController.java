/**
 * Copyright (C), 2020-2020
 * FileName: IdeaController
 * Author:   Kingsman
 * Date:     2020/6/6 15:02
 * Description: test
 */

package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class IdeaController {
    @GetMapping("/info")
    @ResponseBody
    public String getInfoFromIdea(){
        return "this is a spring boot project test";
    }
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈test〉
 *
 * @author Kingsman
 * @create 2020/6/6
 * @since 1.0.0
 */