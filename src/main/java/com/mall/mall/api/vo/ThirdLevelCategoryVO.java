/**
 * Copyright (C), 2020-2020
 * FileName: ThirdLevelCategoryVO
 * Author:   Kingsman
 * Date:     2020/6/8 1:40
 * Description: 首页分类数据
 */

package com.mall.mall.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ThirdLevelCategoryVO implements Serializable {

    @ApiModelProperty("当前三级分类id")
    private Long categoryId;

    @ApiModelProperty("当前分类级别")
    private Byte categoryLevel;

    @ApiModelProperty("当前三级分类名称")
    private String categoryName;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈首页分类数据〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */