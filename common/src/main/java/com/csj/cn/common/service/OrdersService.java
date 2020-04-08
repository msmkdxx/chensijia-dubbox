package com.csj.cn.common.service;

import com.csj.cn.common.vo.OrdersVo;

public interface OrdersService {

    /**
     * 抢购
     *
     * @param ordersVo
     * @return
     */
    boolean timeToBuy(OrdersVo ordersVo);

}
