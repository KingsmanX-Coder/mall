/**
 * Copyright (C), 2020-2020
 * FileName: MallCarouselService
 * Author:   Kingsman
 * Date:     2020/6/8 3:04
 * Description:
 */

package com.mall.mall.service;

import com.mall.mall.api.vo.MallIndexCarouselVO;

import java.util.List;

public interface MallCarouselService {


    List<MallIndexCarouselVO> getCarouselsForIndex(int number);
}


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */