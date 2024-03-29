package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-04-26
 * @desc: 有效的完全平方数
 */
public class L367ValidPerfectSquare {

	@Test
	public void test() {
		double aa = Math.sqrt(808201);
		System.out.println(aa);
		int x = 808201;
    	boolean valid = binary(x);
		System.out.println(valid);
	}

	/**
	 * 二分查找
	 * @param x
	 * @return 是否为完全平方数
	 */
	private boolean binary(int x) {
		if (x <= 2) {
			return true;
		}
		int left = 2,right = x/2,y;
		long square;
		while (left <= right) {
			y = left + (right - left)/2;
			//防止数字超过范围
			square = (long)y * y;
			if (square == x) {
				return true;
			}else if (square > x) {
				right = y - 1;
			}else {
				left = y + 1;
			}
		}
		return false;
	}
}
