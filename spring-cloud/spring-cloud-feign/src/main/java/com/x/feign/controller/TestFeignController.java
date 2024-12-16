package com.x.feign.controller;

import com.x.feign.client.IHystrixFeignClient;
import com.x.feign.client.ITestFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: whj
 * @date: 2022/4/18
 * @description:
 */
@RestController
@RequestMapping("/feign")
public class TestFeignController {

    @Autowired
    ITestFeignClient testFeignClient;
    @Autowired
    IHystrixFeignClient iHystrixFeignClient;
    /**
     * 测试
     */
    @GetMapping("/test")
    public String test(@RequestParam(required = false) String name) {
        try {
            return testFeignClient.test(name);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 测试
     */
    @GetMapping("/hystrix/hello")
    public String hystrixHello() {
        return iHystrixFeignClient.hello();
    }

}
