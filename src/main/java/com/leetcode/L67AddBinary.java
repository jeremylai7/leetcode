package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-07
 * @desc: 二进制求和
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。

	输入为 非空 字符串且只包含数字 1 和 0。

	 

	示例 1:

	输入: a = "11", b = "1"
	输出: "100"
	示例 2:

	输入: a = "1010", b = "1011"
	输出: "10101"


 */
public class L67AddBinary {

	@Test
	public void test() {
		String result = addBinary("1010","1011");
		System.out.println(result);
	}

	public String addBinary(String a, String b) {
		int aLength = a.length() - 1;
		int bLength = b.length() - 1;
		StringBuilder stringBuilder = new StringBuilder();
		int addOne = 0;
		while (aLength >= 0 || bLength >= 0 || addOne != 0) {
			int aa = aLength >= 0 ? a.charAt(aLength) - '0': 0;
			int bb = bLength >= 0 ? b.charAt(bLength) - '0': 0;
			int sum = (aa + bb + addOne)%2;
			addOne = (aa + bb + addOne)/2;
			stringBuilder.append(sum);
			aLength--;
			bLength--;
		}
		return stringBuilder.reverse().toString();

	}
}
