/**
 * Copyright (C), 2020-2020
 * FileName: MallCategoryService
 * Author:   Kingsman
 * Date:     2020/6/8 3:05
 * Description:
 */

package com.mall.mall.service;

import com.mall.mall.api.vo.MallIndexCategoryVO;
import com.mall.mall.entity.GoodsCategory;

import java.util.List;

public interface MallCategoryService {

    String saveCategory(GoodsCategory goodsCategory);

    String updateGoodsCategory(GoodsCategory goodsCategory);

    GoodsCategory getGoodsCategoryById(Long id);

    Boolean deleteBatch(Integer[] ids);

    /**
     * 返回分类数据(首页调用)
     *
     * @return
     */
    List<MallIndexCategoryVO> getCategoriesForIndex();
}