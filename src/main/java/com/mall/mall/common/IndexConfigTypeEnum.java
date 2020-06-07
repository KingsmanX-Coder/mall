/**
 * Copyright (C), 2020-2020
 * FileName: IndexConfigTypeEnum
 * Author:   Kingsman
 * Date:     2020/6/8 2:09
 * Description:
 */

package com.mall.mall.common;

public enum IndexConfigTypeEnum {

    DEFAULT(0, "DEFAULT"),
    INDEX_SEARCH_HOTS(1, "INDEX_SEARCH_HOTS"),
    INDEX_SEARCH_DOWN_HOTS(2, "INDEX_SEARCH_DOWN_HOTS"),
    INDEX_GOODS_HOT(3, "INDEX_GOODS_HOTS"),
    INDEX_GOODS_NEW(4, "INDEX_GOODS_NEW"),
    INDEX_GOODS_RECOMMOND(5, "INDEX_GOODS_RECOMMOND");

    private int type;

    private String name;

    IndexConfigTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static IndexConfigTypeEnum getIndexConfigTypeEnumByType(int type) {
        for (IndexConfigTypeEnum indexConfigTypeEnum : IndexConfigTypeEnum.values()) {
            if (indexConfigTypeEnum.getType() == type) {
                return indexConfigTypeEnum;
            }
        }
        return DEFAULT;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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