package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-06-29
 * @desc: Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
例如，
     1 -> A
     2 -> B
     3 -> C
     ...
     26 -> Z
     27 -> AA
     28 -> AB
     ...
 */
public class L168ExcelSheetColumnTitle {

	private int ch = 28;

	/**
	 * 解题思路：进制转换，从1开始的26进制转换
	 *
	 */
	@Test
	public void test() {
		StringBuffer sb = new StringBuffer();
		while (ch > 0) {
			ch--;
			sb.append((char)(ch%26 + 'A'));
			ch = ch/26;
		}
		System.out.println(sb);
	}


}
