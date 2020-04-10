package com.csj.cn.provider.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.csj.cn.common.dto.Goods;
import com.csj.cn.common.dto.Orders;
import com.csj.cn.common.dto.OrdersExample;
import com.csj.cn.common.service.OrdersService;
import com.csj.cn.common.utils.RedisUtils;
import com.csj.cn.common.vo.OrdersVo;
import com.csj.cn.provider.mapper.GoodsMapper;
import com.csj.cn.provider.mapper.OrdersMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/711:02
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean timeToBuy(OrdersVo ordersVo) {
        Goods goods = goodsMapper.selectByPrimaryKey(ordersVo.getGoodId());
        if (goods.getCount() > 0) {
            //查询该用户的订单中是否有该商品订单
            OrdersExample ordersExample = new OrdersExample();
            ordersExample.createCriteria().andGoodIdEqualTo(ordersVo.getGoodId()).andPhoneEqualTo(ordersVo.getPhone());
            List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);
            if (ObjectUtils.isEmpty(ordersList)) {//没有这个订单
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    @JmsListener(destination = "orders.madeOrder")
    public void createOrders(OrdersVo ordersVo) {
        Orders orders = new Orders();
        if (!redisUtils.hasKey(ordersVo.getOrderId())) {
            BeanUtils.copyProperties(ordersVo, orders);
            ordersMapper.insertSelective(orders);
            //修改库存
            goodsMapper.reduceCount(1, ordersVo.getGoodId());
            redisUtils.set(ordersVo.getOrderId(), ordersVo);
            redisUtils.expire(ordersVo.getOrderId(), 20);
        }
    }
}
