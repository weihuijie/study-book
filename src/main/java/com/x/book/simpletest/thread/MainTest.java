package com.x.book.simpletest.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * main
 *
 * @author whj
 * @date 2019/11/1 11:12
 */
@Slf4j
class MainTest {
    public static void main(String[] args) {
        //1、继承Thread实现多线程
        Thread threadAsThread = new ThreadAsThread();
        threadAsThread.start();

        //2、实现Runnable接口实现线程(资源共享，线程不安全)
        Runnable threadAsRunnable = new ThreadAsRunnable();
        Thread threadAsRunn1 = new Thread(threadAsRunnable);
        Thread threadAsRunn2 = new Thread(threadAsRunnable);
        Thread threadAsRunn3 = new Thread(threadAsRunnable);
        threadAsRunn1.start();
        threadAsRunn2.start();
        threadAsRunn3.start();

        //3、实现Callable接口实现线程
        //1)、创建Callable对象
        Callable<Object> callable = new ThreadAsCallable();
        //2)、使用FutureTask来包装MyCallable对象
        FutureTask<Object> futureTask = new FutureTask<Object>(callable);
        Thread threadAsCall = new Thread(futureTask);
        threadAsCall.start();
        //3)、取得新创建的新线程中的call()方法返回的结果
        try {
            Object o = futureTask.get();
            System.out.println("获取线程返回值："+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
