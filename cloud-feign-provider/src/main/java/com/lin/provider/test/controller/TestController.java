package com.lin.provider.test.controller;

import com.lin.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 生产者提供接口
 * @author linmengmeng
 * @since 2023/11/8 14:18
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/sayHello")
    public R sayHello(String name) {
        log.info("sayHello-接口调用-name:{}", name);
        String result = "Hello, " + name;
        return R.ok(result);
    }
}
