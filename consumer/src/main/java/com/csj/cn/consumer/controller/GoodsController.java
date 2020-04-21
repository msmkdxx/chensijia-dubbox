package com.csj.cn.consumer.controller;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.csj.cn.common.dto.Goods;
import com.csj.cn.common.dto.GoodsLike;
import com.csj.cn.common.dto.GoodsLikeExample;
import com.csj.cn.common.enums.ErrorEnums;
import com.csj.cn.common.exception.ServiceException;
import com.csj.cn.common.service.GoodsLikeService;
import com.csj.cn.common.service.GoodsService;
import com.csj.cn.common.utils.PageUtils;
import com.csj.cn.common.utils.RedisUtils;
import com.csj.cn.common.vo.GoodsVo;
import com.csj.cn.common.vo.LoginUser;
import com.csj.cn.consumer.conf.CurrentUser;
import com.csj.cn.consumer.conf.LoginReqired;
import com.csj.cn.consumer.utils.ReturnResult;
import com.csj.cn.consumer.utils.ReturnResultUtils;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/716:01
 */
@Api(tags = "商品")
@RestController
@Configuration
@EnableScheduling
@RequestMapping(value = "/goods")
public class GoodsController {
    @Reference
    private GoodsService goodsService;
    @Reference
    private GoodsLikeService goodsLikeService;
    @Autowired
    private RedisUtils redisUtils;
    private Jedis redisOps = new Jedis("localhost", 6379);
    String goods_like = "goods_like:";

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
                                                @RequestParam(name = "pageNo", required = false, defaultValue = "1") int pageNo,
                                                @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
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

    @ApiOperation(value = "点赞")
    @LoginReqired
    @GetMapping(value = "/like")
    public ReturnResult like(@CurrentUser LoginUser loginUser, String goodId, Integer status) {
        if (!redisUtils.checkFreq(goods_like + goodId + ":" + loginUser.getId(), 2, 5)) {
            return ReturnResultUtils.returnFail(21, "点赞太频繁了");
        } else if (islike(loginUser.getId(), goodId) && status == +1) {
            throw new ServiceException(ErrorEnums.ERROR_GOODS_LIKE);
        }
        redisOps.lpush(goods_like + goodId + ":" + loginUser.getId(), String.valueOf(status));
        //计算总数
        if (status == +1) {
            redisOps.incrBy(goods_like + goodId, 1);
        } else {
            redisOps.decrBy(goods_like + goodId, 1);
        }
        return ReturnResultUtils.returnSucess();
    }

    /**
     * 是否点赞
     *
     * @param userId
     * @param goodId
     * @return
     */
    public boolean islike(long userId, String goodId) {
        if (getStatus(userId, goodId) > 0) return true;

        return goodsLikeService.islike(userId, goodId);
    }

    /**
     * 定时将redis中的数据存入数据库
     */
    @Async
    @Scheduled(cron = "0 0 1 * * ?")
    public void scheduledInsertGoodsLike() {
        Set<String> keys = redisUtils.getKeys(goods_like);
        keys.stream().forEach(key -> {
            String[] goodIdAndUserIds = key.split(":");
            GoodsLike goodsLike = new GoodsLike();
            goodsLike.setGoodId(goodIdAndUserIds[0]);
            goodsLike.setUserId(Long.parseLong(goodIdAndUserIds[1]));
            goodsLike.setStatus(getStatus(Long.parseLong(goodIdAndUserIds[1]), goodIdAndUserIds[0]));
            goodsLikeService.insertGoodsLike(goodsLike);
        });
    }

    /**
     * 获取redis中某商品某用户点赞status之和
     *
     * @param userId
     * @param goodId
     * @return
     */
    public int getStatus(long userId, String goodId) {
        //某商品某用户的点赞记录
        List<String> statusList = redisOps.lrange(goods_like + goodId + ":" + userId, 0, -1);
        List<Integer> integerList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(statusList)) {
            statusList.stream().forEach(s -> {
                integerList.add(Integer.valueOf(s));
            });
            return integerList.stream().mapToInt(i -> i).sum();
        }
        return 0;
    }

}
