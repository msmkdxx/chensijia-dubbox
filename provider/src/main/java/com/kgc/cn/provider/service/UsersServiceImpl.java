package com.kgc.cn.provider.service;

import com.kgc.cn.common.dto.Users;
import com.kgc.cn.common.service.UsersService;
import com.kgc.cn.common.utils.SHAUtils;
import com.kgc.cn.provider.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 注册
     * @param users
     * @return
     */
    @Override
    public boolean register(Users users) {
        try {
            //密码加密
            users.setPassword(SHAUtils.stringSha1(users.getPassword()));
            usersMapper.insertSelective(users);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
