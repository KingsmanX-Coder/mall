/**
 * Copyright (C), 2020-2020
 * FileName: MallUserLoginParam
 * Author:   Kingsman
 * Date:     2020/6/8 1:08
 * Description: 用户登录
 */

package com.mall.mall.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class MallUserLoginParam implements Serializable {

    @ApiModelProperty("登录名")
    @NotEmpty(message = "登录名不能为空")
    private String loginName;

    @ApiModelProperty("用户密码")
    @NotEmpty(message = "密码不能为空")
    private String passwordMd5;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户登录〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */