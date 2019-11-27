package com.x.book.suanfa.sort;

import cn.hutool.core.convert.Convert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 数组数据
 *
 * @author whj
 * @date 2019/11/16 15:39
 */

public class SortData {
    private static final int min = 0;
    private static final int max = 10;
    private static final int length = 10;

    /**
     *  获取整数数组
     * @param min  最小值
     * @param max  最大值
     * @param length  长度
     * @return
     */
    public static int[] getIntArray(int min, int max, int length) {

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] =getRandomint(min,max);
        }
        System.out.println("生成数组，长度："+length);
        return array;
    }
    public static int[] getIntArray(){
        return getIntArray(min,max, length);
    }

    /**
     *  获取随机数
     */
    public static int getRandomint(int min, int max){
        return (int)(Math.random()*max+min);
    }
    public static void main(String[] args) {
        System.out.println(Convert.toStr(SortData.getIntArray()));
    }
}
