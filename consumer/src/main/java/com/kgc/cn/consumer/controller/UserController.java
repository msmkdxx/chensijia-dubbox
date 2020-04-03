package com.kgc.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.kgc.cn.common.vo.LoginUser;
import com.kgc.cn.common.enums.ErrorEnums;
import com.kgc.cn.common.exception.ServiceException;
import com.kgc.cn.common.service.UserService;
import com.kgc.cn.common.utils.SHAUtils;
import com.kgc.cn.consumer.utils.RedisUtils;
import com.kgc.cn.consumer.utils.ReturnResult;
import com.kgc.cn.consumer.utils.ReturnResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Reference
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "登录")
    @PostMapping(value = "/login")
    public ReturnResult login(@Validated LoginUser userVo, HttpServletRequest request) {
        //判断前端传的参数是否为空
        if (!ObjectUtils.isEmpty(userVo)) {
            //将前端传的密码加密
            String pwd = SHAUtils.stringSha1(userVo.getPassword());
            LoginUser loginUser = userService.login(userVo);
            if (ObjectUtils.isEmpty(loginUser)) {
                //用户为空异常
                throw new ServiceException(ErrorEnums.EMPTY_USER_NAME);
            } else if (!pwd.equals(loginUser.getPassword())) {
                //密码错误异常
                throw new ServiceException(ErrorEnums.ERROR_USER_PWD);
            } else {
                String token = request.getSession().getId();
                //将token和用户信息存入缓存
                try {
                    redisUtils.set(token, JSONObject.toJSONString(loginUser));
                } catch (Exception e) {
                    e.printStackTrace();
                    return ReturnResultUtils.returnFail(3, "缓存失败！");
                }
                return ReturnResultUtils.returnSucess(token);
            }
        } else {
            //参数为空异常
            throw new ServiceException(ErrorEnums.EMPTY_PARAM);
        }
    }

    @ApiOperation(value = "注册")
    @GetMapping(value = "/register")
    public ReturnResult register(@Validated LoginUser userVo) {
        boolean isRegister = userService.register(userVo);
        if (isRegister) return ReturnResultUtils.returnSucess();

        return ReturnResultUtils.returnFail(1, "注册失败");
    }
}
