package sort;

import cn.hutool.core.convert.Convert;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author whj
 * @date 2019/11/25 15:41
 */

public class countSort {
    public static int[] sort(int[] arg){
        Long start = System.currentTimeMillis();
        //复制数组，不改变参数内容
        int[] array = Arrays.copyOf(arg,arg.length);
        int max = getMaxValue(array);
        array = countSort(array,max);
        System.out.println(System.currentTimeMillis()-start);
        return array;
    }


    private static int[] countSort(int[] array,int max){
        int bucketLen = max + 1;
        int[] bucket = new int[bucketLen];

        for (int i : array) {
            bucket[i]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0){
                array[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return array;
    }

    private static int getMaxValue(int[] array){
        int max = array[0];
        for (int i : array) {
            if (max < i){
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] array = sort.SortData.getIntArray(0,10,10);
//        array = sort(array);
//        System.out.println(Convert.toStr(array));
        sort(SortData.getIntArray(0,100000000,100000000));
    }
}
