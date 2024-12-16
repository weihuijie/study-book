package com.x.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: whj
 * @date: 2022/4/18
 * @FeignClient("服务名")注解来绑定该接口对应的服务
 * 参数可以写在方法里。
 * 如：feignTest(@RequestHeader("name")String name)
 *     feignTest(@RequestBody User user)
 *  @FeignClient(name = "服务名",fallback = fallback.class)
 *  fallback使用Hystrix,当 服务不可用时，对服务降级，并返回友好提示
 */
@FeignClient(value = "spring-cloud-feign",fallback = TestFeignClientFallback.class)
public interface ITestFeignClient {

    /**
     * @author: whj
     * @date: 2022/4/18
     *
     * @description: 服务中方法的映射路径
    */
    @RequestMapping(value = "/test")
    String test(@RequestParam("name")String name) throws Exception;

}
