package com.x.book.simpletest.thread;

import cn.hutool.core.date.DateUtil;
import com.x.book.simpletest.thread.pool.ThreadPool;
import sun.util.locale.LocaleUtils;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch是一个异步辅助类，它能让一个和多个线程处于等待状态，直到其他线程完成了一些列操作。
 *
 * @author whj
 * @date 2019/11/13 14:17
 */

public class CountDownLautchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        ThreadPool.executorService.submit(() -> {
            System.out.println("子线程1开始执行");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程1执行结束");
            //将count值减1
            latch.countDown();
        });
        new Thread(() -> {
            System.out.println("子线程2开始执行");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程2执行结束");
            //将count值减1
            latch.countDown();
        }).start();

        new Thread(() -> {
            while (true){
                System.out.println(DateUtil.date());
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
            //latch.await();
            //和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
            latch.await(2,TimeUnit.MINUTES);
            System.out.println("所有子线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
