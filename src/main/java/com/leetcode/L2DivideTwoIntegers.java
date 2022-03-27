package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2022/3/27
 * @desc: 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 **/
public class L2DivideTwoIntegers {

    @Test
    public void test() {
        System.out.println();
        int a = -2147483648;
        int b = 1;
        System.out.println(divide(a,b));



    }

    /**
     * 步进
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        long dividends = Math.abs((long) dividend);
        long divisors = Math.abs((long) divisor);
        long index = 0;
        while (dividends >= divisors) {
            long temp = divisors;
            long i = 1;
            while (dividends >= temp) {
                dividends = dividends - temp;
                index = index + i;
                temp = temp << 1;
                i = i << 1;
            }
        }
        if (index > Integer.MAX_VALUE && sign == 1) {
            return Integer.MAX_VALUE * sign;
        }
        return (int) index * sign;
    }

}
