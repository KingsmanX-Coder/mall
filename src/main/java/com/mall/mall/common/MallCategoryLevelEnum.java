/**
 * Copyright (C), 2020-2020
 * FileName: MallCategoryLevelEnum
 * Author:   Kingsman
 * Date:     2020/6/8 2:10
 * Description:
 */

package com.mall.mall.common;

public enum MallCategoryLevelEnum {

    DEFAULT(0, "ERROR"),
    LEVEL_ONE(1, "一级分类"),
    LEVEL_TWO(2, "二级分类"),
    LEVEL_THREE(3, "三级分类");

    private int level;

    private String name;

   MallCategoryLevelEnum(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public static MallCategoryLevelEnum getMallOrderStatusEnumByLevel(int level) {
        for (MallCategoryLevelEnum MallCategoryLevelEnum : MallCategoryLevelEnum.values()) {
            if (MallCategoryLevelEnum.getLevel() == level) {
                return MallCategoryLevelEnum;
            }
        }
        return DEFAULT;
    }

    public int getLevel() {
       return level;
    }

    public void setLevel(int level) {
        this.level = level;
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