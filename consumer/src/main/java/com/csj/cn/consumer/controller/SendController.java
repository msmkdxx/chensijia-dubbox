package com.csj.cn.consumer.controller;

import com.csj.cn.common.vo.LoginUser;
import com.csj.cn.consumer.utils.ActiveMqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/914:43
 */
@Controller
@RequestMapping(value = "/send")
public class SendController {

    @Autowired
    private ActiveMqUtils activeMqUtils;

    @GetMapping(value = "/sendMsg")
    public void sendMsg() {
        LoginUser loginUser = new LoginUser();
        loginUser.setPhone("18852072789");
        activeMqUtils.sendQueueMsg("loginUser", loginUser);
    }

    @JmsListener(destination = "loginUser")
    public String getMsg(String msg) {
        return msg;
    }

    @GetMapping(value = "/sendTopicMsg")
    public void sendTopicMsg() {
        activeMqUtils.sendTopicMsg("topic", "topic");
    }

    @JmsListener(destination = "topic")
    public void topic1(String msg) {
        System.out.println("1" + msg);
    }

    @JmsListener(destination = "topic")
    public void topic2(String msg) {
        System.out.println("2" + msg);
    }
}
