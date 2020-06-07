/**
 * Copyright (C), 2020-2020
 * FileName: IndexInfoVO
 * Author:   Kingsman
 * Date:     2020/6/8 1:24
 * Description:
 */

package com.mall.mall.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class IndexInfoVO implements Serializable {

    @ApiModelProperty("轮播图(列表)")
    private List<MallIndexCarouselVO> carousels;

    @ApiModelProperty("首页热销商品(列表)")
    private List<MallIndexConfigGoodsVO> hotGoodses;

    @ApiModelProperty("首页新品推荐(列表)")
    private List<MallIndexConfigGoodsVO> newGoodses;

    @ApiModelProperty("首页推荐商品(列表)")
    private List<MallIndexConfigGoodsVO> recommendGoodses;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */