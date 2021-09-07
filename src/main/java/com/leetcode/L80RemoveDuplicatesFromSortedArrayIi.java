package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-07
 * @desc: 删除有序数组中的重复项 II
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。

	不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

	输入：nums = [1,1,1,2,2,3]
	输出：5, nums = [1,1,2,2,3]
	解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。


 */
public class L80RemoveDuplicatesFromSortedArrayIi {
	@Test
	public void test() {
		int[] nums = {1,1,2,2,2,3,4,4,4};
		int result = removeDuplicates(nums);
		System.out.println(result);
	}

	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if (n <= 2){
			return n;
		}
		int index = 2;
		for(int i = 2;i < nums.length;i++) {
			if(nums[i] != nums[index-2]){
				nums[index++] = nums[i];
			}
		}
		return index ;
	}

}
