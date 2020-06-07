/**
 * Copyright (C), 2020-2020
 * FileName: MallIndexConfigGoodsVO
 * Author:   Kingsman
 * Date:     2020/6/8 1:28
 * Description: 首页配置商品
 */

package com.mall.mall.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MallIndexConfigGoodsVO implements Serializable {

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
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈首页配置商品〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */