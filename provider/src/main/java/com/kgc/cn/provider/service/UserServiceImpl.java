package com.kgc.cn.provider.service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.kgc.cn.common.dto.LoginUser;
import com.kgc.cn.common.dto.User;
import com.kgc.cn.common.dto.UserExample;
import com.kgc.cn.common.service.UserService;
import com.kgc.cn.common.utils.SHAUtils;
import com.kgc.cn.common.vo.UserVo;
import com.kgc.cn.provider.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginUser login(UserVo userVo) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(userVo.getName());
        try {
            //通过用户名查找
            List<User> userList = userMapper.selectByExample(userExample);
            //判断返回的用户是否为空
            /*if (StringUtils.isNotEmpty(userList.get(0).getName())) {
                会出现下标越界
            }*/
            if (!userList.isEmpty()) {
                LoginUser loginUser = new LoginUser();
                BeanUtils.copyProperties(userList.get(0), loginUser);
                return loginUser;
            }
            return null;
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean register(UserVo userVo) {
        User user = new User();
        try {
            BeanUtils.copyProperties(userVo, user);
            //密码加密
            user.setPassword(SHAUtils.stringSha1(user.getPassword()));
            userMapper.insertSelective(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
