package com.kgc.cn.common.service;

import com.kgc.cn.common.dto.LoginUser;
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
     * @param userVo
     * @return
     */
    boolean register(UserVo userVo);
}
