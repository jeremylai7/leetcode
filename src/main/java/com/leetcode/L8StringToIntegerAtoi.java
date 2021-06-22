package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-06-22
 * @desc: 字符串转换整数 (atoi)
 */
public class L8StringToIntegerAtoi {

	private String str = "18446744073709551617";

	private static char blank = ' ';

	private static char add = '+';

	private static char subtract = '-';

	private static char zero = '0';

	private static char nine = '9';

	@Test
	public void singlePoint() {
	   int result =	myAtoi(str);
		System.out.println(result);
	}

	private static int myAtoi(String str) {
		if (str == null || str.equals("")){
			return 0;
		}
		int length = str.length();
		int index = 0;
		while (index < length && str.charAt(index) == blank){
			index++;
		}
		boolean fushu = false;
		if (index < length && subtract == str.charAt(index)) {
			fushu = true;
			index++;
		} else if (index < length && add == str.charAt(index)) {
			index++;
		}
		long sum = 0;

		while (index < length && str.charAt(index) >= zero && str.charAt(index) <= nine) {
			sum = sum * 10 + (str.charAt(index) - '0');
			if (sum > Integer.MAX_VALUE) {
				return fushu == true ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			index++;
		}
		if (fushu){
			sum = 0 - sum;
		}
		if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
			sum = fushu == true ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		return (int)sum;
	}

}
