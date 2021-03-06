/**
 * Copyright (C), 2020-2020
 * FileName: UpdateMallUserAddressParam
 * Author:   Kingsman
 * Date:     2020/6/8 1:22
 * Description: 修改收货地址
 */

package com.mall.mall.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateMallUserAddressParam {

    @ApiModelProperty("地址id")
    private Long addressId;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("收件人名称")
    private String userName;

    @ApiModelProperty("收件人联系方式")
    private String userPhone;

    @ApiModelProperty("是否默认地址 0-不是 1-是")
    private Byte defaultFlag;

    @ApiModelProperty("省")
    private String provinceName;

    @ApiModelProperty("市")
    private String cityName;

    @ApiModelProperty("区/县")
    private String regionName;

    @ApiModelProperty("详细地址")
    private String detailAddress;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈修改收货地址〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */