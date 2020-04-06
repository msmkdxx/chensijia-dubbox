package com.csj.cn.provider.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.csj.cn.provider.mapper")
public class MybatisConfig {
}
