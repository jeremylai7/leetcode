package com.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-04
 * @desc: 数组中的第K个最大元素
 */
public class L215KthLargestElementInAnArray {

	private int[] array = {3,2,1,5,6,4};

	@Test
	public void test() {
		int index = findKthLargest(array,2);
		System.out.println(index);
	}

	private int findKthLargest(int[] nums, int k) {
		if (k > nums.length) {
			return -1;
		}
		//快速排序
		quickSort(nums,0,nums.length-1);
		return nums[nums.length - k];

	}

	/**
	 *
	 * @param nums
	 * @param left     左边界
	 * @param right    右边界
	 */
	private void quickSort(int[] nums, int left,int right){
		if (left > right) {
			return;
		}
		int i = left;
		int j = right;
		int temp = nums[i];
		while (i < j) {
			while (i < j && nums[j] > temp) {
				j--;
			}
			if (i < j) {
				//比基准值小的前面
				nums[i] = nums[j];
				i++;
			}
			while (i < j && nums[i] < temp) {
				i++;
			}
			if (i < j) {
				nums[j] = nums[i];
				j--;
			}
		}
		nums[i] = temp;
		quickSort(nums,left,i - 1);
		quickSort(nums,i+1,right);

	}
}
