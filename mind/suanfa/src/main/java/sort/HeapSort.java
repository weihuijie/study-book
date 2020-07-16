package sort;

import cn.hutool.core.convert.Convert;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author whj
 * @date 2019/11/25 11:55
 */

public class HeapSort {
    public static int[] sort(int[] arg){
        Long start = System.currentTimeMillis();
        //复制数组，不改变参数内容
        int[] array = Arrays.copyOf(arg,arg.length);
        int len = array.length;
        buildMaxHeap(array,len);

        for (int i = len -1; i > 0; i--) {
            swap(array,0,i);
            len--;
            heapify(array,0,len);
        }
        System.out.println(System.currentTimeMillis()-start);
        return array;
    }

    private static void buildMaxHeap(int[] arr,int len){
        for (int i = (int)(Math.floor(len/2)); i >=0 ; i--) {
            heapify(arr,i,len);
        }
    }
    private static void heapify(int[] arr,int i,int len){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]){
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]){
            largest = right;
        }
        if (largest != i){
            swap(arr,i,largest);
            heapify(arr,largest,len);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    public void heapSort(int[] a){
        System.out.println("开始排序");
        int arrayLength=a.length;
        //循环建堆
        for(int i=0;i<arrayLength-1;i++){
            //建堆
            buildMaxHeap2(a,arrayLength-1-i);
            //交换堆顶和最后一个元素
            swap(a,0,arrayLength-1-i);
            System.out.println(Arrays.toString(a));

        }

    }
    //对data数组从0到lastIndex建大顶堆
    private void buildMaxHeap2(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点
            int k=i;
            //如果当前k节点的子节点存在
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){
                    //若果右子节点的值较大
                    if(data[biggerIndex]<data[biggerIndex+1]){
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if(data[k]<data[biggerIndex]){
                    //交换他们
                    swap(data,k,biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] array = sort.SortData.getIntArray(0,10,10);
//        array = sort(array);
//        System.out.println(Convert.toStr(array));
        sort(SortData.getIntArray(0,100000000,100000000));
    }
}
