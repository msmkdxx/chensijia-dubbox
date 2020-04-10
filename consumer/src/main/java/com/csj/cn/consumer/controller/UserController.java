package com.csj.cn.consumer.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.csj.cn.common.utils.RedisUtils;
import com.csj.cn.common.vo.LoginUser;
import com.csj.cn.common.enums.ErrorEnums;
import com.csj.cn.common.exception.ServiceException;
import com.csj.cn.common.service.UserService;
import com.csj.cn.consumer.conf.LoginReqired;
import com.csj.cn.consumer.utils.ReturnResult;
import com.csj.cn.consumer.utils.ReturnResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户")
@RestController
@RequestMapping(value = "/user")
@Log4j
public class UserController {
    @Reference
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "登录")
    @PostMapping(value = "/login")
    public ReturnResult login(@RequestParam String phone, @RequestParam String password, HttpServletRequest request) {
        //判断前端传的参数是否为空
        if (StringUtils.isNotEmpty(phone) && StringUtils.isNotEmpty(password)) {
            LoginUser loginUser = userService.login(phone, password);
            String token = request.getSession().getId();
            //将token和用户信息存入缓存
            try {
                redisUtils.set(token, JSONObject.toJSONString(loginUser));
                return ReturnResultUtils.returnSucess(token);
            } catch (Exception e) {
                e.printStackTrace();
                return ReturnResultUtils.returnFail(3, "缓存失败！");
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

    @ApiOperation(value = "退出登录", notes = "2表示exit error")
    @LoginReqired
    @GetMapping(value = "/exit")
    public ReturnResult exit(@RequestParam String token) {
        try {
            redisUtils.del(token);
            return ReturnResultUtils.returnSucess();
        } catch (Exception e) {
            log.error("redis删除" + token + "异常");
            return ReturnResultUtils.returnFail(2, "exit error");
        }
    }
}
