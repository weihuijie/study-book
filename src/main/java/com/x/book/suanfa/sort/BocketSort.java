package com.x.book.suanfa.sort;

import cn.hutool.core.convert.Convert;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 桶排序
 *
 * @author whj
 * @date 2019/11/25 16:39
 */

public class BocketSort {

    public static int[] sort(int[] arg){
        Long start = System.currentTimeMillis();
        //复制数组，不改变参数内容
        int[] array = Arrays.copyOf(arg,arg.length);
        array = bucketSort(array,10);
        System.out.println(System.currentTimeMillis()-start);
        return array;
    }

    private static int[] bucketSort(int[] arr,int bucketSize){
        if(arr.length == 0){
            return arr;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (i < min){
                min = i;
            }else if (max < i){
                max = i;
            }
        }
        int bucketCount = (int)(Math.floor((max - min)/bucketSize)) + 1;
        int[][] buckets = new int[bucketCount][0];

        //利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int)(Math.floor((arr[i] - min)/bucketSize));
            buckets[index] = arrAppend(buckets[index],arr[i]);
        }
        int arrIndex =0;
        for (int[] bucket : buckets) {
            if (bucket.length<0){
                continue;
            }
            //对每个桶进行排序，这里使用插入排序
            bucket = countSort.sort(bucket);
            for (int i : bucket) {
                arr[arrIndex++] = i;
            }
        }
        return arr;
    }

    /**
     *  自动扩容，并保存数据
     * @return
     */
    private static int[] arrAppend(int[] arr,int value){
        arr = Arrays.copyOf(arr,arr.length+1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args) {
//        int[] array = SortData.getIntArray(0,10,10);
//        array = sort(array);
//        System.out.println(Convert.toStr(array));
        sort(SortData.getIntArray(0,100000000,100000000));
    }
}
