/**
 * Copyright (C), 2020-2020
 * FileName: MallOrderItem
 * Author:   Kingsman
 * Date:     2020/6/8 2:59
 * Description:
 */

package com.mall.mall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MallOrderItem {
    private Long orderItemId;

    private Long orderId;

    private Long goodsId;

    private String goodsName;

    private String goodsCoverImg;

    private Integer sellingPrice;

    private Integer goodsCount;

    private Date createTime;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */