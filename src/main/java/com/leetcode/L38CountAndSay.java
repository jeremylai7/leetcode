package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-10-21
 * @desc: 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。

	「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。

	你可以将其视作是由递归公式定义的数字字符串序列：

	countAndSay(1) = "1"
	countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
	前五项如下：

	1.     1
	2.     11
	3.     21
	4.     1211
	5.     111221
	第一项是数字 1
	描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
	描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
	描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
	描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 */
public class L38CountAndSay {

	@Test
	public void test() {
		String result = countAndSay(5);
		System.out.println(result);
	}

	/**
	 * 遍历
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
		String str = "1";
		for (int i = 2; i <= n; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			int pos = 0;
			int start = 0;
			int length = str.length();
			while (pos < length) {
				while (pos < length && str.charAt(pos) == str.charAt(start)) {
					pos++;
				}
				stringBuilder.append(pos - start).append(str.charAt(start));
				start = pos;
			}
			str = stringBuilder.toString();
		}
		return str;
	}

	/**
	 * 递归
	 * @param n
	 * @return
	 */
	public String countAndSay2(int n) {
		if (n == 1) {
			return "1";
		}
		//得到上一行的字符串
		String last = countAndSay2(n - 1);
		return getNextString(last);
	}

	private String getNextString(String string) {
		StringBuilder stringBuilder = new StringBuilder();
		int index = 0;
		int start = 0;
		while (index < string.length()) {
			while (index < string.length() && string.charAt(index) == string.charAt(start)) {
				index++;
			}
			stringBuilder.append(index - start).append(string.charAt(start));
			start = index;
		}
		return stringBuilder.toString();
	}


}
