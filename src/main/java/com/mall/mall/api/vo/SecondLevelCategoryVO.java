/**
 * Copyright (C), 2020-2020
 * FileName: SecondLevelCategoryVO
 * Author:   Kingsman
 * Date:     2020/6/8 1:39
 * Description: 首页分类数据
 */

package com.mall.mall.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SecondLevelCategoryVO implements Serializable {

    @ApiModelProperty("当前二级分类id")
    private Long categoryId;

    @ApiModelProperty("父级分类id")
    private Long parentId;

    @ApiModelProperty("当前分类级别")
    private Byte categoryLevel;

    @ApiModelProperty("当前二级分类名称")
    private String categoryName;

    @ApiModelProperty("三级分类列表")
    private List<ThirdLevelCategoryVO> thirdLevelCategoryVOS;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈首页分类数据〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */