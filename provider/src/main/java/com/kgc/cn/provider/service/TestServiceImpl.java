package com.kgc.cn.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.kgc.cn.common.dto.UserDto;
import com.kgc.cn.common.service.TestService;
import com.kgc.cn.common.vo.UserVo;
import org.springframework.beans.BeanUtils;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void testDubbo() {
        System.out.println("");
    }

    @Override
    public UserVo getUser() {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setName("zs");
        //男
        userDto.setSex(1);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userDto, userVo);
        return userVo;
    }
}
