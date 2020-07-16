package com.x.test.thread;

import java.util.concurrent.Callable;

/**
 * 实现Callable接口实现线程
 *
 * @author whj
 * @date 2019/11/7 11:37
 */

public class ThreadAsCallable implements Callable<Object> {
    private String s = "实现Callable接口实现线程";
    @Override
    public Object call() throws Exception {
        return s;
    }
}
