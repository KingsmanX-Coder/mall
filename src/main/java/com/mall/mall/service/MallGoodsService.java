/**
 * Copyright (C), 2020-2020
 * FileName: MallGoodsService
 * Author:   Kingsman
 * Date:     2020/6/8 3:10
 * Description:
 */

package com.mall.mall.service;

import com.mall.mall.entity.MallGoods;

public interface MallGoodsService {


    MallGoods getMallGoodsById(Long id);


    PageResult searchMallGoods(PageQueryUtil pageUtil);
}


/**
 * 〈获取商品详情及搜索〉<br>
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */