/**
 * Copyright (C), 2020-2020
 * FileName: CarouselMapper
 * Author:   Kingsman
 * Date:     2020/6/8 2:36
 * Description:
 */

package com.mall.mall.dao;

import com.mall.mall.entity.Carousel;
import com.mall.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CarouselMapper {
    int deleteByPrimaryKey(Integer carouselId);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    Carousel selectByPrimaryKey(Integer carouselId);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);

    List<Carousel> findCarouselList(PageQueryUtil pageUtil);

    int getTotalCarousels(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);

    List<Carousel> findCarouselsByNum(@Param("number") int number);
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Kingsman
 * @create 2020/6/8
 * @since 1.0.0
 */