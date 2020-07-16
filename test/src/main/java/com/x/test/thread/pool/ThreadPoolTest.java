package com.x.test.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 线程池测试
 *
 * @author whj
 * @date 2019/11/11 14:58
 */
@Slf4j
public class ThreadPoolTest {
    private int i;
    public void poolSubmitTest(){
        // Runnable 提交任务
        ThreadPool.executorService.submit(
                new Runnable() {
                    @Override
                    public void run() {
                        log.info("Runnable");
                    }
                }
        );

        // Callable 提交任务
        Future<Object> future = ThreadPool.executorService.submit(
                new Callable<Object>() {
                    @Override
                    public Object call() {
                        if (i == 513){
                            throw new RuntimeException("拒绝线程");
                        }
                        return "Callable";
                    }
                }
        );
        try {
            log.info(future.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        log.info("poolSubmitTest");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            log.info("i={}",i);
            ThreadPoolTest threadPoolTest = new ThreadPoolTest();
            threadPoolTest.i = i;
            threadPoolTest.poolSubmitTest();
        }
    }
}
