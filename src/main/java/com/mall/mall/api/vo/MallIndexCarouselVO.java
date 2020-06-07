/**
 * Copyright (C), 2020-2020
 * FileName: MallIndexCarouselVO
 * Author:   Kingsman
 * Date:     2020/6/8 1:45
 * Description: 首页轮播图
 */

package com.mall.mall.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MallIndexCarouselVO implements Serializable {

    @ApiModelProperty("轮播图图片地址")
    private String carouselUrl;

    @ApiModelProperty("轮播图点击后的跳转路径")
    private String redirectUrl;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈首页轮播图〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */