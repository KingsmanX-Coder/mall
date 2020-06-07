/**
 * Copyright (C), 2020-2020
 * FileName: TokenToMallUser
 * Author:   Kingsman
 * Date:     2020/6/8 2:22
 * Description:
 */

package com.mall.mall.config.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenToMallUser {

    String value() default "user";

}


/**
 * 〈一句话功能简述〉<br> 
 * 〈当前用户在request中的名字〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */