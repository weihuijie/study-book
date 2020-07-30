package com.x.test.stream;

import cn.hutool.core.convert.Convert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @author: weihuijie
 * @date: 2020/7/17
 * @description: Stream 测试
 */
public class StreamTest {
    private static int[] ints = {1,3,4,123,4534,123,6,78,12,323,5,34,42315,64,75,456,2,564,586,67,6324,578,9,56,5652,354,4,86,6,34,};
    private static ArrayList list = new ArrayList();

    public static void main(String[] args) {
//        Arrays.stream(ints);
        Stream.iterate(0,n -> n+2).limit(20).forEach(System.out::println);
        System.out.println(Convert.toStr(ints));
    }

    private static void arrToList(){
        Collections.addAll(list,ints);
    }
}
