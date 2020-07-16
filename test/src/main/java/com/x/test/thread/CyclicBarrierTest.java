package com.x.test.thread;

import com.x.test.thread.pool.ThreadPool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 回环栏栅这个类，让所有的线程都去相互等待，直到它们都到达了一个栏栅的点。
 * 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。
 * 叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。
 * 我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。
 *
 * @author whj
 * @date 2019/11/13 14:54
 */

public class CyclicBarrierTest {
    public static void main(String[] args) {
        final int N = 4;
        //CyclicBarrier barrier = new CyclicBarrier(N);
        //如果说想在所有线程写入操作完之后，进行额外的其他操作可以为CyclicBarrier提供Runnable参数
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println(name+"barrier do something");
            }
        });
        for (int i = 0; i < N; i++) {
            ThreadPool.executorService.submit(new Writer(barrier));
        }
    }

    static class Writer implements Runnable{

       CyclicBarrier barrier;
       public Writer(CyclicBarrier barrier){
           this.barrier = barrier;
       }
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name+"开始读写数据");
            try {
                Thread.sleep(4000);
                System.out.println(name+"结束读写数据");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name+"所以线程都读取完毕，开始其他的操作");
        }
    }
}
