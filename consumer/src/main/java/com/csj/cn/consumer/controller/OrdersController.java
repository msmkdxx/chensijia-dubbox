package com.csj.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csj.cn.common.enums.ErrorEnums;
import com.csj.cn.common.exception.ServiceException;
import com.csj.cn.common.service.GoodsService;
import com.csj.cn.common.service.OrdersService;
import com.csj.cn.common.vo.LoginUser;
import com.csj.cn.common.vo.OrdersVo;
import com.csj.cn.consumer.conf.CurrentUser;
import com.csj.cn.consumer.conf.LoginReqired;
import com.csj.cn.consumer.utils.RedisUtils;
import com.csj.cn.consumer.utils.ReturnResult;
import com.csj.cn.consumer.utils.ReturnResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/710:59
 */
@Api(tags = "订单")
@RestController
@RequestMapping(value = "/order")
public class OrdersController {
    @Reference
    private OrdersService ordersService;
    @Reference
    private GoodsService goodsService;
    @Autowired
    private RedisUtils redisUtils;

    @LoginReqired
    @ApiOperation(value = "抢购")
    @GetMapping(value = "/timeToBuy")
    public ReturnResult timeToBuy(@RequestParam long goodId, @CurrentUser LoginUser loginUser) {
        //查看库存是否足够
        if (goodsService.selectCount(goodId)) {
            OrdersVo ordersVo = new OrdersVo();
            ordersVo.setGoodId(goodId);
            ordersVo.setPhone(loginUser.getPhone());
            //生成订单号
            String orderId = UUID.randomUUID().toString();
            ordersVo.setOrderId(orderId);
            if (ordersService.timeToBuy(ordersVo)) {
                redisUtils.set(ordersVo.getOrderId(), ordersVo);
                redisUtils.expire(ordersVo.getOrderId(), 20);
                return ReturnResultUtils.returnSucess();
            } else {
                return ReturnResultUtils.returnFail(12, "抢购失败");
            }
        } else {
            return ReturnResultUtils.returnFail(11, "没有库存了");
        }
    }
}
