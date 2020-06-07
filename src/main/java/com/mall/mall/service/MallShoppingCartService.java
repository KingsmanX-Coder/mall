/**
 * Copyright (C), 2020-2020
 * FileName: MallShoppingCartService
 * Author:   Kingsman
 * Date:     2020/6/8 3:17
 * Description:
 */

package com.mall.mall.service;

import com.mall.mall.api.param.SaveCartItemParam;
import com.mall.mall.api.param.UpdateCartItemParam;
import com.mall.mall.api.vo.MallShoppingCartItemVO;
import com.mall.mall.entity.MallShoppingCartItem;

import java.util.List;

public interface MallShoppingCartService {

    /**
     * 保存商品至购物车中
     *
     * @param saveCartItemParam
     * @param userId
     * @return
     */
    String saveMallCartItem(SaveCartItemParam saveCartItemParam, Long userId);

    /**
     * 修改购物车中的属性
     *
     * @param updateCartItemParam
     * @param userId
     * @return
     */
    String updateMallCartItem(UpdateCartItemParam updateCartItemParam, Long userId);

    /**
     * 获取购物项详情
     *
     * @param MallShoppingCartItemId
     * @return
     */
    MallShoppingCartItem getMallCartItemById(Long MallShoppingCartItemId);

    /**
     * 删除购物车中的商品
     * @paramMallShoppingCartItemId
     * @return
     */
    Boolean deleteById(Long MallShoppingCartItemId);

    /**
     * 获取我的购物车中的列表数据
     * @param MallUserId
     * @return
     */
    List<MallShoppingCartItemVO> getMyShoppingCartItems(Long MallUserId);

    /**
     * 根据userId和cartItemIds获取对应的购物项记录
     * @param cartItemIds
     * @param MallUserId
     * @return
     */
    List<MallShoppingCartItemVO> getCartItemsForSettle(List<Long> cartItemIds, Long MallUserId);

    /**
     * 我的购物车(分页数据)
     * @param pageUtil
     * @return
     */
    PageResult getMyShoppingCartItems(PageQueryUtil pageUtil);
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */