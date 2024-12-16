package sort;

import cn.hutool.core.convert.Convert;

import java.util.Arrays;

/**
 * 希尔排序
 *      希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法。
 *      希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 *          插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
 *          但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位；
 *      希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
 *      算法步骤
 *          1、选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
 *          2、按增量序列个数 k，对序列进行 k 趟排序；
 *          3、每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。
 *             仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * @author whj
 * @date 2019/11/20 10:35
 */

public class ShellSort {

    public static int[] sort(int[] arg){
        Long start = System.currentTimeMillis();
        //复制数组，不改变参数内容
        int[] array = Arrays.copyOf(arg,arg.length);

        int gap = 1;
        while (gap < array.length){
            gap = gap*3 +1;
        }
        while (gap > 0){
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j = i-gap;
                while (j>=0 && array[j] > temp){
                    array[j+gap] = array[j];
                    j -= gap;
                }
                array[j+gap] = temp;
            }
            gap = (int)Math.floor(gap/3);
        }
        System.out.println(System.currentTimeMillis()-start);
        return array;
    }

    /**
     *  希尔排序
     */
    public static int[] shellSort(int[] arg){
        long start = System.currentTimeMillis();
        //复制数组，不改变参数内容
        int[] array = Arrays.copyOf(arg,arg.length);
        int gap = array.length;
        do {
            //增量每次减半
            gap = gap / 2;
            for (int i = 0; i < gap; i++) {
                //插入排序
                for (int j = i + gap; j < array.length; j += gap) {
                    int temp = array[j];
                    int k = j - gap;
                    while (k >= 0 && array[k] > temp) {
                        array[k + gap] = array[k];
                        k = k - gap;
                    }
                    array[k + gap] = temp;
                }
            }
        } while (gap != 1);
        System.out.println(System.currentTimeMillis()-start);
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Convert.toStr(shellSort(SortData.getIntArray(0,10,10))));
    }
}
