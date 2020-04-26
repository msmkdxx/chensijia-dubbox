package com.csj.cn.common.utils;

import java.util.UUID;

/**
 * @Description TODO 随机数生成
 * @Author chensijia
 * @Date 2020/4/249:39
 */
public class CommonUtils {
    public static String generatorUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }
}
