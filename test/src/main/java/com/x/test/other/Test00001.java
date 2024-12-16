package com.x.test.other;

/**
 * @author whj
 * @date 2022/9/21
 * @description  math min 测试
 */
public class Test00001 {

    public static void main(String[] args) {
        int EFFECT_MEMBER_NUMS = 10000;
        int size = 1000000;
        for (int i = 0; i * EFFECT_MEMBER_NUMS < size; i++) {
            System.out.println("start:"+i * EFFECT_MEMBER_NUMS+",end="+Math.min(i * EFFECT_MEMBER_NUMS, (i + 1) * EFFECT_MEMBER_NUMS));
        }
    }
}
