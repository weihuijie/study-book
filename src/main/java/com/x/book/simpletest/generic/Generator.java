package com.x.book.simpletest.generic;

/**
 *  泛型接口
 * @author whj
 * @param <T>
 */
public interface Generator<T> {
    /**
     *  获取信息
     * @return T
     */
    T getMsg();
}
