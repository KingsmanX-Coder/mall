/**
 * Copyright (C), 2020-2020
 * FileName: MallShoppingCartItem
 * Author:   Kingsman
 * Date:     2020/6/8 3:00
 * Description:
 */

package com.mall.mall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MallShoppingCartItem {
    private Long cartItemId;

    private Long userId;

    private Long goodsId;

    private Integer goodsCount;

    private Byte isDeleted;

    private Date createTime;

    private Date updateTime;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */