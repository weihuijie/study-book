package com.x.test.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池创建
 *
 * @author whj
 * @date 2019/11/11 14:25
 */
@Slf4j
public class ThreadPool {
    public ExecutorService executorService;
    /**
     *  线程池长期维持的线程数，即使线程处于Idle状态，也不会回收。
     */
    private static int POOL_SIZE = Runtime.getRuntime().availableProcessors();
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

    private static String threadPoolName = "默认线程组";

    static {
//        createThreadPool();
    }

    public ThreadPool(){
        this(ThreadPool.threadPoolName);
    }
    public ThreadPool(String threadPoolName){
        this(threadPoolName,POOL_SIZE);
    }
    public ThreadPool(String threadPoolName,int poolSize){
        ThreadPool.threadPoolName = threadPoolName;
        ThreadPool.POOL_SIZE = poolSize;
        createThreadPool();
    }

    public void shutdown(){
        executorService.shutdown();
    }
    private void createThreadPool(){
        log.info("线程池创建：poolSize={},threadPoolName={}",POOL_SIZE,threadPoolName);
        executorService = new ThreadPoolExecutor(POOL_SIZE,POOL_SIZE,0,TimeUnit.SECONDS,queue,new ThreadFactoryImpl(ThreadPool.threadPoolName),policy);
    }

    static class ThreadFactoryImpl implements ThreadFactory {
        private final String namePrefix;
        private final AtomicInteger nextId = new AtomicInteger(1);
        // 定义线程组名称，在jstack问题排查时，非常有帮助
        ThreadFactoryImpl (String whatFeatureOfGroup) {
            namePrefix = "线程租：" + whatFeatureOfGroup + "-Worker-";
        }
        @Override
        public Thread newThread(Runnable task) {
            String name = namePrefix + nextId.getAndIncrement();
            return new Thread(null, task, name);
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool("Main");
    }
}
