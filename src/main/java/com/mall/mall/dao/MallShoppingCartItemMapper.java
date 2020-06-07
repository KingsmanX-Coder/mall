/**
 * Copyright (C), 2020-2020
 * FileName: MallShoppingCartItemMapper
 * Author:   Kingsman
 * Date:     2020/6/8 2:47
 * Description:
 */

package com.mall.mall.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallShoppingCartItemMapper {
    int deleteByPrimaryKey(Long cartItemId);

    int insert(MallShoppingCartItem record);

    int insertSelective(MallShoppingCartItem record);

    MallShoppingCartItem selectByPrimaryKey(Long cartItemId);

    MallShoppingCartItem selectByUserIdAndGoodsId(@Param("MallUserId") Long MallUserId, @Param("goodsId") Long goodsId);

    List<MallShoppingCartItem> selectByUserId(@Param("MallUserId") Long MallUserId, @Param("number") int number);

    List<MallShoppingCartItem> selectByUserIdAndCartItemIds(@Param("MallUserId") Long MallUserId, @Param("cartItemIds") List<Long> cartItemIds);

    int selectCountByUserId(Long MallUserId);

    int updateByPrimaryKeySelective(MallShoppingCartItem record);

    int updateByPrimaryKey(MallShoppingCartItem record);

    int deleteBatch(List<Long> ids);

    List<MallShoppingCartItem> findMyMallCartItems(PageQueryUtil pageUtil);

    int getTotalMyMallCartItems(PageQueryUtil pageUtil);
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */