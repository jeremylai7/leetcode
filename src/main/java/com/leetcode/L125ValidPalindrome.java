package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-22
 * @desc: 验证回文串
 */
public class L125ValidPalindrome {

	@Test
	public void test() {
		String str = "A man, a plan, a canal: Panama";
		boolean flag = isPalindrome(str);
		System.out.println(flag);
	}

	public boolean isPalindrome(String str) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isLetterOrDigit(ch)){
				stringBuffer.append(ch);
			}
		}
		int start = 0,end = stringBuffer.length() -1;
		while (start < end) {
			if (Character.toLowerCase(stringBuffer.charAt(start)) != Character.toLowerCase(stringBuffer.charAt(end))) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
