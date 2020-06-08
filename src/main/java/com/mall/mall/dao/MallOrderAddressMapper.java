/**
 * Copyright (C), 2020-2020
 * FileName: MallOrderAddressMapper
 * Author:   Kingsman
 * Date:     2020/6/8 2:43
 * Description:
 */

package com.mall.mall.dao;

import com.mall.mall.entity.MallOrderAddress;

public interface MallOrderAddressMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(MallOrderAddress record);

    int insertSelective(MallOrderAddress record);

   MallOrderAddress selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(MallOrderAddress record);

    int updateByPrimaryKey(MallOrderAddress record);
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */