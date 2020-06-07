/**
 * Copyright (C), 2020-2020
 * FileName: MallUserVO
 * Author:   Kingsman
 * Date:     2020/6/8 1:36
 * Description: 用户
 */

package com.mall.mall.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MallUserVO implements Serializable {

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户登录名")
    private String loginName;

    @ApiModelProperty("个性签名")
    private String introduceSign;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */