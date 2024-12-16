package com.x.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author: whj
 * @date: 2022/3/30
 * @description: 添加认证配置类，若不添加则别的服务是注册不进来的
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        // 新版 （Spring Cloud 2.0 以上）的 security 默认启用了 csrf 校验，要在 eurekaServer 端配置 security 的 csrf 校验位 false
        http.csrf().disable();
        super.configure(http);
    }
}
