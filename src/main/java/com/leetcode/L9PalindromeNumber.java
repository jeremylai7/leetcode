package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-06-21
 * @desc: 回文数
 */
public class L9PalindromeNumber {

	private int x = 1212;

	/**
	 * 解题思路
	 * 1、数字转成字符串数组
	 * 2、数组遍历，第一个数和最后一个数，第二个数，和倒数第二个数 做比较。
	 */
	@Test
	public void test() {
		boolean palindrome = true;
		if (x < 0) {
			palindrome = false;
		}
		String[] array = Integer.toString(x).split("");
		int length = array.length;
		for (int i = 0; i < length/2; i++) {
			if (!array[i].equals(array[length - 1- i])) {
				palindrome = false;
				break;
			}
		}
		System.out.println(palindrome);
	}

	/**
	 * 整数反转
	 * 1、将整数反转
	 * 2、反转后整数和原来做对比
	 */
	@Test
	public void reverseInteger() {
		long result = 0;
		int temp = x;
		while (x != 0) {
			int a = x%10;
			x = x/10;
			result = result*10 + a;
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			result = 0;
		}
		boolean palindrome = temp == result;
		System.out.println(palindrome);
	}

}
