package com.csj.cn.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.csj.cn.common.dto.Notice;
import com.csj.cn.common.dto.NoticeExample;
import com.csj.cn.common.service.NoticeService;
import com.csj.cn.provider.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> selectNoticeList() {
        NoticeExample noticeExample = new NoticeExample();
        noticeExample.setOrderByClause("current_time desc");
        List<Notice> noticeList = noticeMapper.selectByExample(noticeExample);
        return noticeList;
    }

    @Override
    public boolean scheduledSendNotice(Notice notice) {
        return noticeMapper.insertSelective(notice) > 0;
    }
}