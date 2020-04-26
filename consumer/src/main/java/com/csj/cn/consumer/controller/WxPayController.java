package com.csj.cn.consumer.controller;

import com.csj.cn.common.utils.WxPayUtils;
import com.csj.cn.common.vo.OrdersVo;
import com.csj.cn.consumer.service.TestService;
import com.csj.cn.consumer.wx.WxPayConfig;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/249:43
 */
@RestController
@RequestMapping(value = "/wxPay")
public class WxPayController {
    @Autowired
    private TestService testService;
    @Autowired
    private WxPayConfig wxPayConfig;

    @GetMapping(value = "/toPay")
    public String toPay(OrdersVo ordersVo) {
        return testService.isOrder(ordersVo);
    }

    @RequestMapping(value = "/wxPayNotify")
    public String wxPayNotify(HttpServletRequest request) throws Exception {
        //todo 验证是否付款成功
        InputStream inputStream = request.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }
        bufferedReader.close();
        inputStream.close();
        Map<String, String> resultMap = WxPayUtils.xmlToMap(stringBuffer.toString());
        //todo 验证签名
        String wxSign = resultMap.get("sign");
        boolean isCheckSign = WxPayUtils.isCheckSign(resultMap, wxPayConfig.getKey(), wxSign);
        if (isCheckSign) {
            Map<String, String> clientMap = Maps.newHashMap();
            clientMap.put("return_code", "SUCCESS");
            clientMap.put("return_msg", "OK");
            return WxPayUtils.mapToXml(clientMap);
        }
        //todo insert进账单
        return null;
    }
}
