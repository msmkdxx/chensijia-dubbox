package com.kgc.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.cn.common.service.TestService;
import com.kgc.cn.common.vo.UserVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Reference
    private TestService testService;

    @GetMapping(value = "/testDubbo")
    public int testDubbo(){
        try {
            testService.testDubbo();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }
    }

    @GetMapping(value = "/getUser")
    public UserVo getUser(){
        UserVo user = testService.getUser();
        if(!ObjectUtils.isEmpty(user)){
            return user;
        }
        return null;
    }
}
