package com.x.test.map;

import java.util.BitSet;

/**
 * BitSet 示例
 *
 * @author whj
 * @date 2019/11/6 15:41
 */

public class BitSetTest {
    public static void main(String[] args) {
        //求一个字符串包含的char
        //containChars("99999999135666666666666666666666666678");
        //素数
        //computePrime();
        //数字排序
        //sortArray();
        //简单示例
        //simpleExample();
        //将BitSet对象转化为ByteArray
        byteArrayBitSetTest();

    }

    /**
     *  求一个字符串包含的char
     */
    public static void containChars(String str){
        BitSet used = new BitSet();
        for (int i = 0; i < str.length(); i++) {
            used.set(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = used.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            if (used.get(i)){
                sb.append(i);
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    //素数 有无限个。一个大于1的自然数，如果除了1和它本身外，不能被其他自然数整除(除0以外）的数称之为素数(质数） 否则称为合数
    public static void computePrime(){
        BitSet sieve = new BitSet(1024);
        int size = sieve.size();
        for (int i = 2; i < size; i++) {
            sieve.set(i);
        }
        int finalBit = (int)Math.sqrt(sieve.size());
        for (int i = 2; i < finalBit; i++) {
            if (sieve.get(i)){
                for (int j = 2*i; j < size; j+=i) {
                    sieve.clear(j);
                }
            }
        }
        int counter = 0;
        for (int i = 1; i < size; i++) {
            if (sieve.get(i)){
                System.out.printf("%5d",i);
                if (++counter % 15 == 0){
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    //进行数字排序
    public static void sortArray(){
        int[] array = new int[]{43,234,252,1,2,4,543,1231,1233,1,2,3,4,5,534};
        BitSet bitSet = new BitSet(2 << 13);
        //虽然可以自动扩容，但尽量在构造时指定估算大小,默认为64
        System.out.println("bitSet size:"+bitSet.size());

        for (int i = 0; i < array.length; i++) {
            bitSet.set(array[i]);
        }
        //剔除重复数字后的元素个数
        int bitLen = bitSet.cardinality();

        //进行排序，即把bit为true的元素复制到另一个数组
        int[] orderArray = new int[bitLen];
        int k = 0;
        for (int i = bitSet.nextSetBit(0); i >=0 ; i = bitSet.nextSetBit(i+1)) {
            orderArray[k++] = i;
        }
        System.out.println("After ordering: ");
        for (int i = 0; i < bitLen; i++) {
            System.out.println(orderArray[i]+"\t");
        }
        System.out.println("iterate over the true bits in a BitSet");
        //或直接迭代BitSet中bit为true的元素iterate over the true bits in a BitSet
        for (int i = bitSet.nextSetBit(0); i >= 0 ; i = bitSet.nextSetBit(i+1)) {
            System.out.println(i+"\t");
        }
        System.out.println("---------------------------");
    }


    public static void byteArrayBitSetTest(){
        String s = "asdfjklasdf";
        byte[] b = s.getBytes();
        BitSet bitSet = byteArray2BitSet(b);
        byte[] bytes = bitSet2ByteArray(bitSet);
    }

    /**
     * 将BitSet对象转化为ByteArray
     */
    public static byte[] bitSet2ByteArray(BitSet bitSet){
        byte[] bytes = new byte[bitSet.size()/8];
        for (int i = 0; i < bitSet.size(); i++) {
            int index = i / 8;
            int offset = 7 - i%8;
            //复合赋值位运算符“＆=、^ =、| =”与运算赋值（＆=）、异或运算赋值（^ =）、或运算赋值（| =）
            bytes[index] |= (bitSet.get(i)? 1:0) << offset;
        }
        return bytes;
    }

    /**
     * 将ByteArray对象转化为BitSet
     */
    public static BitSet byteArray2BitSet(byte[] bytes){
        BitSet bitSet = new BitSet(bytes.length * 8);
        int index = 0;
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 7; j >= 0 ; j--) {
                bitSet.set(index++,(bytes[i] & (1 << j)) >> j == 1?true:false);
            }
        }
        return bitSet;
    }

    /**
     * 简单使用示例
     */
    public static void simpleExample(){
        String name[] = {"Java","Source","and","Support"};
        BitSet bitSet = new BitSet();
        for (int i = 0 ,n=name.length; i < n; i++) {
            if ((name[i].length() % 2)==0){
                bitSet.set(i);
            }
        }
        System.out.println(bitSet);
        System.out.println("Size: "+bitSet.size());
        System.out.println("Length: "+bitSet.length());
        for (int i = 0 , n=name.length; i < n ; i++) {
            if (!bitSet.get(i)){
                System.out.println(name[i] + "   id odd");
            }
        }

        BitSet bitSet1 = new BitSet();
        bitSet1.set(0);
        bitSet1.set(1);
        bitSet1.set(2);
        bitSet1.set(3);
        bitSet1.set(4);
        System.out.println(bitSet1);

    }
}
