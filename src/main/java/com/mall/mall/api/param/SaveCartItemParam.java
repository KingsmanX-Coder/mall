/**
 * Copyright (C), 2020-2020
 * FileName: SavaCartItemParam
 * Author:   Kingsman
 * Date:     2020/6/8 1:17
 * Description: 添加购物车
 */

package com.mall.mall.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SaveCartItemParam implements Serializable {

    @ApiModelProperty("商品数量")
    private Integer goodsCount;

    @ApiModelProperty("商品id")
    private Long goodsId;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈添加购物车〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */