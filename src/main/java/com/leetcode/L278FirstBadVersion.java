package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-15
 * @desc: 第一个错误的版本
 */
public class L278FirstBadVersion {



	@Test
	public void binarySearch() {
		int result = binarySearch(5);
		System.out.println(result);
	}

	private int binarySearch(int n) {
		int left = 1,right = n;
		while (left <= right) {
			int mid = left + (right - left)/2;
			if (!isBadVersion(mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;


	}

	private boolean isBadVersion(int n) {
		boolean[] array = {false,false,false,true,true};
		return array[n-1];
	}
}
