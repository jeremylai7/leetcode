package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-06-21
 * @desc: 最长回文子串
 */
public class L5LongestPalindromicSubstring {

	private String str = "babad";

	/**
	 * 中心扩散法 只能解决回文字串为奇数的情况
	 */
	@Test
	public void centerSpreadTest() {
		String result = "";
		int length = str.length();
		if (length == 1) {
			result = str;
		}
		if (length == 2) {
			if (str.charAt(0) == str.charAt(1)) {
				result = str;
			}else {
				result = str.substring(0,1);
			}
		}
		if (result == "") {
			for (int i = 1; i < length -1; i++) {
				int j = i;
				int removeIndex = 0;
				String temp = null;
				while (j - removeIndex >= 0 && j + removeIndex < length - 1) {
					if (removeIndex == 0) {
						temp = String.valueOf(str.charAt(j));
						removeIndex++;
						continue;
					}
					char pre = str.charAt(j - removeIndex);
					char after = str.charAt(j + removeIndex);
					if (pre == after){
						temp = str.substring(j - removeIndex,j + removeIndex);
					} else {
						break;
					}
					removeIndex++;
				}
				if (temp.length() > result.length()) {
					result = temp;
				}
			}
		}
		System.out.println(result);
	}

	/**
	 * 中心扩散法
	 * 采用的是双指针方法，解决回文字符串为偶数情况
	 *
	 */
	@Test
	public void longestPalindromeTest() {
		String s =longestPalindrome(str);
		System.out.println(s);
	}

	private static String longestPalindrome(String s) {
		int length = s.length();
		if (s == null || s.length() < 1) {
			return "";
		}
		if (length == 1) {
			return s;
		}
		if (length == 2) {
			if (s.charAt(0) == s.charAt(1)) {
				return s;
			}else {
				return s.substring(0,1);
			}
		}
		int start = 0,end = 0;
		String result = "";
		for (int i = 0; i < length; i++) {
			//回文数长度为奇数
			int len1 = expandAroundCenter(s,i,i);
			//回文数长度为偶数
			int len2 = expandAroundCenter(s,i,i+1);
			int len = Math.max(len1,len2);
			if (len > end -start) {
				start = i - (len - 1)/2;
				end = i + len/2;
			}
			if (end - start + 1 > result.length()) {
				result = s.substring(start,end + 1);
			}
		}
		return result;


	}

	private static int expandAroundCenter(String s,int left,int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			--left;
			right++;
		}
		return right - left - 1;
	}
}
