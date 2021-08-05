package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-05
 * @desc: 字符串相加
 */
public class L415AddStrings {

	@Test
	public void test() {
		String result = addStrings("123","345");
		System.out.println(result);
	}

	public String addStrings(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		StringBuffer stringBuffer = new StringBuffer();
		int carry = 0;
		while (i >= 0 || j >= 0 || carry > 0) {
			int x = i >= 0 ? num1.charAt(i) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j) - '0' : 0;
			int add = x + y + carry;
			int sum = add%10;
			carry = add/10;
			stringBuffer.append(sum);
			i--;
			j--;
		}
		return stringBuffer.reverse().toString();
	}
}
