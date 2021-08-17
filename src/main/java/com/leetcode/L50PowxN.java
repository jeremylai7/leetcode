package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/8/18
 * @desc:
 **/
public class L50PowxN {

    @Test
    public void test() {
        double x = 2;
        int n = -2;
        double sum = quickMul(x,n);
        sum = n < 0 ? 1/sum : sum;
        System.out.println(sum);

    }

    private double quickMul(double x,int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x,n/2);
        return n%2 == 0 ? y * y : y * y * x;
    }
}
