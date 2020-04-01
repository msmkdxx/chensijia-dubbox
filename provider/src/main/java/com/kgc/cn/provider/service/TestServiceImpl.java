package com.kgc.cn.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.kgc.cn.common.service.TestService;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void testDubbo() {
        System.out.println("");
    }
}
