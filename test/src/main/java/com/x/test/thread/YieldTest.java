package com.x.test.thread;

/**
 * yield测试
 *
 * @author whj
 * @date 2019/11/7 15:44
 */

public class YieldTest extends Thread {
    public YieldTest(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(this.getName()+"------"+i);
            //当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i==30){
                yield();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new YieldTest("A");
        Thread thread2 = new YieldTest("B");
        thread1.start();
        thread2.start();
    }
}
