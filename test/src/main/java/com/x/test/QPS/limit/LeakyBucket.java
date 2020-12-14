package com.x.test.QPS.limit;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: weihuijie
 * @date: 2020/9/1
 * @description: 桶漏限流
 *有一个固定的桶，进水的速率是不确定的，但是出水的速率是恒定的，当水满的时候是会溢出的。
 *
 */
public class LeakyBucket {
    // 时间刻度
    private static long timeStamp = System.currentTimeMillis();
    // 桶里面现在的水
    private static long water = 0;
    // 桶的大小
    private static long size = 100;
    // 出水速率
    private static long rate = 30;

    public static boolean grant(){
        // 计算出水的数量
        long now = System.currentTimeMillis();
        long out = (now - timeStamp)/10 * rate;
        // 漏水后剩余
        water = Math.max(0,water - out);
        timeStamp = now;
        if ((water +1)< size){
            ++water;
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        AtomicInteger exe = new AtomicInteger(0);
        AtomicInteger limit = new AtomicInteger(0);
        for (int i = 0; i < 50; i++) {
            if (i%200 == 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
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
        System.out.println("执行："+exe.get()+"---限流："+limit.get());
    }

}
