package com.x.book;

import lombok.extern.slf4j.Slf4j;

/**
 * main
 *
 * @author whj
 * @date 2019/11/1 11:12
 */
@Slf4j
class LittleDemo {
    public static void main(String[] args) {
        //位移测试
        wyfTest();
    }

    /**
     *  位移测试
     *  java中有三种移位运算符
     *
     *   <<      :     左移运算符，num << 1,相当于num乘以2
     *
     *   >>      :     右移运算符，num >> 1,相当于num除以2
     *
     *   >>>    :     无符号右移，忽略符号位，空位都以0补齐
     *
     */
    public static void wyfTest(){
        int i = 8;
        System.out.println(8 >> 1); // 4
        System.out.println(8 >>> 1);// 4
        System.out.println(8 << 1);// 16
        System.out.println(-8 >> 1); // -4
        System.out.println(-8 >>> 1);// 2147483644
        System.out.println(-8 << 1);//  -16
    }
}
