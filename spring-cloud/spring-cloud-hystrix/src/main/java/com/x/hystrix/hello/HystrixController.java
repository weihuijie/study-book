package com.x.hystrix.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @Autowired
    HystrixService hystrixService;

    @RequestMapping("/hi")
    public String hi() {
        return hystrixService.hi();
    }

    @RequestMapping("/noHi")
    public String noHi() {
        return hystrixService.noHi();
    }
}


