package com.csj.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.csj.cn.common.service.WxService;
import com.csj.cn.common.utils.HttpClientUtils;
import com.csj.cn.common.utils.RedisUtils;
import com.csj.cn.common.vo.LoginUser;
import com.csj.cn.consumer.wx.WxConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/611:05
 */
@Api(tags = "微信")
@Controller
@RequestMapping(value = "/wx")
public class WxController {
    @Autowired
    private WxConfig wxConfig;
    @Reference
    private WxService wxService;
    @Autowired
    private RedisUtils redisUtils;

    //https://d4e8e82e.ngrok.io/wx/wxLogin
    @ApiOperation(value = "微信登录")
    @GetMapping(value = "/wxLogin")
    public String wxLogin() {
        String codeUri = wxConfig.reqCodeUri();
        return "redirect:" + codeUri;
    }

    @GetMapping(value = "/callBack")
    public String callBack(String code) throws IOException {
        if (null != code) {
            String accessTokenStr = HttpClientUtils.doGet(wxConfig.reqAccessTokenUrl(code));
            JSONObject jsonObject = JSONObject.parseObject(accessTokenStr);
            String accessToken = jsonObject.getString("access_token");
            String openId = jsonObject.getString("openid");
            String userInfo = HttpClientUtils.doGet(wxConfig.reqUserInfoUrl(accessToken, openId));
            //微信登陆后将信息存入数据库
            LoginUser loginUser = JSONObject.parseObject(userInfo, LoginUser.class);
            loginUser.setPhone("18852077899");
            try {
                wxService.wxLogin(loginUser);
                redisUtils.set(openId, userInfo);
                return "redirect:" + wxConfig.getLoginSuccess()+openId;
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:" + wxConfig.getLoginFail();
            }
        }
        return "redirect:" + wxConfig.getLoginFail();
    }

}
