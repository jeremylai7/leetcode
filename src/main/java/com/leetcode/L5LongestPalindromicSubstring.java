package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-06-21
 * @desc: 最长回文子串
 */
public class L5LongestPalindromicSubstring {

	private String str = "abca";

	/**
	 * 中心扩散法
	 */
	@Test
	public void centerSpread() {
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
}
