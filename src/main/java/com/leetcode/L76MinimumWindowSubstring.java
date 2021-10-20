package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: laizc
 * @Date: Created in  2021-10-20
 * @desc: 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

	注意：

	对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
	如果 s 中存在这样的子串，我们保证它是唯一的答案。
	 

	示例 1：

	输入：s = "ADOBECODEBANC", t = "ABC"
	输出："BANC"
	示例 2：

	输入：s = "a", t = "a"
	输出："a"

 */
public class L76MinimumWindowSubstring {

	@Test
	public void test() {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String result = minWindow(s,t);
		System.out.println(result);
	}

	public String minWindow(String s, String t) {
		Map<Character,Integer> map = new HashMap<>();
		for (char ch : t.toCharArray()) {
			map.put(ch,map.getOrDefault(ch,0) + 1);
		}
		//滑动窗口
		int left = 0;
		int right = 0;
		int ansLength = Integer.MAX_VALUE;
		int ansLeft = 0;
		int ansRight = 0;
		while (right < s.length()) {
			char charRight = s.charAt(right);
			if (map.containsKey(charRight)) {
				//当前字母次数减一
				map.put(charRight,map.get(charRight) - 1);
				//当前窗口包含所有的字母
				while (match(map)) {
					int tempLength = right - left + 1;
					//窗口更小，更新记录的下标和长度
					if (tempLength < ansLength) {
						ansLeft = left;
						ansRight = right;
						ansLength = tempLength;
					}
					//左指针字母
					char key = s.charAt(left);
					if (map.containsKey(key)) {
						map.put(key,map.get(key) + 1);
					}
					//左指针右移
					left++;

				}
			}
			right++;
		}
		return s.substring(ansLeft,ansRight);
	}

	//t字符串全部包含在左右指针内
	private boolean match(Map<Character,Integer> map) {
		for (Integer value : map.values()) {
			if (value > 0) {
				return false;
			}
		}
		return true;
	}
}
