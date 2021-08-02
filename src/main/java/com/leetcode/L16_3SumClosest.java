package com.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Base64;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-21
 * @desc: 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class L16_3SumClosest {

	private int[] nums = {-1,2,1,-4};

	private int target = 1;

	@Test
	public void test() {
		int result = threeSumClosest(nums,target);
		//int result = aa(nums,target);
		System.out.println(result);
	}


	/**
	 * 排序 + 双指针
	 * @param nums
	 * @param target
	 * @return
	 */
	private int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int best = 1000 * 3;
		int sum;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int left = i + 1,right = nums.length - 1;
			while (left < right) {
				int sub = target - nums[i];
				int smallSum = nums[left] + nums[right];
				if (sub == smallSum) {
					return target;
				}
				sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(sum - target) < Math.abs(best - target)) {
					best = sum;
				}
				if (sub > smallSum) {
					int left0 = left + 1;
					//如果后一个数是相同的，指针往后移动
					while (left0 < right && nums[left0] == nums[left]) {
						left0++;
					}
					left = left0;
				} else {
					int right0 = right - 1;
					//如果前一个数是相同的，指针往前移动
					while (right0 > left && nums[right0] == nums[right]) {
						right0--;
					}
					right = right0;
				}
			}
		}
		return best;
	}

	private int aa (int[] nums,int target) {
		Arrays.sort(nums);
		int n = nums.length;
		int best = 10000000;

		// 枚举 a
		for (int i = 0; i < n; ++i) {
			// 保证和上一次枚举的元素不相等
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			// 使用双指针枚举 b 和 c
			int j = i + 1, k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				// 如果和为 target 直接返回答案
				if (sum == target) {
					return target;
				}
				// 根据差值的绝对值来更新答案
				if (Math.abs(sum - target) < Math.abs(best - target)) {
					best = sum;
				}
				if (sum > target) {
					// 如果和大于 target，移动 c 对应的指针
					int k0 = k - 1;
					// 移动到下一个不相等的元素
					while (j < k0 && nums[k0] == nums[k]) {
						--k0;
					}
					k = k0;
				} else {
					// 如果和小于 target，移动 b 对应的指针
					int j0 = j + 1;
					// 移动到下一个不相等的元素
					while (j0 < k && nums[j0] == nums[j]) {
						++j0;
					}
					j = j0;
				}
			}
		}
		return best;
	}


}
