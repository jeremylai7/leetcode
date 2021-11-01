package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-11-01
 * @desc: 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	示例 1：

	输入：s = "12"
	输出：2
	解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
	示例 2：

	输入：s = "226"
	输出：3
	解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class L91DecodeWays {

	@Test
	public void test() {
		//String s = "226";
		String s = "111111111111111111111111111111111111111111111";
		int result = numDecodings(s);
		System.out.println(result);

	}

	int count;

	public int numDecodings(String s) {
		count = 0;
		recall(s,0);
		return count;
	}

	private void recall(String s,int start) {
		//终止条件
		if (start == s.length()) {
			count++;
			return;
		}
		if (start > s.length()) {
			return;
		}
		if (s.charAt(start) == '0') {
			return;
		}
		//for
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				//分割 1 位数
				recall(s,start + 1);
			} else {
				//分割 2 位数
				if (start + 2 <= s.length()) {
					int num = Integer.parseInt(s.substring(start,start + 2));
					if (num >= 10 && num <= 26) {
						recall(s,start + 2);
					}
				}
			}
		}

	}
}
