package com.x.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author whj
 * @date 2022/4/19
 * @description
 */
@FeignClient(value = "spring-cloud-hystrix")
public interface IHystrixFeignClient {
    /**
     * @author whj
     * @date 2022/4/18
     *
     * @description 服务中方法的映射路径
     */
    @RequestMapping(value = "/hystrix/hello")
    String hello();
}
