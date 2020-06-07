/**
 * Copyright (C), 2020-2020
 * FileName: MallOrderService
 * Author:   Kingsman
 * Date:     2020/6/8 3:16
 * Description:
 */

package com.mall.mall.service;

import com.mall.mall.api.vo.MallOrderDetailVO;
import com.mall.mall.api.vo.MallShoppingCartItemVO;
import com.mall.mall.entity.MallUser;
import com.mall.mall.entity.MallUserAddress;

import java.util.List;

public interface MallOrderService {

   MallOrderDetailVO getOrderDetailByOrderNo(String orderNo, Long userId);


    PageResult getMyOrders(PageQueryUtil pageUtil);


    String cancelOrder(String orderNo, Long userId);


    String finishOrder(String orderNo, Long userId);

    String paySuccess(String orderNo, int payType);

    String saveOrder(MallUser loginMallUser, MallUserAddress address, List<MallShoppingCartItemVO> itemsForSave);
}


/**
 * 〈一句话功能简述〉<br> 
 * 〈订单功能〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */