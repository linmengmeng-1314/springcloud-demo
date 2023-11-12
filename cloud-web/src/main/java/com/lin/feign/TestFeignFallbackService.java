package com.lin.feign;

import com.lin.common.config.FeignSupportConfig;
import com.lin.common.constant.ServiceNameConstants;
import com.lin.common.vo.ApiR;
import com.lin.feign.fallback.TestFeignFallbackServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author linmengmeng
 * @since 2023/11/12 14:12
 */
@FeignClient(contextId = "TestFeignFallbackService", name = ServiceNameConstants.OPERATION_SERVICE
        , configuration = FeignSupportConfig.class, fallbackFactory = TestFeignFallbackServiceFallback.class)
public interface TestFeignFallbackService {

    @RequestMapping("/sayHello")
    ApiR sayHello(String name);
}
