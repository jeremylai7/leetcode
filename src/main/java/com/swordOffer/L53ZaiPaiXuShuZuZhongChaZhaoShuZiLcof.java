package com.swordOffer;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-16
 * @desc:  I. 在排序数组中查找数字的个数
 */
public class L53ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {

	private int[] array = {5,7,7,8,8,10};


	private int target = 6;

	@Test
	public void binarySearch() {
		int count = -1;
		int leftIndex = binarySearch(array,target,true);
		if (leftIndex != -1) {
			int rightIndex = binarySearch(array,target,false);
			if (rightIndex != -1) {
				count = rightIndex - leftIndex + 1;
			}
		}
		System.out.println(count);
	}

	private int binarySearch(int[] nums,int target,boolean first) {
		int length = nums.length;
		int left = 0,right = length - 1;
		while (left <= right) {
			int mid = left + (right - left)/2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				if (first) {
					if (mid == 0 || nums[mid -1] != target) {
						return mid;
					} else {
						right = mid - 1;
					}
				} else {
					if (mid == length -1 || nums[mid + 1] != target) {
						return mid;
					} else {
						left = mid + 1;
					}
				}
			}
		}
		return -1;
	}

}
