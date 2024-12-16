package com.x.zipkin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whj
 * @date 2022/4/22
 * @description
 */
@RestController
@RequestMapping("/zipkin")
public class ZipkinTestController {

    @RequestMapping("/test")
    public String testZipkin(){
        System.out.println("Zipkin 测试");
        return "success";
    }
}
