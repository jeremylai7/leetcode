package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-06
 * @desc: 除自身以外数组的乘积
 *
 * 你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

  示例:
  输入: [1,2,3,4]
  输出: [24,12,8,6]
 */
public class L238ProductOfArrayExceptSelf {

	private int[] num = {1,2,3,4};

	@Test
	public void test() {
		int length = num.length;
		// L 和 R 分别表示左右两侧的乘积列表
		int[] L = new int[length];
		int[] R = new int[length];
		L[0] = 1;
		for (int i = 1; i < length; i++) {
			L[i] = L[i-1] * num[i - 1];
		}
		R[length - 1] = 1;
		for (int i = length - 2; i >= 0 ; i--) {
			R[i] = R[i + 1] * num[i + 1];
		}
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = L[i] * R[i];
		}
		print(result);
	}

	private void print(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
}
