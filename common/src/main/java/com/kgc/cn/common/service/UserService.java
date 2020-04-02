package com.kgc.cn.common.service;

import com.kgc.cn.common.dto.LoginUser;
import com.kgc.cn.common.dto.User;
import com.kgc.cn.common.vo.UserVo;

public interface UserService {
    /**
     * 登录
     * @param userVo
     * @return
     */
    LoginUser login(UserVo userVo);

    /**
     * 注册
     * @param user
     * @return
     */
    boolean register(User user);
}
