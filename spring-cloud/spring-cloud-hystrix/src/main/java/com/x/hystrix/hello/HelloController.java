package com.x.hystrix.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author: whj
 * @date: 2022/3/31
 *
 * @description:  测试 Controller
*/
@RestController
@RequestMapping("/hystrix")
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello from server";
    }
}

