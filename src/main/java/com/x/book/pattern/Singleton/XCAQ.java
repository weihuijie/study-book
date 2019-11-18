package com.x.book.pattern.Singleton;

/**
 * 线程安全
 *
 * @author whj
 * @date 2019/10/15 10:31
 */

public class XCAQ {
    /**
     * 构造器私有化
     */
    private XCAQ(){};
    /**
     * 初始化实例
     *  volatile 可解决指令重排序
     */
    private volatile static XCAQ instance = null;
    /**
     * 静态工厂方法
     */
    public static XCAQ getInstance(){
        //双重检测机制
        if (null == instance){
            //同步锁
            synchronized (XCAQ.class){
                //双重检测机制
                if (null == instance){
                    instance = new XCAQ();
                }
            }

        }
        return instance;
    }

}
