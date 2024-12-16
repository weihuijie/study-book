package com.x.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

/**
 * @author whj
 * @date 2022/4/22
 *
 * @description 公共过滤器
*/
@Component
public class CommonFilter extends ZuulFilter {

    /**
     * 前置过滤器，在请求被路由之前执行
     *      pre pre-routing过滤，路由前过滤
     *      routing 在路由请求时被调用
     *      post routing和error过滤器之后被调用
     *      error 处理请求发生错误的时候调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序,数字越大，优先级越低
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 该过滤器是否需要被执行,此处为true，说明需要过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
 
    @Override
    public Object run() {
        System.out.println("执行业务");
        return null;
    }
}