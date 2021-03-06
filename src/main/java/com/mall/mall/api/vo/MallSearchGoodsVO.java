/**
 * Copyright (C), 2020-2020
 * FileName: MallSearchGoodsVO
 * Author:   Kingsman
 * Date:     2020/6/8 1:33
 * Description: 搜索列表商品
 */

package com.mall.mall.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MallSearchGoodsVO implements Serializable {

    @ApiModelProperty("商品id")
    private Long goodsId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品简介")
    private String goodsIntro;

    @ApiModelProperty("商品图片地址")
    private String goodsCoverImg;

    @ApiModelProperty("商品价格")
    private Integer sellingPrice;

}

/**
 * 〈一句话功能简述〉<br> 
 * 〈搜索列表商品〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */