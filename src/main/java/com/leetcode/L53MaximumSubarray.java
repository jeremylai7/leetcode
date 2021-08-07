package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/8/7
 * @desc: 最大子序和
 **/
public class L53MaximumSubarray {

    private int[] nums = {5,4,-1,7,8};

    @Test
    public void test() {
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    /**
     * 贪心算法
     * 1、sum记录连续和，如果小于零，从新归零
     * 2、result记录最大记录，每次和sum做比较
     * @param nums
     * @return
     */
    private int maxSubArray(int[] nums) {
        int sum = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result,sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

}
