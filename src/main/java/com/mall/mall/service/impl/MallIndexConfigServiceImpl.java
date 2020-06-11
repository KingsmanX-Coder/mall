/**
 * Copyright (C), 2020-2020
 * FileName: MallIndexConfigServiceImpl
 * Author:   Kingsman
 * Date:     2020/6/8 3:38
 * Description:
 */

package com.mall.mall.service.impl;

import com.mall.mall.api.vo.MallIndexConfigGoodsVO;
import com.mall.mall.dao.IndexConfigMapper;
import com.mall.mall.dao.MallGoodsMapper;
import com.mall.mall.entity.IndexConfig;
import com.mall.mall.entity.MallGoods;
import com.mall.mall.service.MallIndexConfigService;
import com.mall.mall.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MallIndexConfigServiceImpl implements MallIndexConfigService {

    @Autowired
    private IndexConfigMapper indexConfigMapper;

    @Autowired
    private MallGoodsMapper goodsMapper;

    @Override
    public List<MallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number) {
        List<MallIndexConfigGoodsVO> MallIndexConfigGoodsVOS = new ArrayList<>(number);
        List<IndexConfig> indexConfigs = indexConfigMapper.findIndexConfigsByTypeAndNum(configType, number);
        if (!CollectionUtils.isEmpty(indexConfigs)) {
            //取出所有的goodsId
            List<Long> goodsIds = indexConfigs.stream().map(IndexConfig::getGoodsId).collect(Collectors.toList());
            List<MallGoods> MallGoods = goodsMapper.selectByPrimaryKeys(goodsIds);
            MallIndexConfigGoodsVOS = BeanUtil.copyList(MallGoods, MallIndexConfigGoodsVO.class);
            for (MallIndexConfigGoodsVO MallIndexConfigGoodsVO : MallIndexConfigGoodsVOS) {
                String goodsName = MallIndexConfigGoodsVO.getGoodsName();
                String goodsIntro = MallIndexConfigGoodsVO.getGoodsIntro();
                // 字符串过长导致文字超出的问题
                if (goodsName.length() > 30) {
                    goodsName = goodsName.substring(0, 30) + "...";
                    MallIndexConfigGoodsVO.setGoodsName(goodsName);
                }
                if (goodsIntro.length() > 22) {
                    goodsIntro = goodsIntro.substring(0, 22) + "...";
                    MallIndexConfigGoodsVO.setGoodsIntro(goodsIntro);
                }
            }
        }
        return MallIndexConfigGoodsVOS;
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