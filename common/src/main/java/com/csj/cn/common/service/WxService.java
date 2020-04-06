package com.csj.cn.common.service;

import com.csj.cn.common.vo.LoginUser;

public interface WxService {

    /**
     * 微信登录
     * @param loginUser
     * @return
     */
    boolean wxLogin(LoginUser loginUser);
}
