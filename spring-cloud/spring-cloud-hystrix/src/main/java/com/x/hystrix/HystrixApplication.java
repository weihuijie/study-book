package com.x.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: whj
 * @date: 2022/3/31
 *
 *  注释： @EnableHystrix   开启 hystrix 服务
 *         @EnableHystrixDashboard  开启 hystrix 服务监控
 *
 *
*/

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

}
