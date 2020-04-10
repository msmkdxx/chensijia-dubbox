package com.csj.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.csj.cn.common.dto.Notice;
import com.csj.cn.common.service.NoticeService;
import com.csj.cn.common.utils.RedisUtils;
import com.csj.cn.common.vo.LoginUser;
import com.csj.cn.consumer.conf.CurrentUser;
import com.csj.cn.consumer.conf.LoginReqired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/1012:02
 */
@Api(tags = "通知")
@RestController
@RequestMapping(value = "/notice")
public class NoticeController {
    @Reference
    private NoticeService noticeService;
    @Autowired
    private RedisUtils redisUtils;

    @GetMapping(value = "/selectNotice")
    public List<Notice> selectNotice(){
        return noticeService.selectNoticeList();
    }

    @GetMapping(value = "/test")
    public void test(){
        redisUtils.set("title","content");
        redisUtils.expire("title",2);
    }
}
