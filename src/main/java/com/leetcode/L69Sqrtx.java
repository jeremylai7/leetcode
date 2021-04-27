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
		int x = 8;
		//int result = binary(x);
	}

	/*private int binary(int x){
		int half = x/2;
		int multiply = half * half;
		if (multiply == x) {
			return half;
		}else if (multiply > x) {
			binary(half);
		}
	}*/
}
