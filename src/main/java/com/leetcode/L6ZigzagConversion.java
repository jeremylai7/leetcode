package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-06
 * @desc:  Z 字形变换
 *
 * 示例 2：
	输入：s = "PAYPALISHIRING", numRows = 4
	输出："PINALSIGYAHRPI"
	解释：
	P     I    N
	A   L S  I G
	Y A   H R
	P     I
 */
public class L6ZigzagConversion {

	@Test
	public void test() {
		String s = "PAYPALISHIRING";
		int numRows = 4;
		String result = convert(s,numRows);
		System.out.println(result);

	}

	public String convert(String s,int numRows) {
		if (numRows < 2) {
			return s;
		}
		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			rows.add(new StringBuilder());
		}
		int i = 0,flag = -1;
		for(char c : s.toCharArray()) {
			rows.get(i).append(c);
			//flag控制添加的方向，移动到最上面或者最下面，方向改变
			if (i == 0 || i == numRows -1) {
				flag = - flag;
			}
			i = i + flag;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (StringBuilder row : rows) {
			stringBuilder.append(row);
		}
		return stringBuilder.toString();
	}
}
