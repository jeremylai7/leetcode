package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-30
 * @desc: 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。

	整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x

 */
public class L326PowerOfThree {
	@Test
	public void test() {
		int n = 27;
		boolean flag = isPowerOfThree(n);
		System.out.println(flag);
	}

	public boolean isPowerOfThree(int n) {
		if (n < 1) {
			return false;
		}
		//只要除3余数为零，就一直除
		while (n%3 == 0) {
			n = n/3;
		}
		return n == 1;
	}
}
