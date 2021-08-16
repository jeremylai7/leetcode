package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-16
 * @desc: 寻找两个正序数组的中位数
 */
public class L4MedianOfTwoSortedArrays {

	private int[] nums1 = {1,3};
	private int[] nums2 ={2};

	@Test
	public void test() {
		double median = findMedianSortedArrays(nums1,nums2);
		System.out.println(median);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//判断两个数组长度之可能为奇数或者偶数
		int length = nums1.length + nums2.length;
		int l = length%2;
		int index = 0;
		if (l == 0) {

		} else {
			int flag = (length + 1)/2;

			//奇数就是 length+1 的一半

		}
		return 0;

	}

}
