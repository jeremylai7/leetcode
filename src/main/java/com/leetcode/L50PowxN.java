package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/8/18
 * @desc: Pow(x, n)
 **/
public class L50PowxN {

    @Test
    public void test() {
       int x = 2;
       int n = -2;
       double result = myPow(x,n);
       System.out.println("第一种解法：" + result);
       double result2 = myPow2(x,n);
       System.out.println("第二种解法：" + result2);
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1/x;
        }
        double sum = quickMul(x,n);
        return n < 0 ? 1/sum : sum;
    }

    private double quickMul(double x,int n) {
        if (n == 1 || n == -1) {
            return x;
        }
        double y = quickMul(x,n/2);
        return n%2 == 0 ? y * y : y * y * x;
    }

    public double myPow2(double x, int n) {
        double sum = quickMul(x,n);
        return n < 0 ? 1/sum : sum;
    }

    private double quickMul2(double x,int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul2(x,n/2);
        return n%2 == 0 ? y * y : y * y * x;
    }
}
