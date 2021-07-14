package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-04-26
 * @desc: x 的平方根
 * 实现 int sqrt(int x) 函数。
   计算并返回 x 的平方根，其中 x 是非负整数。
   由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

   示例 1:
       输入: 4
       输出: 2
 */
public class L69Sqrtx {

	/**
	 * 二分查找
	 */
	@Test
	public void test() {
		int x = 3;
		int result = binary(x);
		System.out.println(result);
	}

	private int binary(int x){
		if (x == 0 || x == 1) {
			return x;
		}
		int left = 1;
		int right = x;
		int result = -1;
		while (left < right) {
			int mid = left + (right - left)/2;
			//long 解决乘积超过int大小问题
			if ((long)mid * mid > x) {
				right = mid - 1;
			} else {
				result = mid;
				left = mid + 1;
			}
		}
		return result;
	}
}
