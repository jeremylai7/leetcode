package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-05
 * @desc: 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

  示例 1:
     输入: num1 = "2", num2 = "3"
     输出: "6"
     示例 2:

     输入: num1 = "123", num2 = "456"
     输出: "56088"
 */
public class L43MultiplyStrings {

	@Test
	public void test() {
		String num1 = "9133";
		String num2 = "0";
		String result = multiply(num1,num2);
		System.out.println(result);
	}

	/**
	 * 竖式乘法
	 * @param num1
	 * @param num2
	 * @return
	 */
    private String multiply(String num1, String num2) {
	    if (num1.equals("0") || num2.equals("0")) {
		    return "0";
	    }
    	int m = num1.length();
    	int n = num2.length();
    	int k = 0;
    	String result = "0";
	    for (int i = n-1; i >= 0 ; i--) {
		    int aa = num2.charAt(i) - '0';
		    int carry = 0;
		    StringBuffer stringBuffer = new StringBuffer();
		    for (int j = 0; j < k; j++) {
			    stringBuffer.append('0');
		    }
		    for (int j = m - 1; j >= 0 ; j--) {
		        int bb = num1.charAt(j) - '0';
		        int product = aa * bb + carry;
		        stringBuffer.append(product%10);
			    carry = product/10;
		    }
		    if (carry != 0) {
		    	stringBuffer.append(carry%10);
		    }
		    k++;
		    result = addStrings(result,stringBuffer.reverse().toString());
	    }
		return result;
    }

    private String addStrings(String num1,String num2) {
    	int i = num1.length() - 1;
    	int j = num2.length() - 1;
    	StringBuffer stringBuffer = new StringBuffer();
    	int carry = 0;
    	while (i >= 0 || j >= 0 || carry > 0) {
		    int x = i >= 0 ? num1.charAt(i) - '0' : 0;
		    int y = j >= 0 ? num2.charAt(j) - '0' : 0;
		    int add = x + y + carry;
		    int sum = add%10;
		    carry = add/10;
		    stringBuffer.append(sum);
		    i--;
		    j--;
	    }
	    return stringBuffer.reverse().toString();
    }

}
