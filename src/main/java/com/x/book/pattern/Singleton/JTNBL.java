package com.x.book.pattern.Singleton;

/**
 * 静态内部类
 *
 * @author whj
 * @date 2019/10/15 10:57
 */

public class JTNBL {
    private JTNBL(){};

    private static class NBL{
        private static final JTNBL instance = new JTNBL();
    }
    /**
     * 静态工厂方法
     */
    public static JTNBL getInstance(){
        return NBL.instance;
    }

}
