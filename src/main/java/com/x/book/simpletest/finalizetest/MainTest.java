package com.x.book.simpletest.finalizetest;

/**
 * main
 *
 * @author whj
 * @date 2019/11/1 11:12
 */

class MainTest {
    public static void main(String[] args) {
        Person p = new Person("测试",1);
        //将对象引用置空
        p = null;
        //强制清理
//        System.gc();
        //另一种方式
        Runtime run = Runtime.getRuntime();
        run.gc();
    }
}
