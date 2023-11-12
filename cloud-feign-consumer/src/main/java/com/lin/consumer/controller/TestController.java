package com.lin.consumer.controller;

import cn.hutool.json.JSONUtil;
import com.lin.common.vo.ApiR;
import com.lin.common.vo.R;
import com.lin.consumer.feign.RemoteStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试
 * @author linmengmeng
 * @since 2023/11/8 14:18
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private RemoteStudentService remoteStudentService;

    @GetMapping("/sayHello")
    public R sayHello() {
        log.info("sayHello。。。。。。");
        ApiR apiR = remoteStudentService.queryList();
        log.info("接口调用结果-apiR:{}", JSONUtil.toJsonStr(apiR));
        return R.ok();
    }
}
