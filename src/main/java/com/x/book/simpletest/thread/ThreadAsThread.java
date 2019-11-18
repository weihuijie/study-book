package com.x.book.simpletest.thread;

import javax.naming.Name;

/**
 * 继承Thread实现多线程
 *
 * @author whj
 * @date 2019/11/7 10:17
 */

public class ThreadAsThread extends Thread {
    private String name = "继承Thread实现线程";
    public ThreadAsThread(){
    }
    public ThreadAsThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }
}
