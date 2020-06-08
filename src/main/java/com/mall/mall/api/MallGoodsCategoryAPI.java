/**
 * Copyright (C), 2020-2020
 * FileName: GoodsCategoryAPI
 * Author:   Kingsman
 * Date:     2020/6/8 0:04
 * Description:
 */

package com.mall.mall.api;


import com.mall.mall.api.vo.MallIndexCategoryVO;
import com.mall.mall.common.MallException;
import com.mall.mall.common.ServiceResultEnum;
import com.mall.mall.util.Result;
import com.mall.mall.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "v1", tags = "3.商城分类页面接口")
@RequestMapping("/api/v1")
public class MallGoodsCategoryAPI {

    @Resource
    private com.mall.mall.service.MallCategoryService MallCategoryService;

    @GetMapping("/categories")
    @ApiOperation(value = "获取分类数据", notes = "分类页面使用")
    public Result<List<MallIndexCategoryVO>> getCategories() {
        List<MallIndexCategoryVO> categories = MallCategoryService.getCategoriesForIndex();
        if (CollectionUtils.isEmpty(categories)) {
            MallException.fail(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        return ResultGenerator.genSuccessResult(categories);
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