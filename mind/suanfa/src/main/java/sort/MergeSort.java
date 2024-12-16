package sort;

import java.util.Arrays;

/**
 * 归并排序
 *      归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
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
            }else if (sort[i-min] < sort[j-min]){
                array[k] = sort[i-min];
                i++;
            }else {
                array[k] = sort[j-min];
                j++;
            }
        }
        return array;
    }


    // 归并排序
    public static int[] mergeSort(int[] arr, int left, int right) {
        // 如果 left == right，表示数组只有一个元素，则不用递归排序
        if (left < right) {
            // 把大的数组分隔成两个数组
            int mid = (left + right) / 2;
            // 对左半部分进行排序
            arr = mergeSort(arr, left, mid);
            // 对右半部分进行排序
            arr = mergeSort(arr, mid + 1, right);
            //进行合并
            merge(arr, left, mid, right);
        }
        return arr;
    }

    // 合并函数，把两个有序的数组合并起来
    // arr[left..mif]表示一个数组，arr[mid+1 .. right]表示一个数组
    private static void merge(int[] arr, int left, int mid, int right) {
        //先用一个临时数组把他们合并汇总起来
        int[] a = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                a[k++] = arr[i++];
            } else {
                a[k++] = arr[j++];
            }
        }
        while(i <= mid) a[k++] = arr[i++];
        while(j <= right) a[k++] = arr[j++];
        // 把临时数组复制到原数组
        for (i = 0; i < k; i++) {
            arr[left++] = a[i];
        }
    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        int[] array = SortData.getIntArray(0,100,10);
        array = sort(array);
        System.out.println(System.currentTimeMillis()-start);
    }
}
