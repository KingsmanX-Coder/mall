/**
 * Copyright (C), 2020-2020
 * FileName: SavaOrderParam
 * Author:   Kingsman
 * Date:     2020/6/8 1:20
 * Description: 添加订单
 */

package com.mall.mall.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
class SaveOrderParam implements Serializable {

    @ApiModelProperty("订单项id数组")
    private Long[] cartItemIds;

    @ApiModelProperty("地址id")
    private Long addressId;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈添加订单〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */