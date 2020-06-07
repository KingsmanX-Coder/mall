/**
 * Copyright (C), 2020-2020
 * FileName: MallShoppingCartItemVO
 * Author:   Kingsman
 * Date:     2020/6/8 1:34
 * Description: 购物车页面属性项
 */

package com.mall.mall.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MallShoppingCartItemVO implements Serializable {

    @ApiModelProperty("购物项id")
    private Long cartItemId;

    @ApiModelProperty("商品id")
    private Long goodsId;

    @ApiModelProperty("商品数量")
    private Integer goodsCount;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品图片")
    private String goodsCoverImg;

    @ApiModelProperty("商品价格")
    private Integer sellingPrice;
}


/**
 * 〈一句话功能简述〉<br> 
 * 〈购物车页面属性项〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */