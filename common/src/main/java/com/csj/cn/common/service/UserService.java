package com.csj.cn.common.service;

import com.csj.cn.common.vo.LoginUser;

public interface UserService {
    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    LoginUser login(String phone, String password);

    /**
     * 注册
     *
     * @param userVo
     * @return
     */
    boolean register(LoginUser userVo);
}
