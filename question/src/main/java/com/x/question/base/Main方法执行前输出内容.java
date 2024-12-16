package com.x.question.base;

/**
 * @author whj
 * @date 2022/10/24
 * @description  在 main() 方法执行前，利用静态块实现输出 “Hello World”
 */
public class Main方法执行前输出内容 {
    static{
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        System.out.println("main");
    }
}
