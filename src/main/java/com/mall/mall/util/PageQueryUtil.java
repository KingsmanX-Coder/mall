/**
 * Copyright (C), 2020-2020
 * FileName: PageQueryUtil
 * Author:   Kingsman
 * Date:     2020/6/8 4:25
 * Description:
 */

package com.mall.mall.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class PageQueryUtil extends LinkedHashMap<String, Object> {
    //当前页码
    private int page;
    //每页条数
    private int limit;

    public PageQueryUtil(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("start", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
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