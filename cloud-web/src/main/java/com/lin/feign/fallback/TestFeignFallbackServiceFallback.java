package com.lin.feign.fallback;

import com.lin.common.vo.ApiR;
import com.lin.feign.TestFeignFallbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author linmengmeng
 * @since 2023/11/12 14:22
 */
@Slf4j
@Component
public class TestFeignFallbackServiceFallback implements FallbackFactory<TestFeignFallbackService> {
    @Override
    public TestFeignFallbackService create(Throwable cause) {
        log.error("TestFeignFallbackServiceFallback error : {}", cause.getMessage());
        return name -> {
            log.error("sayHello error 接口调用异常-nam:{}", name);
            return ApiR.fail();
        };
    }
}
