package com.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-30
 * @desc:  排序数组
 */
public class L912SortAnArray {

	@Test
	public void test() {
		int[] num = {8,15,22,3,11,7};
		int[] num2 = {8,15,22,3,11,7};
		//使用递归方式实现快速排序
		num = sortArray(num);
		System.out.println(num);
		//使用非递归方式（栈）实现快速排序
		num2 =sortArray2(num2);
		System.out.println(num2);




	}

	/**
	 * 使用递归方式实现快速排序
	 * @param nums
	 * @return
	 */
	public int[] sortArray(int[] nums) {
		recall(nums,0,nums.length - 1);
		return nums;
	}

	private void recall(int[] nums,int left,int right) {
		if (left > right) {
			return;
		}
		int i = left;
		int j = right;
		int standard = nums[i];
		while (i < j) {
			while (i < j && nums[j] > standard) {
				j--;
			}
			if (i < j) {
				nums[i] = nums[j];
				i++;
			}
			while (i < j &&  nums[i] < standard) {
				i++;
			}
			if (i < j) {
				nums[j] = nums[i];
			}
		}
		nums[i] = standard;
		recall(nums,left,i-1);
		recall(nums,i+1,right);

	}

	private int[] sortArray2(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		Stack<Integer> stack = new Stack<>();
		if (start < end) {
			stack.push(end);
			stack.push(start);
			while (!stack.isEmpty()) {
				int l = stack.pop();
				int r = stack.pop();
				int index = partition(nums,l,r);
				if (l < index -1) {
					stack.push(index-1);
					stack.push(l);
				}
				if (r > index + 1) {
					stack.push(r);
					stack.push(index+1);
				}
			}
		}
		return nums;
	}

	private int partition(int[] nums, int l, int r) {
		int standard = nums[l];
		while (l < r) {
			while (l < r && nums[r] > standard) {
				r--;
			}
			nums[l] = nums[r];
			while (l < r && nums[l] < standard) {
				l++;
			}
			nums[r] = nums[l];
		}
		nums[l] = standard;
		return l;
	}
}
