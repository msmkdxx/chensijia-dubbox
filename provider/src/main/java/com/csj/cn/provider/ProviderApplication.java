package com.csj.cn.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.csj.cn.common","com.csj.cn.provider"})
//应用定义了两个DataSource实例，但是spring boot却要求只有一个。那么有两种办法来解决：
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
