package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2022-01-19
 * @desc: 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

	示例 1:

	输入: [2,3,-2,4]
	输出: 6
	解释: 子数组 [2,3] 有最大乘积 6。
	示例 2:

	输入: [-2,0,-1]
	输出: 0
	解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

 */
public class L152MaximumProductSubarray {
	@Test
	public void test() {
		int[] nums = {2,3,-2,4};
		int max = maxProduct(nums);
		System.out.println(max);

	}

	public int maxProduct(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int[] dpMax = new int[n];
		dpMax[0] = nums[0];

		int[] dpMin = new int[n];
		dpMin[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < n; i++) {
			dpMax[i] = Math.max(dpMin[i - 1] * nums[i], Math.max(dpMax[i - 1] * nums[i],nums[i]));
			dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i],nums[i]));
			max = Math.max(max,dpMax[i]);
		}
		return max;
	}
}
