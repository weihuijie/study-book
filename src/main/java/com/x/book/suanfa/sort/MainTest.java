package com.x.book.suanfa.sort;

import cn.hutool.core.date.DateUtil;
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
        int[] num = new int[]{1000,10000,100000,200000,500000,600000,700000,800000,900000,1000000,10000000,100000000};
        for (int i = 0; i < num.length; i++) {
            int[] array = SortData.getIntArray(0,100000,num[i]);
            sort(array);
            System.out.println(DateUtil.date());
        }
    }

    public static void sort(int[] array){
        //冒泡排序
//        BubbleSort.sort(array);
        //选择排序
//        SelectionSort.sort(array);
        //插入排序
//        InsertSort.sort2(array);
        //希尔排序
        ShellSort.sort(array);
        //归并排序
//        MergeSort.sort(array);
    }
}
