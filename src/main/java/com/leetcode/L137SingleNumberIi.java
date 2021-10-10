package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: laizc
 * @Date: Created in  2021-10-09
 * @desc: 只出现一次的数字 II
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。

	示例 1：

	输入：nums = [2,2,3,2]
	输出：3
	示例 2：

	输入：nums = [0,1,0,1,0,1,99]
	输出：99
 */
public class L137SingleNumberIi {

	@Test
	public void test() {
		int[] nums = {2,2,3,2};
		int result = singleNumber(nums);
		System.out.println("解法一: " + result);
		result = singleNumber2(nums);
		System.out.println("解法二: " + result);
	}

	/**
	 * 使用set遍历
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return -1;
	}

	/**
	 * 位运算
	 * @param nums
	 * @return
	 */
	public int singleNumber2(int[] nums) {
		int ans = 0;
		//遍历每一位
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int num : nums) {
				//当前位是否是1
				if ((num >>> i & 1) == 1) {
					count++;
				}
			}
			//1 的个数是否是3的倍数
			if (count % 3 != 0) {
				ans |= 1 << i;
			}
		}
		return ans;
	}
}
