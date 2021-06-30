package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-06-28
 * @desc: 反转字符串中的单词
 */
public class L557ReverseWordsInStringIii {
    private static String s =	"Let's take LeetCode contest";

	/**
	 * 使用额外的空间
	 */
	@Test
	public void test() {
		int index = 0;
		StringBuilder stringBuffer = new StringBuilder();
		int length = s.length();
		while (index < length) {
			int start = index;
			//从前往后遍历，一直到空格或者最后一个字符
			while (index < length && s.charAt(index) != ' '){
				index++;
			}
			//添加字符
			for (int i = index -1; i >= start; i--) {
				stringBuffer.append(s.charAt(i));
			}
			//跳过空格
			if (index < length && ' ' == s.charAt(index)) {
				stringBuffer.append(' ');
				index ++;
			}
		}
		System.out.println(stringBuffer.toString());

    }


}
