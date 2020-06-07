/**
 * Copyright (C), 2020-2020
 * FileName: MallUserAddress
 * Author:   Kingsman
 * Date:     2020/6/8 2:54
 * Description:
 */

package com.mall.mall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MallUserAddress {
    private Long addressId;

    private Long userId;

    private String userName;

    private String userPhone;

    private Byte defaultFlag;

    private String provinceName;

    private String cityName;

    private String regionName;

    private String detailAddress;

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