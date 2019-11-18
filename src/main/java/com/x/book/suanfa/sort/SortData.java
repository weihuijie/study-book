package com.x.book.suanfa.sort;

import cn.hutool.core.convert.Convert;

import java.util.Arrays;
import java.util.List;

/**
 * 数组数据
 *
 * @author whj
 * @date 2019/11/16 15:39
 */

public class SortData {
    private static final Integer min = 0;
    private static final Integer max = 10;
    private static final Integer length = 10;

    /**
     *  获取整数数组
     * @param min  最小值
     * @param max  最大值
     * @param length  长度
     * @return
     */
    public static Integer[] getIntegerArray(int min, int max, int length) {

        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] =getRandomInteger(min,max);
        }
        System.out.println("生成数组，长度："+length);
        return array;
    }
    public static Integer[] getIntegerArray(){
        return getIntegerArray(min,max, length);
    }

    /**
     * 获取整数list
     *@param min  最小值
     *@param max  最大值
     *@param length  长度
     * @return
     */
    public static List<Integer> getIntegerList(int min, int max, int length){
        return Arrays.asList(getIntegerArray(min,max,length));
    }
    public static List<Integer> getIntegerList(){
        return  getIntegerList(min,max, length);
    }


    /**
     *  获取随机数
     */
    public static Integer getRandomInteger(int min, int max){
        return (int)(Math.random()*max+min);
    }
    public static void main(String[] args) {
        System.out.println(Convert.toStr(SortData.getIntegerArray()));
    }
}
