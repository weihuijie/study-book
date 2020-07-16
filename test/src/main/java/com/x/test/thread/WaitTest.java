package com.x.test.thread;

/**
 * wait测试
 *
 * @author whj
 * @date 2019/11/7 15:52
 */

public class WaitTest implements Runnable {
    private String name;
    private Object prev;
    private Object self;

    public WaitTest(String name,Object prev,Object self){
        this.name = name;
        this.prev = prev;
        this.self = self;
    }
    @Override
    public void run() {
        int count = 10;
        while (count > 0){
            synchronized (prev){
                synchronized (self){
                    self.notify();
                    System.out.println(name);
                    count--;
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Thread A = new Thread(new WaitTest("A",c,a));
        Thread B = new Thread(new WaitTest("B",a,b));
        Thread C = new Thread(new WaitTest("C",b,c));

        A.start();
        Thread.sleep(100);
        B.start();
        Thread.sleep(100);
        C.start();
        Thread.sleep(100);
    }
}
