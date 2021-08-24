package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-16
 * @desc: 寻找两个正序数组的中位数
 */
public class L4MedianOfTwoSortedArrays {

	private int[] nums1 = {1,3,4,5,6};
	private int[] nums2 ={2};

	@Test
	public void test() {
		double median = findMedianSortedArrays(nums1,nums2);
		System.out.println(median);
	}

	/**
	 * 第一种方式 合并数组，然后取数组的中位数
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		if (m == 0 && n == 0) {
			return 0;
		}
		if (m == 0) {
			if (n%2 == 0) {
				return (nums2[n/2] + nums2[n/2 - 1])/2.0;
			} else {
				return nums2[n/2];
			}
		}
		if (n == 0) {
			if (m%2 == 0) {
				return (nums1[m/2] + nums1[m/2 - 1])/2.0;
			} else {
				return nums1[m/2];
			}
		}
		//合并数组
		int[] nums = new int[m + n];
		int left1 = 0,left2 = 0,index = 0;
		while (left1 < m && left2 < n) {
			if (nums1[left1] < nums2[left2]) {
				nums[index++] = nums1[left1++];
			} else {
				nums[index++] = nums2[left2++];
			}
		}
		if (left1 < m) {
			while (left1 < m) {
				nums[index++] = nums1[left1++];
			}
		} else if (left2 < n) {
			while (left2 < n) {
				nums[index++] = nums2[left2++];
			}
		}
		int length = m + n;
		return length%2 == 0 ? (nums[length/2 - 1] + nums[length/2])/2.0 : nums[length/2];
	}

}
