package com.lin.consumer.feign.fallback;

import com.lin.common.vo.ApiR;
import com.lin.consumer.feign.RemoteStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author linmengmeng
 * @since 2023/11/12 14:22
 */
@Slf4j
@Component
public class RemoteStudentServiceFallback implements FallbackFactory<RemoteStudentService> {
    @Override
    public RemoteStudentService create(Throwable cause) {
        log.error("RemoteStudentServiceFallback error : {}", cause.getMessage());
        return () -> {
            log.error("sayHello error 接口调用异常");
            return ApiR.fail();
        };
    }
}
