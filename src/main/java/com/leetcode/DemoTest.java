package com.leetcode;

import org.junit.Test;


/**
 * @author: laizc
 * @date: created in 2021/7/23
 * @desc:
 **/
public class DemoTest {

	@Test
	public void test() {
		int num = 4;

		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < values.length; i++) {
			int value = values[i];
			String symbol = symbols[i];
			while (value <= num) {
				num = num - value;
				stringBuffer.append(symbol);
			}
			if (num == 0) {break;}
		}
		System.out.println(stringBuffer);








	}

}
