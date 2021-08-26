package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-26
 * @desc: 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

	有效括号组合需满足：左括号必须以正确的顺序闭合。

	示例 1：

	输入：n = 3
	输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 */
public class L22GenerateParentheses {

	List<String> list;

	@Test
	public void test() {
		List<String> list = generateParenthesis(2);
		System.out.println(list);
	}

	public List<String> generateParenthesis(int n) {
		list = new ArrayList<>();
		recall(n,"",0,0);
		return list;
	}

	private void recall(int n,String path,int left,int right) {
		if (left == n && right == n) {
			list.add(path);
			return;
		}
		if (left < right) {
			return;
		}
		if (left < n) {
			recall(n,path + "(",left + 1,right);
		}
		if (right < n) {
			recall(n,path + ")",left,right + 1);
		}
	}
}
