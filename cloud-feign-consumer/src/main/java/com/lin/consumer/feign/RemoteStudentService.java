package com.lin.consumer.feign;

import com.lin.common.config.FeignSupportConfig;
import com.lin.common.constant.ServiceNameConstants;
import com.lin.common.vo.ApiR;
import com.lin.consumer.feign.fallback.RemoteStudentServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author linmengmeng
 * @since 2023/11/12 14:12
 */
@FeignClient(contextId = "RemoteStudentService", name = ServiceNameConstants.PROVIDER_SERVICE
        , configuration = FeignSupportConfig.class, fallbackFactory = RemoteStudentServiceFallback.class)
public interface RemoteStudentService {

    @GetMapping ("/student/queryList")
    ApiR queryList();
}
