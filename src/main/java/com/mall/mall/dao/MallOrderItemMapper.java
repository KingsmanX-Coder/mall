/**
 * Copyright (C), 2020-2020
 * FileName: MallOrderItemMapper
 * Author:   Kingsman
 * Date:     2020/6/8 2:44
 * Description:
 */

package com.mall.mall.dao;

import com.mall.mall.entity.MallOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallOrderItemMapper {
    int deleteByPrimaryKey(Long orderItemId);

    int insert(MallOrderItem record);

    int insertSelective(MallOrderItem record);

    MallOrderItem selectByPrimaryKey(Long orderItemId);

    /**
     * 根据订单id获取订单项列表
     *
     * @param orderId
     * @return
     */
    List<MallOrderItem> selectByOrderId(Long orderId);

    /**
     * 根据订单ids获取订单项列表
     *
     * @param orderIds
     * @return
     */
    List<MallOrderItem> selectByOrderIds(@Param("orderIds") List<Long> orderIds);

    /**
     * 批量insert订单项数据
     *
     * @param orderItems
     * @return
     */
    int insertBatch(@Param("orderItems") List<MallOrderItem> orderItems);

    int updateByPrimaryKeySelective(MallOrderItem record);

    int updateByPrimaryKey(MallOrderItem record);
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */