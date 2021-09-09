package com.leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-09
 * @desc: 最长有效括号
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

	示例 1：

	输入：s = "(()"
	输出：2
	解释：最长有效括号子串是 "()"
	示例 2：

	输入：s = ")()())"
	输出：4
	解释：最长有效括号子串是 "()()"

 */
public class L32LongestValidParentheses {

	@Test
	public void test() {
		String s= ")()()()";
		int result = longestValidParentheses(s);
		System.out.println(result);
	}

	public int longestValidParentheses(String s) {
		Deque<Integer> stack = new LinkedList<>();
		int max = 0;
		//这里添加为了做一个起始位置
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(i);
			} else {
				stack.pop();
				//如果栈为空，说明当前没有匹配的左括号，当前位置是一个记录的起始位置
				//如果栈不为空，说明栈顶的位置就是一个起始位置
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					max = Math.max(max,i-stack.peek());
				}
			}
		}
		return max;
	}
}
