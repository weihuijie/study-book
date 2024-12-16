package com.x.feign.client;

import org.springframework.stereotype.Component;

/**
 * @author: whj
 * @date: 2022/4/18
 * @description: Feign失败配置
 */
@Component
public class TestFeignClientFallback implements ITestFeignClient{

    @Override
    public String test(String name) {
        return "test请求失败，请重试："+name;
    }
}
