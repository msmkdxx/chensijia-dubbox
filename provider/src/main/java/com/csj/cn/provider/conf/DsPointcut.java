package com.csj.cn.provider.conf;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/1618:57
 */
public class DsPointcut {
    @Pointcut("execution(public * com.csj.cn.provider.service.*.*(..))")
    public void selectPointCut(){

    }
}
