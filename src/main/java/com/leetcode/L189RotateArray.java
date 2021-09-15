package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/14
 * @desc: 旋转数组
 **/
public class L189RotateArray {

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] num = new int[n];
        for(int i = 0;i < n;i++) {
            num[(i + k)%n] = nums[i];
        }
        System.arraycopy(num,0,nums,0,n);
    }
}
