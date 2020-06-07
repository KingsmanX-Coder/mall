/**
 * Copyright (C), 2020-2020
 * FileName: MallOrderAddress
 * Author:   Kingsman
 * Date:     2020/6/8 2:57
 * Description:
 */

package com.mall.mall.entity;

import lombok.Data;

@Data
public class MallOrderAddress {
    private Long orderId;

    private String userName;

    private String userPhone;

    private String provinceName;

    private String cityName;

    private String regionName;

    private String detailAddress;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */