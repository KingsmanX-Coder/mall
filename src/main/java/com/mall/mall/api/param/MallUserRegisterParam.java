/**
 * Copyright (C), 2020-2020
 * FileName: MallUserRegisterParam
 * Author:   Kingsman
 * Date:     2020/6/8 1:13
 * Description: 用户注册
 */

package com.mall.mall.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class MallUserRegisterParam implements Serializable {

    @ApiModelProperty("登录名")
    @NotEmpty(message = "登录名不能为空")
    private String loginName;

    @ApiModelProperty("用户密码")
    @NotEmpty(message = "密码不能为空")
    private String password;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户注册〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */