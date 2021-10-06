package com.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: laizc
 * @date: created in 2021/10/6
 * @desc: 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * 示例 1：
 *
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 **/
public class L414ThirdMaximumNumber {

    @Test
    public void test() {
        int[] nums = {3, 2, 1};
        int result = thirdMax(nums);
        System.out.println(result);

    }

    public int thirdMax(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        if (length < 3) {
            return nums[length-1];
        }
        int diff = 1;
        for (int i = length - 1; i >= 1; i--) {
            if (nums[i] != nums[i-1] && ++diff == 3) {
                return nums[i-1];
            }
        }
        return nums[length-1];
    }
}
