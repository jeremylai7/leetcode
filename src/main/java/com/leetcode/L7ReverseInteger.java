package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/6/19
 * @desc: 整数反转
 **/
public class L7ReverseInteger {

    private int x = 1234;

    /**
     * 暴力求解
     */
    @Test
    public void violent () {
        Integer aa = x;
        String string = aa.toString();
        if (x < 0) {
            string = string.substring(1);
        }
        String[] array = string.split("");
        String temp;
        int length = array.length;
        for (int i = 0; i < length/2; i++) {
            temp = array[length - i - 1];
            array[length - i -1] = array[i];
            array[i] = temp;
        }
        long sum = 0;
        for (int i = length - 1 ; i >= 0;i--) {
            sum += Math.pow(10, length - 1 - i) * Integer.valueOf(array[i]);
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            sum = 0;
        }
        if (x < 0) {
            sum = 0 - sum;
        }
        System.out.println(sum);
    }

}
