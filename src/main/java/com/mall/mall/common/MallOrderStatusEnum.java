/**
 * Copyright (C), 2020-2020
 * FileName: MallOrderStatusEnum
 * Author:   Kingsman
 * Date:     2020/6/8 2:13
 * Description:
 */

package com.mall.mall.common;

public enum MallOrderStatusEnum {

    DEFAULT(-9, "ERROR"),
    ORDER_PRE_PAY(0, "待支付"),
    OREDER_PAID(1, "已支付"),
    OREDER_PACKAGED(2, "配货完成"),
    OREDER_EXPRESS(3, "出库成功"),
    ORDER_SUCCESS(4, "交易成功"),
    ORDER_CLOSED_BY_MALLUSER(-1, "手动关闭"),
    ORDER_CLOSED_BY_EXPIRED(-2, "超时关闭"),
    ORDER_CLOSED_BY_JUDGE(-3, "商家关闭");

    private int orderStatus;

    private String name;

    MallOrderStatusEnum(int orderStatus, String name) {
        this.orderStatus = orderStatus;
        this.name = name;
    }

    public static MallOrderStatusEnum getMallOrderStatusEnumByStatus(int orderStatus) {
        for (MallOrderStatusEnum MallOrderStatusEnum : MallOrderStatusEnum.values()) {
            if (MallOrderStatusEnum.getOrderStatus() == orderStatus) {
                return MallOrderStatusEnum;
            }
        }
        return DEFAULT;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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