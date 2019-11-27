package com.x.book.suanfa.sort;

import cn.hutool.core.convert.Convert;

import java.util.Arrays;

/**
 * 插入排序
 *     插入排序的代码实现虽然没有冒泡排序和选择排序那么简单粗暴，但它的原理应该是最容易理解的了，因为只要打过扑克牌的人都应该能够秒懂。
 *     插入排序是一种最简单直观的排序算法，它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *     插入排序和冒泡排序一样，也有一种优化算法，叫做拆半插入。
 *
 *     将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 *     从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
 *     （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 *
 * @author whj
 * @date 2019/11/19 13:45
 */

public class InsertSort implements Sort{

    public static int[] sort2(int[] arg){
        Long start = System.currentTimeMillis();
        //复制数组，不改变参数内容
        int[] array = Arrays.copyOf(arg,arg.length);
        int temp;
        int n;
        //要插入的数的个数
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            n = i;
            for (int j = i-1; j >= 0; j--) {
                if (array[n] < array[j]) {
                    array[i] = array[j];
                    array[j] = temp;
                    n--;
                }
            }
        }
        System.out.println(System.currentTimeMillis()-start);
        return array;
    }

    public static int[] sort(int[] arg){
        Long start = System.currentTimeMillis();
        //复制数组，不改变参数内容
        int[] array = Arrays.copyOf(arg,arg.length);

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j>0 && array[j-1] > temp){
                array[j] = array[j-1];
                j--;
            }
            if (j != i){
                array[j] = temp;
            }
        }

        System.out.println(System.currentTimeMillis()-start);
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Convert.toStr(sort(SortData.getIntArray(0,100000000,1000000))));;
    }
}
