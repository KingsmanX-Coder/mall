/**
 * Copyright (C), 2020-2020
 * FileName: MallIndexConfigService
 * Author:   Kingsman
 * Date:     2020/6/8 3:11
 * Description:
 */

package com.mall.mall.service;

import com.mall.mall.api.vo.MallIndexConfigGoodsVO;

import java.util.List;

public interface MallIndexConfigService {


    List<MallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number);
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈返回固定数量的首页配置商品对象〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */