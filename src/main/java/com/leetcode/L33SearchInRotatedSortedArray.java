package com.leetcode;

import org.junit.Test;

import java.io.Serializable;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-15
 * @desc:  搜索旋转排序数组
 */
public class L33SearchInRotatedSortedArray {

	private int[] array = new int[]{4,5,6,7,0,1,2};

	private int target = 0;

	@Test
	public void binarySearch(){
		int result = binarySearch(array,target);
		System.out.println(result);
	}

	private int binarySearch(int[] nums, int target) {
		int length = nums.length;
		if (length == 0) {
			return -1;
		}
		if (length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		int left = 0,right = length-1;
		while (left <= right) {
			//使用left + (right - left)/2 而不是 (right + left)/2 是防止 right + left 超过int 范围
			int mid = left + (right - left)/2;
			if (nums[mid] == target) {
				return mid;
			}
			//第一个数和中间数做对比
			if (nums[0] <= nums[mid]) {
				//目标位于 第一个数和中间数
				if (nums[0] <= target && target < nums[mid]) {
					right = mid -1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[length - 1]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
}
