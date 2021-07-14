package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-14
 * @desc: 在排序数组中查找元素的第一个和最后一个位置
 */
public class L34FindFirstAndLastPositionOfElementInSortedArray {

	private int[] array = new int[]{5,7,7,8,8,10};

	private int target = 8;

	/**
	 * 二分查找
	 */
	@Test
	public void binarySearch() {
		int left = binary(true);
		int right = binary(false);
		System.out.println(left + "  "+ right);
	}

	private int binary(boolean first) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left)/2;
			if (array[mid] > target) {
				right = mid - 1;
			}else if (array[mid] < target){
				left = mid + 1;
			} else {
				//如果往左查找还是目标值，right = mid - 1
				if (first) {
					if (mid == 0 || array[mid -1] != target){
						return mid;
					} else {
						right = mid - 1;
					}
				} else {
					if (mid == array.length -1 || array[mid +1] != target){
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
