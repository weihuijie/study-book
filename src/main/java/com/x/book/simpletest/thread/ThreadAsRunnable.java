package com.x.book.simpletest.thread;

/**
 * 实现Runnable接口实现线程
 *
 * @author whj
 * @date 2019/11/7 10:24
 */

public class ThreadAsRunnable implements Runnable {
    private String name = "继承Runnable接口实现线程";
    private volatile Integer num = 100;
    public ThreadAsRunnable(){}
    public ThreadAsRunnable(String name,Integer num){
        this.name = name;
        this.num = num;
    }
    @Override
    public void run() {
        System.out.println(name);
        synchronized (this) {
            while (num > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num--;
                System.out.println(num);
            }
        }
    }
}
