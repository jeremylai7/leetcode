package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-30
 * @desc: 杨辉三角
 */
public class L118PascalsTriangle {

	@Test
	public void test() {
		List<List<Integer>> lists = generate(5);
		System.out.println(lists);
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					list.add(1);
				} else {
					list.add(lists.get(i-1).get(j-1) + lists.get(i-1).get(j));
				}
			}
			lists.add(list);
		}
		return lists;

	}
}
