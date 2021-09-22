package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/20
 * @desc: 最长递增子序列
 **/
public class L300LongestIncreasingSubsequence {

    @Test
    public void test() {
        int[] num = {10,9,2,5,3,7,101,18};
        int result = lengthOfLIS(num);
        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]);

        }
        return max;
    }
}
