package com.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @Author: laizc
 * @Date: Created in  2021-03-29
 * @desc: 有效的括号
 */
public class L20ValidParentheses {

	private String str = "()[]{}";


	private static Map<Character,Character> map = new HashMap<>();

	static {
		map.put(')','(');map.put(']','[');map.put('}','{');
	}

	/**
	 * 使用栈的特性
	 */
	@Test
	public void stackTest() {
		Stack<Character> stack = new Stack<>();

		char[] chars = str.toCharArray();
		boolean flag = true;
		for (char ch : chars) {
			if (map.containsKey(ch)) {
				if (stack.isEmpty() || map.get(ch) != stack.peek()) {
					flag = false;
					break;
				}
				stack.pop();
			}else {
				stack.push(ch);
			}
		}
		flag = flag || !stack.isEmpty();
		System.out.println(flag);

	}


}
