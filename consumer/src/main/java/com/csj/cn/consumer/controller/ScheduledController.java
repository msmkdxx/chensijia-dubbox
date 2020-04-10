package com.csj.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csj.cn.common.dto.Notice;
import com.csj.cn.common.service.NoticeService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/1010:32
 */
@Configuration
@EnableScheduling
public class ScheduledController {
    @Reference
    private NoticeService noticeService;

    @Scheduled(fixedRate = 5000)
    public void selectNotice(){
        Notice notice = noticeService.selectNoticeList().get(0);
        System.out.println("通知标题："+notice.getTitle()+",通知内容："+notice.getContent());
    }

}
