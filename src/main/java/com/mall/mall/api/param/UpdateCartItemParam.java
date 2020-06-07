/**
 * Copyright (C), 2020-2020
 * FileName: UpdateCartItemParam
 * Author:   Kingsman
 * Date:     2020/6/8 1:21
 * Description: 修改购物车
 */

package com.mall.mall.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateCartItemParam implements Serializable {

    @ApiModelProperty("购物项id")
    private Long cartItemId;

    @ApiModelProperty("商品数量")
    private Integer goodsCount;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈修改购物车〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */