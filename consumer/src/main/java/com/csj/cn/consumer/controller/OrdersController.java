package com.csj.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csj.cn.common.service.OrdersService;
import com.csj.cn.common.utils.RedisUtils;
import com.csj.cn.common.vo.LoginUser;
import com.csj.cn.common.vo.OrdersVo;
import com.csj.cn.consumer.conf.CurrentUser;
import com.csj.cn.consumer.conf.LoginReqired;
import com.csj.cn.consumer.utils.ActiveMqUtils;
import com.csj.cn.consumer.utils.ReturnResult;
import com.csj.cn.consumer.utils.ReturnResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    @Autowired
    ActiveMqUtils activeMqUtils;
    @Autowired
    private RedisUtils redisUtils;

    String nameSpace = "TIME_TO_BUY:";

    @LoginReqired
    @ApiOperation(value = "抢购")
    @GetMapping(value = "/timeToBuy")
    public ReturnResult timeToBuy(@RequestParam String goodId, @CurrentUser LoginUser loginUser) {
        if (checkStatus(goodId)) {
            OrdersVo ordersVo = new OrdersVo();
            ordersVo.setOrderId(loginUser.getId() + "" + UUID.randomUUID());
            ordersVo.setGoodId(goodId);
            ordersVo.setPhone(loginUser.getPhone());
            if (ordersService.timeToBuy(ordersVo)) {
                activeMqUtils.sendQueueMsg("orders.madeOrder", ordersVo);
                redisUtils.delLock(nameSpace + goodId);
                return ReturnResultUtils.returnSucess();
            }
            redisUtils.delLock(nameSpace + goodId);
            return ReturnResultUtils.returnFail(11, "您不能再抢购了");
        }
        return ReturnResultUtils.returnFail(12, "您点击的次数太频繁了");
    }

    /**
     * 判断点击频率和上锁
     *
     * @param goodId
     * @return
     */
    public boolean checkStatus(String goodId) {
        return redisUtils.checkFreq(nameSpace + goodId, 2, 20) && redisUtils.lock(nameSpace + goodId, "1", 100);
    }
}
