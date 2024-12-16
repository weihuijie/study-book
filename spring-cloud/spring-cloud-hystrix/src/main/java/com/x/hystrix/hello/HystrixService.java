package com.x.hystrix.hello;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/**
 * @author: whj
 * @date: 2022/3/31
 *
 * @description: Hystrix 测试
*/
@Service
public class HystrixService {

    /**
     * 在hi()方法中加入了HystrixCommand注解，在注解中我们提供了一个名为“fallback”的字段，这个方法指向的是同一个类中的fallback()方法，当hi()方法调用失败的时候就会自动转而执行fallback()方法。
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public String hi() {
        return new RestTemplate().getForObject("http://localhost:8860/hystrix/hello", String.class);
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public String noHi() {
        return new RestTemplate().getForObject("http://localhost:9999/hello", String.class);
    }

    public String fallback() {
        return "fallback";
    }
}

