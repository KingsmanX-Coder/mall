/**
 * Copyright (C), 2020-2020
 * FileName: MallUserToken
 * Author:   Kingsman
 * Date:     2020/6/8 2:55
 * Description:
 */

package com.mall.mall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MallUserToken {
    private Long userId;

    private String token;

    private Date updateTime;

    private Date expireTime;
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */