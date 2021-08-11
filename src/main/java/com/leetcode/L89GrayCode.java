package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-11
 * @desc: 格雷编码
 */
public class L89GrayCode {

	@Test
	public void test() {
		List<Integer> result = grayCode(3);
		System.out.println(result);

	}

	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>();
		result.add(0);
		int head = 1;
		for (int i = 0; i < n; i++) {
			for (int j = result.size() - 1; j >= 0; j--) {
				result.add(head + result.get(j));
			}
			//左移
			head <<= 1;
		}
		return result;
	}

}
