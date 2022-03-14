package com.x.test.money;

import java.math.BigDecimal;

/**
 * @author: weihuijie
 * @date: 2021/3/10
 * @description: 基金
 */
public class JiJin {

    /**
     *  投入金额
     */
    private static BigDecimal in = new BigDecimal("10000");
    private static BigDecimal range = new BigDecimal("1.00");

    public static void main(String[] args) {
        BigDecimal now = in.subtract(in.multiply(range.divide(new BigDecimal("100"))));

    }
}
