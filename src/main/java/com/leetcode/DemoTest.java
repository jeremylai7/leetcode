package com.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @author: laizc
 * @date: created in 2021/7/23
 * @desc:
 **/
public class DemoTest {

	private int[] coinsArray;

	@Test
	public void test() {
		Deque<String> stack = new ArrayDeque<>();
		String path = "/a/./b/../../c/";
		String[] names = path.split("/");
		for (String name : names) {
			if ("..".equals(name)) {
				if (!stack.isEmpty()) {
					stack.removeLast();
				}
			} else if (name.length() > 0 && !".".equals(name)) {
				stack.addLast(name);
			}
		}
		System.out.println(stack);
		StringBuffer stringBuffer = new StringBuffer();
		if (stack.isEmpty()) {
			stringBuffer.append("/");
		} else {
			while (!stack.isEmpty()) {
				stringBuffer.append("/");
				stringBuffer.append(stack.pollFirst());
			}
		}
		System.out.println(stringBuffer);


	}

	private int recall(int amount, int count) {

		return -1;
	}

	public String simplifyPath(String path) {
		String[] names = path.split("/");
		Deque<String> stack = new ArrayDeque<>();
		for (String name : names) {
			if ("..".equals(name)) {
				if (!stack.isEmpty()) {
					stack.removeLast();
				}
			} else if (name.length() > 0 && !".".equals(name)) {
				stack.addLast(name);
			}
		}
		System.out.println(stack);
		StringBuffer stringBuffer = new StringBuffer();
		if (stack.isEmpty()) {
			stringBuffer.append("/");
		} else {
			while (!stack.isEmpty()) {
				stringBuffer.append("/");
				stringBuffer.append(stack.pollFirst());
			}
		}
		return stringBuffer.toString();
	}


}
