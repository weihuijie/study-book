package com.x.test.lambda;

/**
 * @author: weihuijie
 * @date: 2020/7/17
 * @description: lanbda 测试
 * Lambda	本质上是一个函数，虽然它不属于某个特定的类，但具备参数列表、函数主体、返回类型，甚至 能够抛出异常
 * lambda 和接口相关
 */
public class LambdaTest {

    public static void main(String[] args) {
        StringNum s = () -> 1;
        System.out.println(s.stringNum());
    };

}
