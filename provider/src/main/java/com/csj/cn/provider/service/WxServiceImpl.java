package com.csj.cn.provider.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.csj.cn.common.dto.*;
import com.csj.cn.common.service.WxService;
import com.csj.cn.common.vo.LoginUser;
import com.csj.cn.provider.mapper.UserMapper;
import com.csj.cn.provider.mapper.WxAndUserMapper;
import com.csj.cn.provider.mapper.WxMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/616:47
 */
@Service
public class WxServiceImpl implements WxService {
    @Autowired
    private WxMapper wxMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private WxAndUserMapper wxAndUserMapper;

    @Override
    public boolean wxLogin(LoginUser loginUser) {
        try {
            //查询关系表中是否有数据
            WxAndUserExample wxAndUserExample = new WxAndUserExample();
            wxAndUserExample.createCriteria().andOpenidEqualTo(loginUser.getOpenid());
            List<WxAndUser> wxAndUsers = wxAndUserMapper.selectByExample(wxAndUserExample);
            if (CollectionUtils.isNotEmpty(wxAndUsers)) {
                //已关联
                return true;
            } else {
                //无关联
                //查询wx表中是否有数据
                WxExample wxExample = new WxExample();
                wxExample.createCriteria().andOpenidEqualTo(loginUser.getOpenid());
                List<Wx> wxes = wxMapper.selectByExample(wxExample);
                if (wxes.isEmpty()) {
                    Wx wx = new Wx();
                    BeanUtils.copyProperties(loginUser, wx);
                    wxMapper.insertSelective(wx);
                }
                //通过手机号查询手机账户表中是否有数据
                UserExample userExample = new UserExample();
                userExample.createCriteria().andPhoneEqualTo(loginUser.getPhone());
                List<User> users = userMapper.selectByExample(userExample);
                //用户表中有数据，关联
                if (CollectionUtils.isNotEmpty(users)) {
                    WxAndUser wxAndUser = new WxAndUser();
                    BeanUtils.copyProperties(loginUser, wxAndUser);
                    wxAndUserMapper.insertSelective(wxAndUser);
                    return true;
                }
                //用户表中无数据，直接微信登录
                return true;
            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return false;
    }
}
