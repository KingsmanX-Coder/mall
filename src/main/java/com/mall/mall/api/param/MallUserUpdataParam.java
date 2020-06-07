/**
 * Copyright (C), 2020-2020
 * FileName: MallUserUpdataParam
 * Author:   Kingsman
 * Date:     2020/6/8 1:16
 * Description:
 */

package com.mall.mall.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
class MallUserUpdateParam implements Serializable {

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户密码(需要MD5加密)")
    private String passwordMd5;

    @ApiModelProperty("个性签名")
    private String introduceSign;

}


/**
 * 〈一句话功能简述〉<br> 
 * 〈用户修改〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */