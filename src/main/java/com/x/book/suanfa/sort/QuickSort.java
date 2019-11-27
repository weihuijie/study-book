package com.x.book.suanfa.sort;

import cn.hutool.core.convert.Convert;

import java.util.Arrays;

/**
 * 快速排序
 *      快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
 *      快速排序又是一种分而治之思想在排序算法上的典型应用。本质上来看，快速排序应该算是在冒泡排序基础上的递归分治法。
 *
 *      步骤：
 *          1、从数列中挑出一个元素，称为 “基准”（pivot）;
 *          2、重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 *              在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 *          3、递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
 * @author whj
 * @date 2019/11/21 15:13
 */

public class QuickSort  {
    public static int[] sort(int[] arg){
        Long start = System.currentTimeMillis();
        //复制数组，不改变参数内容
        int[] array = Arrays.copyOf(arg,arg.length);

        array = quickSort(array,0,array.length-1);
        System.out.println(System.currentTimeMillis()-start);
        return array;
    }

    public static int[] quickSort(int[] array,int left,int right){
        if (left < right){
            int index = partition(array,left,right);
            quickSort(array,left,index -1);
            quickSort(array,index + 1,right);
        }
        return array;
    }

    private static int partition(int[] array, int left, int right) {
        //设置基准值
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (array[i] < array[pivot]){
                swap(array,i,index);
                index++;
            }
        }
        swap(array,pivot,index -1);
        return index-1;
    }

    private static void swap(int[] array, int i, int index) {
        int tmp = array[i];
        array[i] = array[index];
        array[index] = tmp;
    }

    public static void main(String[] args) {
        int[] array = SortData.getIntArray(0,10,10);
        array = sort(array);
        System.out.println(Convert.toStr(array));
    }
}
