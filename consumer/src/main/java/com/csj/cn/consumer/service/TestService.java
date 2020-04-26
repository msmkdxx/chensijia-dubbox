package com.csj.cn.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csj.cn.common.dto.Goods;
import com.csj.cn.common.service.GoodsService;
import com.csj.cn.common.utils.CommonUtils;
import com.csj.cn.common.utils.HttpClientUtils;
import com.csj.cn.common.utils.WxPayUtils;
import com.csj.cn.common.vo.OrdersVo;
import com.csj.cn.consumer.wx.WxPayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/249:55
 */
@Service
public class TestService {
    @Autowired
    private WxPayConfig wxPayConfig;
    @Reference
    private GoodsService goodsService;

    public String isOrder(OrdersVo ordersVo) {
        /*OrdersVo ordersVo = new OrdersVo();
        int num = Math.abs(new Random().nextInt());
        ordersVo.setOrderId(String.valueOf(num));
        ordersVo.setName("学习");
        ordersVo.setPrice(1);*/
        Goods goods = goodsService.selectByPrimaryKey(ordersVo.getGoodId());
        ordersVo.setName(goods.getName());
        ordersVo.setPrice(goods.getPrice());
        return unifiedOrder(ordersVo);
    }

    //统一下单方法
    private String unifiedOrder(OrdersVo ordersVo) {
        SortedMap<String, String> param = new TreeMap<>();
        param.put("appid", wxPayConfig.getAppId());
        param.put("mch_id", wxPayConfig.getMchId());
        //随机字符串
        param.put("nonce_str", CommonUtils.generatorUUID());
        //商品描述
        param.put("body", ordersVo.getName());
        param.put("out_trade_no", ordersVo.getOrderId());
        param.put("total_fee", String.valueOf(ordersVo.getPrice()));
        param.put("spbill_create_ip", "192.168.124.9");
        param.put("notify_url", wxPayConfig.getNotifyUrl());
        param.put("trade_type", "NATIVE");
        param.put("sign", WxPayUtils.generateSignature(param, wxPayConfig.getKey()));
        String payXml = WxPayUtils.mapToXml(param);
        //请求统一下单接口
        String order = HttpClientUtils.doPost(wxPayConfig.getUnifiedUrl(), payXml, 4000);
        Map<String, String> resultMap = WxPayUtils.xmlToMap(order);
        if ("SUCCESS".equals(resultMap.get("return_code")) && "SUCCESS".equals(resultMap.get("result_code"))) {
            return resultMap.get("code_url");
        }
        return null;
    }
}
