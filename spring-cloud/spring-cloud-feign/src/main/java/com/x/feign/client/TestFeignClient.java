package com.x.feign.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author: whj
 * @date: 2022/4/18
 * @description: feign 实现类
 */
@RestController
public class TestFeignClient implements ITestFeignClient{

    @Override
    @RequestMapping(value = "/test")
    public String test(String name) throws Exception{
        if (!Objects.equals(name,"whj")){
            throw new Exception("服务调用失败,请重试");
        }
        return name;
    }

}
