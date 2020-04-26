package com.csj.cn.consumer.wx;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/249:44
 */
@Data
@Component
@ConfigurationProperties(prefix = "wxPay")
public class WxPayConfig {
    private String appId;
    private String mchId;
    private String notifyUrl;
    private String key;
    private String unifiedUrl;
}
