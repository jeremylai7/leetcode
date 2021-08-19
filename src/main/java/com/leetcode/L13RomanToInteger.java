package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * @author: laizc
 * @date: created in 2021/8/19
 * @desc: 罗马数字转整数
 **/
public class L13RomanToInteger {

	Map<Character, Integer> map = new HashMap<Character, Integer>() {{
		put('I', 1);
		put('V', 5);
		put('X', 10);
		put('L', 50);
		put('C', 100);
		put('D', 500);
		put('M', 1000);
	}};

	@Test
	public void test() {

		String s = "MCMXCIV";
		int sum = 0;
		int length = s.length();
		for (int i = 0; i < length; i++) {
			int value = map.get(s.charAt(i));
			if (i < length - 1 && value < map.get(s.charAt(i + 1))) {
				sum -= value;
			} else {
				sum += value;
			}
		}
		System.out.println(sum);




	}

}
