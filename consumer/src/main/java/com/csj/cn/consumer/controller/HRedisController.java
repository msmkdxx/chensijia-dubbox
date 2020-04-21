package com.csj.cn.consumer.controller;

import com.csj.cn.common.enums.Color;
import com.csj.cn.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/1316:53
 */
@RestController
@RequestMapping("/redis")
public class HRedisController {
    @Autowired
    private RedisUtils redisUtils;

    String nameSpace = "TIME_TO_BUY:";

    @GetMapping(value = "/setKeys")
    public void setKeys(String str) {
        redisUtils.set(nameSpace + str, 1);
    }

    @GetMapping(value = "/getKeys")
    public Set<String> getKeys() {
        return redisUtils.getKeys(nameSpace);
    }

    @GetMapping(value = "/getFreq")
    public boolean getFreq() {
        return redisUtils.checkFreq("11", 3, 10);
    }

    @GetMapping(value = "/testEnum")
    public String testEnum(String color) {
        String colorName = "";
        switch (Color.matchOpCode(color)) {
            case RED:
                colorName = Color.RED.getName();
                break;
            case YELLOW:
                colorName = Color.YELLOW.getName();
                break;
            case GREEN:
                colorName = Color.GREEN.getName();
                break;
        }
        return colorName;
    }
}
