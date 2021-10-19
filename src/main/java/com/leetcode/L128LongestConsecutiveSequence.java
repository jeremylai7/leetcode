package com.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: laizc
 * @Date: Created in  2021-10-19
 * @desc: 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

	请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
	 

	示例 1：

	输入：nums = [100,4,200,1,3,2]
	输出：4
	解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
	示例 2：

	输入：nums = [0,3,7,2,5,8,4,6,0,1]
	输出：9

 */
public class L128LongestConsecutiveSequence {

	@Test
	public void test() {
		int[] nums = {100,4,200,1,3,2};
		int length = longestConsecutive(nums);
		System.out.println(length);
		length = longestConsecutive2(nums);
		System.out.println(length);

	}

	/**
	 * 暴力破解
	 * 时间复杂度O(n²) 时间超时
	 * @param nums
	 * @return
	 */
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int count = 0;
			while (set.contains(num)) {
				count++;
				num = num + 1;
			}
			max = Math.max(max,count);
		}
		return max;
	}

	/**
	 * 对暴力破解的优化，如果遍历的数不是最小的数则直接忽略
	 * @param nums
	 * @return
	 */
	public int longestConsecutive2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			//不存在最小的数才开始遍历
			if (!set.contains(num - 1)) {
				int count = 0;
				while (set.contains(num)) {
					count++;
					num = num + 1;
				}
				max = Math.max(max,count);
			}
		}
		return max;
	}
}
