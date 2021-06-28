package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-06-28
 * @desc: 最长公共前缀
 */
public class L14LongestCommonPrefix {

	private String[] array = {"acc","aaa","aaba"};

	/**
	 * 暴力破解 双层for循环
	 *
	 */
	@Test
	public void violent() {
		String str = violent(array);
		System.out.println(str);

	}

	private static String violent(String[] strs){
		int strLength = strs.length;
		if (strLength == 0 || "".equals(strs[0])) {
			return "";
		}
		String temp = strs[0];
		int length = strs[0].length();
		for (int i = 1; i < strLength; i++) {
			length = Math.min(length,strs[i].length());
			int index = 0;
			while (index < length && index < temp.length()) {
				if (temp.charAt(index) == strs[i].charAt(index)) {
					index++;
				} else {
					break;
				}
			}
			temp = strs[i].substring(0,index);
			if ("".equals(temp)){
				return "";
			}
		}
		return temp;
	}

}
