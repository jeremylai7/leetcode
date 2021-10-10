package com.leetcode;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author: laizc
 * @date: created in 2021/10/10
 * @desc: 阶乘后的零
 *
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 *
 **/
public class L172FactorialTrailingZeroes {

    @Test
    public void test() {
        int n = 13;
        int result = trailingZeroes(n);
        System.out.println(result);
    }

    public int trailingZeroes(int n) {
        BigInteger sum = BigInteger.ONE;
        while (n > 1) {
            sum = sum.multiply(BigInteger.valueOf(n));
            n--;
        }
        int result = 0;
        while (sum.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            sum = sum.divide(BigInteger.TEN);
            result++;
        }
        return result;
    }
}
