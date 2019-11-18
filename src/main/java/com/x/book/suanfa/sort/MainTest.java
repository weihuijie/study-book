package com.x.book.suanfa.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * main
 *
 * @author whj
 * @date 2019/11/1 11:12
 */
@Slf4j
class MainTest {
    public static void main(String[] args) {
        int[] num = new int[]{1000,2000,5000,10000,20000,50000,100000,200000,500000,1000000};
        for (int i = 0; i < num.length; i++) {
            Integer[] array = SortData.getIntegerArray(0,10000,num[i]);
            sort(array);
        }
    }

    public static void sort(Integer[] array){
        //冒泡排序
//        BubbleSort.sort(array);
        //选择排序
        SelectionSort.sort(array);
    }
}
