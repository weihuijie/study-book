package com.x.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: whj
 * @date: 2022/3/30
 *  注解@RefreshScope必须加，否则客户端会收到服务端的更新消息，但是更新不了，因为不知道更新哪里的
*/
@EnableDiscoveryClient
@RestController
@SpringBootApplication
@RefreshScope
public class ConfigClientApplication {
    @Value("${spring.hi}")
    private String accesskey;

    @RequestMapping("/hi")
    public String hi(){
        return accesskey;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
