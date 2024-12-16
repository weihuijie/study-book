package com.example.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author whj
 * @date 2022/4/19
 * @description
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @RequestMapping("/test/hystrix/hello")
    public String ribbonTest(){
       return restTemplate.getForObject("http://spring-cloud-hystrix/hi", String.class);
    }
}
