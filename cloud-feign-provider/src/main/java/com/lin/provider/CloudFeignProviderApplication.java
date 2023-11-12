package com.lin.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author linmengmeng
 * @since 2023/11/12 16:20
 */
@RefreshScope
@EnableFeignClients
@MapperScan("com.lin.**.mapper")
@SpringBootApplication(scanBasePackages = {"com.lin"})
public class CloudFeignProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudFeignProviderApplication.class, args);
    }
}