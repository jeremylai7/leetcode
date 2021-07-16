package com.interview;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-15
 * @desc:
 * 有序非递减数组，找出在指定区间中的元素位置，输出起始和结束位置的下标。
 * 如数组： 1,2,2,3,4,6
 * 区间:2,8(大于等于2，小于等于8)
 * 结果1,5（1是符合区间最左边的下标，5是符合区间最右边的下标）
 * 要求时间复杂度要小于O(N)(不可以是O(N))
 *
 */
public class FindSortArrayInterval {

	private int[] array = {1,2,2,3,4,6};

	private int min = -20;

	private int max = 8;

	@Test
	public void binarySearch() {
		int left = binarySearch(array,min,true);
		int right = binarySearch(array,max,false);
		System.out.println(left +" "+ right);
	}

	private int binarySearch(int[] array,int target,boolean first){
		int length = array.length;
		if (length == 0) {
			return -1;
		}
		if (array[0] > max) {
			return -1;
		}
		if (array[length-1] < min) {
			return -1;
		}
		int left = 0,right = length -1;
		while (left <= right) {
			int mid = left + (right -left)/2;
			if (array[mid] > target) {
				right = mid - 1;
			}else if (array[mid] < target) {
				left = mid + 1;
			}else {
				if (first) {
					if (mid == 0 || array[mid - 1] != target) {
						return mid;
					} else {
						right = mid - 1;
					}
				} else {
					if (mid == 0 || array[mid + 1] != target) {
						return mid;
					} else {
						left = mid + 1;
					}
				}

			}
		}
		if (first) {
			return left;
		} else {
			return right;
		}
	}
}
