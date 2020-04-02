package com.kgc.cn.consumer.controller;

import com.kgc.cn.common.dto.Users;
import com.kgc.cn.common.service.UsersService;
import com.kgc.cn.consumer.utils.ReturnResult;
import com.kgc.cn.consumer.utils.ReturnResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户")
@RestController
@RequestMapping(value = "/users")
@Log4j
public class UsersController {
    //private final static Logger logger = LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private UsersService usersService;

    @ApiOperation(value = "注册")
    @GetMapping(value = "/register")
    public ReturnResult register(@Validated Users users) {
        boolean isRegister = usersService.register(users);
        if (isRegister) return ReturnResultUtils.returnSucess();

        return ReturnResultUtils.returnFail(1, "注册失败");
    }

}
