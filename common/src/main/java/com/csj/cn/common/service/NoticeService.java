package com.csj.cn.common.service;

import com.csj.cn.common.dto.Notice;

import java.util.List;

public interface NoticeService {
    /**
     * 查看通知列表
     *
     * @return
     */
    List<Notice> selectNoticeList();

    /**
     * 定时发通知
     *
     * @return
     */
    boolean scheduledSendNotice(Notice notice);
}
