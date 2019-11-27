package com.x.book.suanfa.sort;

import cn.hutool.core.convert.Convert;

import java.util.Arrays;

/**
 * 冒泡排序
 *   它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 *   走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 *   这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 * @author whj
 * @date 2019/11/18 10:57
 */

public class BubbleSort {

    public static int[] sort(int[] arg){
        Long start = System.currentTimeMillis();
        //复制数组，不改变参数内容
        int[] array = Arrays.copyOf(arg,arg.length);
        int temp = 0;
        int size = array.length;
        Boolean isSort = true;
        //循环次数，从第二个开始
        for (int i = 1; i < size; i++) {
            //将冒泡的数与后面的数值比较
            for (int j = 0; j < size-1; j++) {
                if (array[j] > array[j+1]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    isSort = false;
                }
            }
            if (isSort){
                break;
            }
        }
        System.out.println(System.currentTimeMillis()-start);
        return array;
    }

    public static void main(String[] args) {
        int[] array = SortData.getIntArray(0,10000,10);
        array = sort(array);
        System.out.println(Convert.toStr(array));
    }
}
