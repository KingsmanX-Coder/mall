/**
 * Copyright (C), 2020-2020
 * FileName: MallGoodsDetailVO
 * Author:   Kingsman
 * Date:     2020/6/8 1:25
 * Description:
 */

package com.mall.mall.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
class MallGoodsDetailVO implements Serializable {

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

    @ApiModelProperty("商品标签")
    private String tag;

    @ApiModelProperty("商品图片")
    private String[] goodsCarouselList;

    @ApiModelProperty("商品原价")
    private Integer originalPrice;

    @ApiModelProperty("商品详情字段")
    private String goodsDetailContent;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈商品详情页〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */