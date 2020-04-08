package com.csj.cn.provider.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.csj.cn.common.enums.ErrorEnums;
import com.csj.cn.common.exception.ServiceException;
import com.csj.cn.common.vo.LoginUser;
import com.csj.cn.common.dto.User;
import com.csj.cn.common.dto.UserExample;
import com.csj.cn.common.service.UserService;
import com.csj.cn.common.utils.SHAUtils;
import com.csj.cn.provider.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginUser login(String phone, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneEqualTo(phone);
        //将前端传的密码加密
        String pwd = SHAUtils.stringSha1(password);
        //通过用户名查找
        List<User> userList = userMapper.selectByExample(userExample);
        User user = userList.get(0);
        if (!ObjectUtils.isEmpty(user)) {
            //判断用户名密码是否正确
            if (user.getPhone().equals(phone) && user.getPassword().equals(pwd)) {
                LoginUser loginUser = new LoginUser();
                BeanUtils.copyProperties(user, loginUser);
                return loginUser;
            }
            throw new ServiceException(ErrorEnums.ERROR_USER);
        }
        throw new ServiceException(ErrorEnums.ERROR_USER);
    }

    @Override
    public boolean register(LoginUser userVo) {
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
