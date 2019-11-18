package com.x.book.simpletest.thread;

import com.x.book.simpletest.thread.pool.ThreadPool;

import java.util.concurrent.Semaphore;

/**
 * Semaphore翻译成字面意思为 信号量，Semaphore可以控同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
 *
 * @author whj
 * @date 2019/11/13 15:10
 */

public class SemaphoreTest{
    public static void main(String[] args) {
        //参数permits表示许可数目，即同时可以允许多少线程进行访问
        //这个多了一个参数fair表示是否是公平的，即等待时间越久的越先获取许可
        Semaphore semaphore = new Semaphore(3,true);

        for (int i = 0; i < 10; i++) {
            new Thread(new Worker(semaphore,i)).start();
        }
    }

    static class Worker implements Runnable{
        Semaphore semaphore;
        int num;

        public Worker(Semaphore semaphore,int num){
            this.semaphore = semaphore;
            this.num = num;
        }
        @Override
        public void run() {
            try {
                //acquire()用来获取一个许可，若无许可能够获得，则会一直等待，直到获得许可。
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器生产。。。");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放出机器");
                //release()用来释放许可。注意，在释放许可之前，必须先获获得许可。
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
