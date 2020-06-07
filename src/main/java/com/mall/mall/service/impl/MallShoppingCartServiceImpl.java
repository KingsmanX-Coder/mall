/**
 * Copyright (C), 2020-2020
 * FileName: MallShoppingCartServiceImpl
 * Author:   Kingsman
 * Date:     2020/6/8 4:03
 * Description:
 */

package com.mall.mall.service.impl;

import com.mall.mall.api.param.SaveCartItemParam;
import com.mall.mall.api.param.UpdateCartItemParam;
import com.mall.mall.api.vo.MallShoppingCartItemVO;
import com.mall.mall.common.Constants;
import com.mall.mall.common.MallException;
import com.mall.mall.common.ServiceResultEnum;
import com.mall.mall.dao.MallGoodsMapper;
import com.mall.mall.dao.MallShoppingCartItemMapper;
import com.mall.mall.entity.MallGoods;
import com.mall.mall.entity.MallShoppingCartItem;
import com.mall.mall.service.MallShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MallShoppingCartServiceImpl implements MallShoppingCartService {

    @Autowired
    private MallShoppingCartItemMapper MallShoppingCartItemMapper;

    @Autowired
    private MallGoodsMapper MallGoodsMapper;

    @Override
    public String saveMallCartItem(SaveCartItemParam saveCartItemParam, Long userId) {
        MallShoppingCartItem temp = MallShoppingCartItemMapper.selectByUserIdAndGoodsId(userId, saveCartItemParam.getGoodsId());
        if (temp != null) {
            //已存在则修改该记录
            MallException.fail(ServiceResultEnum.SHOPPING_CART_ITEM_EXIST_ERROR.getResult());
        }
        MallGoods newBeeMallGoods = MallGoodsMapper.selectByPrimaryKey(saveCartItemParam.getGoodsId());
        //商品为空
        if (newBeeMallGoods == null) {
            return ServiceResultEnum.GOODS_NOT_EXIST.getResult();
        }
        int totalItem = MallShoppingCartItemMapper.selectCountByUserId(userId);
        //超出单个商品的最大数量
        if (saveCartItemParam.getGoodsCount() < 1) {
            return ServiceResultEnum.SHOPPING_CART_ITEM_NUMBER_ERROR.getResult();
        }        //超出单个商品的最大数量
        if (saveCartItemParam.getGoodsCount() > Constants.SHOPPING_CART_ITEM_LIMIT_NUMBER) {
            return ServiceResultEnum.SHOPPING_CART_ITEM_LIMIT_NUMBER_ERROR.getResult();
        }
        //超出最大数量
        if (totalItem > Constants.SHOPPING_CART_ITEM_TOTAL_NUMBER) {
            return ServiceResultEnum.SHOPPING_CART_ITEM_TOTAL_NUMBER_ERROR.getResult();
        }
        MallShoppingCartItem MallShoppingCartItem = new MallShoppingCartItem();
        BeanUtil.copyProperties(saveCartItemParam, MallShoppingCartItem);
        MallShoppingCartItem.setUserId(userId);
        //保存记录
        if (MallShoppingCartItemMapper.insertSelective(MallShoppingCartItem) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateNewBeeMallCartItem(UpdateCartItemParam updateCartItemParam, Long userId) {
        MallShoppingCartItem MallShoppingCartItemUpdate = MallShoppingCartItemMapper.selectByPrimaryKey(updateCartItemParam.getCartItemId());
        if (MallShoppingCartItemUpdate == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (!MallShoppingCartItemUpdate.getUserId().equals(userId)) {
            MallException.fail(ServiceResultEnum.REQUEST_FORBIDEN_ERROR.getResult());
        }
        //超出单个商品的最大数量
        if (updateCartItemParam.getGoodsCount() > Constants.SHOPPING_CART_ITEM_LIMIT_NUMBER) {
            return ServiceResultEnum.SHOPPING_CART_ITEM_LIMIT_NUMBER_ERROR.getResult();
        }
        MallShoppingCartItemUpdate.setGoodsCount(updateCartItemParam.getGoodsCount());
        MallShoppingCartItemUpdate.setUpdateTime(new Date());
        //修改记录
        if (MallShoppingCartItemMapper.updateByPrimaryKeySelective(MallShoppingCartItemUpdate) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public MallShoppingCartItem getMallCartItemById(Long MallShoppingCartItemId) {
        MallShoppingCartItem MallShoppingCartItem = MallShoppingCartItemMapper.selectByPrimaryKeyMallShoppingCartItemId);
        if (MallShoppingCartItem == null) {
            MallException.fail(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        return MallShoppingCartItem;
    }

    @Override
    public Boolean deleteById(Long newBeeMallShoppingCartItemId) {
        return MallShoppingCartItemMapper.deleteByPrimaryKey(newBeeMallShoppingCartItemId) > 0;
    }

    @Override
    public List<MallShoppingCartItemVO> getMyShoppingCartItems(Long MallUserId) {
        List<MallShoppingCartItemVO> MallShoppingCartItemVOS = new ArrayList<>();
        List<MallShoppingCartItem> MallShoppingCartItems = MallShoppingCartItemMapper.selectByUserId(MallUserId, Constants.SHOPPING_CART_ITEM_TOTAL_NUMBER);
        return getMallShoppingCartItemVOS(MallShoppingCartItemVOS, MallShoppingCartItems);
    }

    @Override
    public List<MallShoppingCartItemVO> getCartItemsForSettle(List<Long> cartItemIds, Long newBeeMallUserId) {
        List<MallShoppingCartItemVO> MallShoppingCartItemVOS = new ArrayList<>();
        if (CollectionUtils.isEmpty(cartItemIds)) {
            MallException.fail("购物项不能为空");
        }
        List<MallShoppingCartItem> MallShoppingCartItems = MallShoppingCartItemMapper.selectByUserIdAndCartItemIds(MallUserId, cartItemIds);
        if (CollectionUtils.isEmpty(MallShoppingCartItems)) {
            MallException.fail("购物项不能为空");
        }
        if (MallShoppingCartItems.size() != cartItemIds.size()) {
            MallException.fail("参数异常");
        }
        return getMallShoppingCartItemVOS(MallShoppingCartItemVOS, MallShoppingCartItems);
    }

    /**
     * 数据转换
     *
     * @param MallShoppingCartItemVOS
     * @param MallShoppingCartItems
     * @return
     */
    private List<MallShoppingCartItemVO> getMallShoppingCartItemVOS(List<MallShoppingCartItemVO> MallShoppingCartItemVOS, List<MallShoppingCartItem> MallShoppingCartItems) {
        if (!CollectionUtils.isEmpty(MallShoppingCartItems)) {
            //查询商品信息并做数据转换
            List<Long> MallGoodsIds = MallShoppingCartItems.stream().map(MallShoppingCartItem::getGoodsId).collect(Collectors.toList());
            List<MallGoods> MallGoods = MallGoodsMapper.selectByPrimaryKeys(MallGoodsIds);
            Map<Long, MallGoods> MallGoodsMap = new HashMap<>();
            if (!CollectionUtils.isEmpty(MallGoods)) {
                MallGoodsMap = MallGoods.stream().collect(Collectors.toMap(MallGoods::getGoodsId, Function.identity(), (entity1, entity2) -> entity1));
            }
            for (MallShoppingCartItem MallShoppingCartItem : MallShoppingCartItems) {
                MallShoppingCartItemVO MallShoppingCartItemVO = new MallShoppingCartItemVO();
                BeanUtil.copyProperties(MallShoppingCartItem, MallShoppingCartItemVO);
                if (MallGoodsMap.containsKey(MallShoppingCartItem.getGoodsId())) {
                    MallGoods MallGoodsTemp = MallGoodsMap.get(MallShoppingCartItem.getGoodsId());
                    MallShoppingCartItemVO.setGoodsCoverImg(MallGoodsTemp.getGoodsCoverImg());
                    String goodsName = MallGoodsTemp.getGoodsName();
                    // 字符串过长导致文字超出的问题
                    if (goodsName.length() > 28) {
                        goodsName = goodsName.substring(0, 28) + "...";
                    }
                    MallShoppingCartItemVO.setGoodsName(goodsName);
                    MallShoppingCartItemVO.setSellingPrice(MallGoodsTemp.getSellingPrice());
                    MallShoppingCartItemVOS.add(MallShoppingCartItemVO);
                }
            }
        }
        return MallShoppingCartItemVOS;
    }

    @Override
    public PageResult getMyShoppingCartItems(PageQueryUtil pageUtil) {
        List<MallShoppingCartItemVO> MallShoppingCartItemVOS = new ArrayList<>();
        List<MallShoppingCartItem> MallShoppingCartItems = MallShoppingCartItemMapper.findMyMallCartItems(pageUtil);
        int total = MallShoppingCartItemMapper.getTotalMyNewBeeMallCartItems(pageUtil);
        PageResult pageResult = new PageResult(getMallShoppingCartItemVOS(MallShoppingCartItemVOS, MallShoppingCartItems), total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
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