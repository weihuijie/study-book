package com.x.book.suanfa.sort;

import jdk.nashorn.internal.runtime.arrays.ArrayData;

import java.util.Arrays;

/**
 * 选择排序
 *    首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 *    再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *    重复第二步，直到所有元素均排序完毕。
 * @author whj
 * @date 2019/11/18 15:20
 */

public class SelectionSort {
    public static int[] sort(int[] arg){
        Long start = System.currentTimeMillis();
        //复制数组，不改变参数内容
        int[] array = Arrays.copyOf(arg,arg.length);
        //选择最小值位置
        int min = 0;
        int size = array.length;
        for (int i = 0; i < size-1; i++) {
            min = i;
            for (int j = i+1; j < size; j++) {
                if (array[j] <  min){
                    min = j;
                }
            }
            if (i != min){
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
        System.out.println(System.currentTimeMillis()-start);
        return array;
    }

    public static void main(String[] args) {
        sort(SortData.getIntArray(0,100000000,10000000));
    }
}
