package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-17
 * @desc: 四数之和
 *
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：

	0 <= a, b, c, d < n
	a、b、c 和 d 互不相同
	nums[a] + nums[b] + nums[c] + nums[d] == target
	你可以按 任意顺序 返回答案 。

	示例 1：

	输入：nums = [1,0,-1,0,-2,2], target = 0
	输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
public class L18_4Sum {

	@Test
	public void test() {
		int[] nums = {2,1,0,-1};
		int target = 2;
		List<List<Integer>> lists = fourSum(nums,target);
		System.out.println(lists);
	}


	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> lists = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return lists;
		}
		Arrays.sort(nums);
		int length = nums.length;
		//双for循环 + 双指针
		for (int i = 0; i < length; i++) {
			//去重
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			//起始位置后面数量小于4
			if (i + 4 > length) {
				break;
			}
			//前四个数都大于target，停止遍历
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
				break;
			}
			//遍历到 length - 3 的位置，为双指针预留最少两个位置
			for (int j = i + 1; j < length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
					break;
				}
				if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
					continue;
				}
				int left = j + 1,right = length - 1;
				int sub = target - nums[i] - nums[j];
				int sum;
				while (left < right) {
					sum = nums[left] + nums[right];
					if (sub > sum) {
						left++;
					} else if(sub < sum) {
						right--;
					} else {
						lists.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
						//去重
						while (left < right && nums[left] == nums[left + 1]) {
							left++;
						}
						while (left < right && nums[right] == nums[right - 1]) {
							right--;
						}
						left++;
						right--;
					}
				}
			}
		}
		return lists;

	}
}
