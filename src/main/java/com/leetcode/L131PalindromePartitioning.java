package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-22
 * @desc: 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

	回文串 是正着读和反着读都一样的字符串。

	示例 1：

	输入：s = "aab"
	输出：[["a","a","b"],["aa","b"]]
 */
public class L131PalindromePartitioning {

	@Test
	public void test() {
		String s = "aab";
		List<List<String>> lists = partition(s);
		System.out.println(lists);
	}

	public List<List<String>> partition(String s) {
		lists = new ArrayList<>();
		backtrack(s,0,new ArrayList<>());
		return lists;
	}

	List<List<String>> lists;

	private void backtrack(String s,int index,List<String> path) {
		if (index == s.length()) {
			lists.add(new ArrayList<>(path));
			return;
		}
		for (int i = index + 1; i <= s.length(); i++) {
			String str = s.substring(index,i);
			if (isPalindrome(str)) {
				path.add(str);
				backtrack(s,i,path);
				path.remove(path.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str) {
		int left = 0,right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
