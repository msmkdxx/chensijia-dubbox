package com.kgc.cn.common.service;

import com.kgc.cn.common.vo.LoginUser;

public interface UserService {
    /**
     * 登录
     * @param userVo
     * @return
     */
    LoginUser login(LoginUser userVo);

    /**
     * 注册
     * @param userVo
     * @return
     */
    boolean register(LoginUser userVo);
}
