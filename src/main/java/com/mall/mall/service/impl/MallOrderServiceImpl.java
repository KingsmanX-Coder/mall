/**
 * Copyright (C), 2020-2020
 * FileName: MallOrderServiceImpl
 * Author:   Kingsman
 * Date:     2020/6/8 3:40
 * Description:
 */

package com.mall.mall.service.impl;

import com.mall.mall.api.vo.MallOrderDetailVO;
import com.mall.mall.api.vo.MallOrderItemVO;
import com.mall.mall.api.vo.MallOrderListVO;
import com.mall.mall.api.vo.MallShoppingCartItemVO;
import com.mall.mall.common.*;
import com.mall.mall.dao.*;
import com.mall.mall.entity.*;
import com.mall.mall.service.MallOrderService;
import com.mall.mall.util.BeanUtil;
import com.mall.mall.util.NumberUtil;
import com.mall.mall.util.PageQueryUtil;
import com.mall.mall.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MallOrderServiceImpl implements MallOrderService {

    @Autowired
    private MallOrderMapper MallOrderMapper;
    @Autowired
    private MallOrderItemMapper MallOrderItemMapper;
    @Autowired
    private MallShoppingCartItemMapper MallShoppingCartItemMapper;
    @Autowired
    private MallGoodsMapper MallGoodsMapper;
    @Autowired
    private MallOrderAddressMapper MallOrderAddressMapper;

    @Override
    public MallOrderDetailVO getOrderDetailByOrderNo(String orderNo, Long userId) {
        MallOrder MallOrder = MallOrderMapper.selectByOrderNo(orderNo);
        if (MallOrder == null) {
            MallException.fail(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        if (!userId.equals(MallOrder.getUserId())) {
            MallException.fail(ServiceResultEnum.REQUEST_FORBIDEN_ERROR.getResult());
        }
        List<MallOrderItem> orderItems = MallOrderItemMapper.selectByOrderId(MallOrder.getOrderId());
        //获取订单项数据
        if (!CollectionUtils.isEmpty(orderItems)) {
            List<MallOrderItemVO> MallOrderItemVOS = BeanUtil.copyList(orderItems, MallOrderItemVO.class);
            MallOrderDetailVO MallOrderDetailVO = new MallOrderDetailVO();
            BeanUtil.copyProperties(MallOrder, MallOrderDetailVO);
            MallOrderDetailVO.setOrderStatusString(MallOrderStatusEnum.getMallOrderStatusEnumByStatus(MallOrderDetailVO.getOrderStatus()).getName());
            MallOrderDetailVO.setPayTypeString(PayTypeEnum.getPayTypeEnumByType(MallOrderDetailVO.getPayType()).getName());
            MallOrderDetailVO.setMallOrderItemVOS(MallOrderItemVOS);
            return MallOrderDetailVO;
        } else {
            MallException.fail(ServiceResultEnum.ORDER_ITEM_NULL_ERROR.getResult());
            return null;
        }
    }

    @Override
    public PageResult getMyOrders(PageQueryUtil pageUtil) {
        int total = MallOrderMapper.getTotalMallOrders(pageUtil);
        List<MallOrder> MallOrders = MallOrderMapper.findMallOrderList(pageUtil);
        List<MallOrderListVO> orderListVOS = new ArrayList<>();
        if (total > 0) {
            //数据转换 将实体类转成vo
            orderListVOS = BeanUtil.copyList(MallOrders, MallOrderListVO.class);
            //设置订单状态中文显示值
            for (MallOrderListVO newBeeMallOrderListVO : orderListVOS) {
                newBeeMallOrderListVO.setOrderStatusString(MallOrderStatusEnum.getMallOrderStatusEnumByStatus(MallOrderListVO.getOrderStatus()).getName());
            }
            List<Long> orderIds = MallOrders.stream().map(MallOrder::getOrderId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(orderIds)) {
                List<MallOrderItem> orderItems = MallOrderItemMapper.selectByOrderIds(orderIds);
                Map<Long, List<MallOrderItem>> itemByOrderIdMap = orderItems.stream().collect(groupingBy(MallOrderItem::getOrderId));
                for (MallOrderListVO MallOrderListVO : orderListVOS){
                    //封装每个订单列表对象的订单项数据
                    if (itemByOrderIdMap.containsKey(MallOrderListVO.getOrderId())) {
                        List<MallOrderItem> orderItemListTemp = itemByOrderIdMap.get(MallOrderListVO.getOrderId());
                        //将NewBeeMallOrderItem对象列表转换成NewBeeMallOrderItemVO对象列表
                        List<MallOrderItemVO> MallOrderItemVOS = BeanUtil.copyList(orderItemListTemp, MallOrderItemVO.class);
                        MallOrderListVO.setMallOrderItemVOS(MallOrderItemVOS);
                    }
                }
            }
        }
        PageResult pageResult = new PageResult(orderListVOS, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String cancelOrder(String orderNo, Long userId) {
        MallOrder MallOrder = MallOrderMapper.selectByOrderNo(orderNo);
        if (MallOrder != null) {
            //todo 验证是否是当前userId下的订单，否则报错
            //todo 订单状态判断
            if (MallOrderMapper.closeOrder(Collections.singletonList(MallOrder.getOrderId()),MallOrderStatusEnum.ORDER_CLOSED_BY_MALLUSER.getOrderStatus()) > 0) {
                return ServiceResultEnum.SUCCESS.getResult();
            } else {
                return ServiceResultEnum.DB_ERROR.getResult();
            }
        }
        return ServiceResultEnum.ORDER_NOT_EXIST_ERROR.getResult();
    }

    @Override
    public String finishOrder(String orderNo, Long userId) {
        MallOrder MallOrder = MallOrderMapper.selectByOrderNo(orderNo);
        if (MallOrder != null) {
            //todo 验证是否是当前userId下的订单，否则报错
            //todo 订单状态判断
            MallOrder.setOrderStatus((byte) MallOrderStatusEnum.ORDER_SUCCESS.getOrderStatus());
            MallOrder.setUpdateTime(new Date());
            if (MallOrderMapper.updateByPrimaryKeySelective(MallOrder) > 0) {
                return ServiceResultEnum.SUCCESS.getResult();
            } else {
                return ServiceResultEnum.DB_ERROR.getResult();
            }
        }
        return ServiceResultEnum.ORDER_NOT_EXIST_ERROR.getResult();
    }

    @Override
    public String paySuccess(String orderNo, int payType) {
        MallOrder MallOrder = MallOrderMapper.selectByOrderNo(orderNo);
        if (MallOrder != null) {
            if (MallOrder.getOrderStatus().intValue() != MallOrderStatusEnum.ORDER_PRE_PAY.getOrderStatus()) {
                MallException.fail("非待支付状态下的订单无法支付");
            }
            MallOrder.setOrderStatus((byte) MallOrderStatusEnum.OREDER_PAID.getOrderStatus());
            MallOrder.setPayType((byte) payType);
            MallOrder.setPayStatus((byte) PayStatusEnum.PAY_SUCCESS.getPayStatus());
            MallOrder.setPayTime(new Date());
            MallOrder.setUpdateTime(new Date());
            if (MallOrderMapper.updateByPrimaryKeySelective(MallOrder) > 0) {
                return ServiceResultEnum.SUCCESS.getResult();
            } else {
                return ServiceResultEnum.DB_ERROR.getResult();
            }
        }
        return ServiceResultEnum.ORDER_NOT_EXIST_ERROR.getResult();
    }

    @Override
    @Transactional
    public String saveOrder(MallUser loginMallUser, MallUserAddress address, List<MallShoppingCartItemVO> myShoppingCartItems) {
        List<Long> itemIdList = myShoppingCartItems.stream().map(MallShoppingCartItemVO::getCartItemId).collect(Collectors.toList());
        List<Long> goodsIds = myShoppingCartItems.stream().map(MallShoppingCartItemVO::getGoodsId).collect(Collectors.toList());
        List<MallGoods> MallGoods = MallGoodsMapper.selectByPrimaryKeys(goodsIds);
        //检查是否包含已下架商品
        List<MallGoods> goodsListNotSelling = MallGoods.stream()
                .filter(MallGoodsTemp -> MallGoodsTemp.getGoodsSellStatus() != Constants.SELL_STATUS_UP)
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(goodsListNotSelling)) {
            //goodsListNotSelling 对象非空则表示有下架商品
            MallException.fail(goodsListNotSelling.get(0).getGoodsName() + "已下架，无法生成订单");
        }
        Map<Long, MallGoods> MallGoodsMap = MallGoods.stream().collect(Collectors.toMap(MallGoods::getGoodsId, Function.identity(), (entity1, entity2) -> entity1));
        //判断商品库存
        for (MallShoppingCartItemVO shoppingCartItemVO : myShoppingCartItems) {
            //查出的商品中不存在购物车中的这条关联商品数据，直接返回错误提醒
            if (!MallGoodsMap.containsKey(shoppingCartItemVO.getGoodsId())) {
                MallException.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
            }
            //存在数量大于库存的情况，直接返回错误提醒
            if (shoppingCartItemVO.getGoodsCount() > MallGoodsMap.get(shoppingCartItemVO.getGoodsId()).getStockNum()) {
                MallException.fail(ServiceResultEnum.SHOPPING_ITEM_COUNT_ERROR.getResult());
            }
        }
        //删除购物项
        if (!CollectionUtils.isEmpty(itemIdList) && !CollectionUtils.isEmpty(goodsIds) && !CollectionUtils.isEmpty(MallGoods)) {
            if (MallShoppingCartItemMapper.deleteBatch(itemIdList) > 0) {
                List<StockNumDTO> stockNumDTOS = BeanUtil.copyList(myShoppingCartItems, StockNumDTO.class);
                int updateStockNumResult = MallGoodsMapper.updateStockNum(stockNumDTOS);
                if (updateStockNumResult < 1) {
                    MallException.fail(ServiceResultEnum.SHOPPING_ITEM_COUNT_ERROR.getResult());
                }
                //生成订单号
                String orderNo = NumberUtil.genOrderNo();
                int priceTotal = 0;
                //保存订单
                MallOrder MallOrder = new MallOrder();
                MallOrder.setOrderNo(orderNo);
                MallOrder.setUserId(loginMallUser.getUserId());
                //总价
                for (MallShoppingCartItemVOMallShoppingCartItemVO : myShoppingCartItems) {
                    priceTotal += MallShoppingCartItemVO.getGoodsCount() * MallShoppingCartItemVO.getSellingPrice();
                }
                if (priceTotal < 1) {
                    MallException.fail(ServiceResultEnum.ORDER_PRICE_ERROR.getResult());
                }
                MallOrder.setTotalPrice(priceTotal);
                String extraInfo = "";
                MallOrder.setExtraInfo(extraInfo);
                //生成订单项并保存订单项纪录
                if (MallOrderMapper.insertSelective(MallOrder) > 0) {
                    //生成订单收货地址快照，并保存至数据库
                    MallOrderAddress MallOrderAddress = new MallOrderAddress();
                    BeanUtil.copyProperties(address, MallOrderAddress);
                    MallOrderAddress.setOrderId(MallOrder.getOrderId());
                    //生成所有的订单项快照，并保存至数据库
                    List<MallOrderItem> MallOrderItems = new ArrayList<>();
                    for (MallShoppingCartItemVO MallShoppingCartItemVO : myShoppingCartItems) {
                        MallOrderItem MallOrderItem = new MallOrderItem();
                        //使用BeanUtil工具类将newBeeMallShoppingCartItemVO中的属性复制到newBeeMallOrderItem对象中
                        BeanUtil.copyProperties(MallShoppingCartItemVO, MallOrderItem);
                        //NewBeeMallOrderMapper文件insert()方法中使用了useGeneratedKeys因此orderId可以获取到
                        MallOrderItem.setOrderId(MallOrder.getOrderId());
                        MallOrderItems.add(MallOrderItem);
                    }
                    //保存至数据库
                    if (MallOrderItemMapper.insertBatch(MallOrderItems) > 0 && MallOrderAddressMapper.insertSelective(MallOrderAddress) > 0) {
                        //所有操作成功后，将订单号返回，以供Controller方法跳转到订单详情
                        return orderNo;
                    }
                    MallException.fail(ServiceResultEnum.ORDER_PRICE_ERROR.getResult());
                }
                MallException.fail(ServiceResultEnum.DB_ERROR.getResult());
            }
            MallException.fail(ServiceResultEnum.DB_ERROR.getResult());
        }
       MallException.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
        return ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult();
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