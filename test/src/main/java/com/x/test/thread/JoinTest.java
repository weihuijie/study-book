package com.x.test.thread;

/**
 * join 测试
 *
 * @author whj
 * @date 2019/11/7 14:48
 */

public class JoinTest extends Thread {
    private String name;
    public JoinTest(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+",线程开始运行");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程"+name+"运行："+i);
            try {
                sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+",线程结束运行");
    }

    public static void main(String[] args) {
        System.out.println("主线程开始运行");
        Thread thread1 = new JoinTest("A");
        Thread thread2 = new JoinTest("B");
        thread1.start();
        thread2.start();

        //加入join,子线程运行结束，主线程才结束。
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束运行");
    }
}
