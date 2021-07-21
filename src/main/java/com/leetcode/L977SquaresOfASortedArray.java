package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-21
 * @desc: 有序数组的平方
 */
public class L977SquaresOfASortedArray {

	private int[] nums = {-4,-1,0,3,10};

	/**
	 * 先平方后快速排序
	 */
	@Test
	public void test() {
        //遍历平方
		for(int i = 0;i < nums.length;i++) {
			nums[i] = nums[i] * nums[i];
		}
		//快速排序
		sort(nums,0,nums.length-1);
		print(nums);
	}


	/**
	 * 双指针
	 */
	@Test
	public void doublePoint() {
		int length = nums.length;
		int[] result = new int[length];
		int left = 0,right = length - 1;
		for (int i = 0; i < length; i++) {
			int doubelLeft = nums[left] * nums[left];
			int doubleRight = nums[right] * nums[right];
			if (doubelLeft < doubleRight) {
				result[length - i - 1] = doubleRight;
				right--;
			} else {
				result[length - i - 1] = doubelLeft;
				left++;
			}
		}
		print(result);
	}


	private void sort(int[] nums,int left,int right) {
		if (left > right) {
			return;
		}
		int i = left;
		int j = right;
		//基准值
		int temp = nums[i];
		while(i < j) {
			while(i < j && nums[j] > temp) {
				j--;
			}
			if (i < j){
				nums[i] = nums[j];
				i++;
			}
			while(i < j && nums[i] < temp) {
				i++;
			}
			if (i < j) {
				nums[j] = nums[i];
				j--;
			}
		}
		nums[i] = temp;
		sort(nums,left,i-1);
		sort(nums,i+1,right);
	}


	private void print(int[] nums) {
		for (int index: nums) {
			System.out.print(index + " ");
		}
	}
}
