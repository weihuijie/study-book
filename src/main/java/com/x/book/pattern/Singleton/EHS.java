package com.x.book.pattern.Singleton;

/**
 * 饿汉式
 *
 * @author whj
 * @date 2019/10/15 10:31
 */

public class EHS {
    /**
     * 构造器私有化
     */
    private EHS(){};
    /**
     * 初始化实例
     */
    private static EHS instance = new EHS();
    /**
     * 静态工厂方法
     */
    public static EHS getInstance(){
        return instance;
    }

}
