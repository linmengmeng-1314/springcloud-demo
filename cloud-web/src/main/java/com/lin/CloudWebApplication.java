package com.lin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author linmengmeng
 * @since 2023/11/12 16:20
 */
@EnableHystrix
@RefreshScope
@EnableFeignClients
@MapperScan("com.lin.**.mapper")
@SpringBootApplication(scanBasePackages = {"com.lin"})
public class CloudWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudWebApplication.class, args);
    }
}