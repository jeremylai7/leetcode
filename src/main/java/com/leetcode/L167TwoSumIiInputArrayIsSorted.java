package com.leetcode;

import org.junit.Test;

import java.util.logging.Level;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-15
 * @desc:  两数之和 II - 输入有序数组
 */
public class L167TwoSumIiInputArrayIsSorted {

	private int[] numbers = {5,25,75};

	private int target = 100;

	/**
	 * 二分查找
	 * 1、先固定查找一个数，另一个数使用二分查找
	 */
	@Test
	public void binary() {
		int[] result = binary(numbers,target);
		print(result);

	}

	/**
	 * 双指针
	 * 1、初始指针指向第一个数left，和最后一个数right
	 * 2、left + right = target 直接返回
	 * 3、left + right < target left右移
	 * 4、left + right > target right左移
	 */
	@Test
	public void doublePoint() {
		int[] result = doublePoint(numbers,target);
		print(result);
	}

	private int[] doublePoint(int[] numbers,int target) {
		int left = 0,right = numbers.length - 1;
		while (left < right) {
			int sub = target - numbers[right];
			if (numbers[left] == sub){
				return new int[]{left+1,right+1};
			}else if (numbers[left] < sub) {
				left++;
			} else {
				right--;
			}
		}
		return new int[]{-1,-1};
	}

	private int[] binary(int[] numbers,int target) {
		int length = numbers.length;
		for (int i = 0; i < length; i++) {
			int first = numbers[i];
			int left = i + 1,right = length -1;
			while(left <= right) {
				int mid = left + (right - left)/2;
				int sub = target - first;
				if (numbers[mid] > sub) {
					right = mid - 1;
				}else if (numbers[mid] < sub){
					left = mid + 1;
				} else {
					return new int[]{i+1,mid+1};
				}
			}

		}
		return new int[]{-1,-1};
	}



	private void print(int[] numbers){
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
}
