package com.x.book.simpletest.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 线程池创建
 *
 * @author whj
 * @date 2019/11/11 14:25
 */
@Slf4j
public class ThreadPool {
    public static final ExecutorService executorService;
    /**
     *  线程池长期维持的线程数，即使线程处于Idle状态，也不会回收。
     */
    private static final int poolSize = Runtime.getRuntime().availableProcessors();
    /**
     * 可以向线程池提交的任务有两种：Runnable和Callable，二者的区别如下：
     *
     * 方法签名不同，void Runnable.run(), V Callable.call() throws Exception
     * 是否允许有返回值，Callable允许有返回值
     * 是否允许抛出异常，Callable允许抛出异常。
     */
    private static final BlockingQueue<Runnable> queue = new ArrayBlockingQueue(512);
    /**
     * AbortPolicy	抛出RejectedExecutionException
     * DiscardPolicy	什么也不做，直接忽略
     * DiscardOldestPolicy	丢弃执行队列中最老的任务，尝试为当前提交的任务腾出位置
     * CallerRunsPolicy	直接由提交任务者执行这个任务
     */
    private static final RejectedExecutionHandler policy = new ThreadPoolExecutor.AbortPolicy();

    static {
        log.info("线程池创建：poolSize={}",poolSize);
        executorService = new ThreadPoolExecutor(poolSize,poolSize,0,TimeUnit.SECONDS,queue,policy);
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
    }
}
