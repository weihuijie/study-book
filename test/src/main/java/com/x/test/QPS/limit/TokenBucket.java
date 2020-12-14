package com.x.test.QPS.limit;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: weihuijie
 * @date: 2020/9/1
 * @description: 令牌桶
 *
 * 生成令牌的速度是恒定的，而请求去拿令牌是没有速度限制的。
 * 这意味，面对瞬时大流量，该算法可以在短时间内请求拿到大量令牌，而且拿令牌的过程并不是消耗很大的事情。（有一点生产令牌，消费令牌的意味）
 *
 * 不论是对于令牌桶拿不到令牌被拒绝，还是漏桶的水满了溢出，都是为了保证大部分流量的正常使用，而牺牲掉了少部分流量，这是合理的，
 * 如果因为极少部分流量需要保证的话，那么就可能导致系统达到极限而挂掉，得不偿失。
 */
public class TokenBucket {
    private static long time = System.currentTimeMillis();
    private static long creatTokenRate = 30;
    private static long bucketSize = 100;
    // 当前令牌数量
    private static long bucketNow = 0;

    public static boolean grant(){
        long now = System.currentTimeMillis();
        //令牌个数
        long tokenNum = (now - time) * creatTokenRate;
        bucketNow = Math.min(bucketSize,bucketNow+tokenNum);
        System.out.println(bucketNow);
        time = now;
        if (bucketNow <= 0) {
            return false;
        }else {
            --bucketNow;
            return true;
        }
    }


    public static void main(String[] args) {
        AtomicInteger exe = new AtomicInteger(0);
        AtomicInteger limit = new AtomicInteger(0);
        for (int i = 0; i < 5000; i++) {
            new Thread( () ->{
                if (grant()){
                    System.out.println("执行");
                    exe.set(exe.get()+1);
                }else {
                    System.out.println("限流");
                    limit.set(limit.get()+1);
                }
            }
            ).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行："+exe.get()+"---限流："+limit.get());
    }

}
