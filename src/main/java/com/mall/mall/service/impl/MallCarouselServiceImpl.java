/**
 * Copyright (C), 2020-2020
 * FileName: MallCarouselServiceImpl
 * Author:   Kingsman
 * Date:     2020/6/8 3:30
 * Description:
 */

package com.mall.mall.service.impl;

import com.mall.mall.api.vo.MallIndexCarouselVO;
import com.mall.mall.dao.CarouselMapper;
import com.mall.mall.entity.Carousel;
import com.mall.mall.service.MallCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class MallCarouselServiceImpl implements MallCarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<MallIndexCarouselVO> getCarouselsForIndex(int number) {
        List<MallIndexCarouselVO> MallIndexCarouselVOS = new ArrayList<>(number);
        List<Carousel> carousels = carouselMapper.findCarouselsByNum(number);
        if (!CollectionUtils.isEmpty(carousels)) {
            MallIndexCarouselVOS = BeanUtil.copyList(carousels, MallIndexCarouselVO.class);
        }
        return MallIndexCarouselVOS;
    }
}


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */