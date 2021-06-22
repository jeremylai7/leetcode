package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-06-22
 * @desc:  2 的幂
 */
public class L231PowerOfTwo {

	private int a = 12;

	@Test
	public void modulus() {
		boolean flag = modulus(a);
		System.out.println(flag);
	}

	private boolean modulus(int n) {
		if (n == 0) {
			return false;
		}
		if (n == 1) {
			return true;
		}
		if (n%2 != 0) {
			return true;
		}
		return modulus(n/2);
	}

}
