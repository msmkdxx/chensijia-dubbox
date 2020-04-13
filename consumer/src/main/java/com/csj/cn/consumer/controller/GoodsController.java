package com.csj.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csj.cn.common.dto.Goods;
import com.csj.cn.common.enums.ErrorEnums;
import com.csj.cn.common.exception.ServiceException;
import com.csj.cn.common.service.GoodsService;
import com.csj.cn.common.utils.PageUtils;
import com.csj.cn.common.vo.GoodsVo;
import com.csj.cn.consumer.conf.LoginReqired;
import com.csj.cn.consumer.utils.ReturnResult;
import com.csj.cn.consumer.utils.ReturnResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/716:01
 */
@Api(tags = "商品")
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Reference
    private GoodsService goodsService;

    @ApiOperation(value = "添加商品")
    @LoginReqired
    @GetMapping(value = "/addGoods")
    public ReturnResult addGoods(@Validated GoodsVo goodsVo) {
        if (!ObjectUtils.isEmpty(goodsVo)) {
            try {
                goodsService.addGoods(goodsVo);
                return ReturnResultUtils.returnSucess();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ReturnResultUtils.returnFail(716, "添加商品异常");
        }
        throw new ServiceException(ErrorEnums.EMPTY_PARAM);
    }

    @ApiOperation(value = "返回商品列表")
    @GetMapping(value = "/selectGoods")
    public PageUtils<List<Goods>> showGoodsList(@RequestParam(name = "searchStr", required = false, defaultValue = "") String searchStr,
                                                @RequestParam(name = "pageNo", required = true) int pageNo,
                                                @RequestParam(name = "pageSize", required = true) int pageSize) {
        PageUtils pageUtils = new PageUtils();
        pageUtils.setPageNo(pageNo);
        pageUtils.setCurrentPage(pageNo);
        pageUtils.setPageSize(pageSize);
        Map goodsListMap = goodsService.showGoodsListMap(searchStr, pageUtils.getPageNo(), pageSize);
        pageUtils.setCurrentList((List<Goods>) goodsListMap.get("currentList"));
        pageUtils.setTotalCount((Long) goodsListMap.get("totalCount"));
        return pageUtils;

    }

    @ApiOperation(value = "查询商品详情")
    @GetMapping(value = "/selectByPrimaryKey")
    public Goods selectByPrimaryKey(@RequestParam String goodId) {
        return goodsService.selectByPrimaryKey(goodId);
    }
}
