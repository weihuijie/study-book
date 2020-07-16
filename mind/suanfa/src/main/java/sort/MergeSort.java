package sort;

import cn.hutool.core.convert.Convert;

import java.util.Arrays;

/**
 * 归并排序
 *      归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 *  
 *      作为一种典型的分而治之思想的算法应用，归并排序的实现由两种方法：
 * 	        • 自上而下的递归（所有递归的方法都可以用迭代重写，所以就有了第 2 种方法）；
 * 	        • 自下而上的迭代；
 *
 * 	    步骤
 * 	        • 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 * 	        • 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 * 	        • 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 * 	        • 重复步骤 3 直到某一指针达到序列尾；
 * 	        • 将另一序列剩下的所有元素直接复制到合并序列尾。
 *
 *
 * @author whj
 * @date 2019/11/20 13:42
 */

public class MergeSort {


    /**
     * @param arg
     * @return
     */
    public static int[] sort(int[] arg){
        //复制数组，不改变参数内容
        int[] array = Arrays.copyOf(arg,arg.length);
        if (array.length < 2){
            return array;
        }
        return merge(array,0,array.length-1);
    }

    private static int[] merge(int[] array,int min,int max) {
        if (min >= max){
            return array;
        }
        int mid = (min+max)/2;
        merge(array,min,mid);
        merge(array,mid+1,max);
        //排序
        int[] sort = new int[max-min+1];
        //这里弄一个要处理的数组副本 长度是 R-L+1
        for (int i = min; i <= max; i++) {
            sort[i-min] = array[i];
        }
        int i = min;
        int j = mid+1;
        for (int k = min; k <= max; k++) {
            if (i > mid){
                array[k] = sort[j-min];
                j++;
            }else if (j > max){
                array[k] = sort[i-min];
                i++;
            }else
            if (sort[i-min] < sort[j-min]){
                array[k] = sort[i-min];
                i++;
            }else {
                array[k] = sort[j-min];
                j++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        int[] array = SortData.getIntArray(0,10,100000000);
        array = sort(array);
        System.out.println(System.currentTimeMillis()-start);
    }
}
