package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-06-28
 * @desc: 反转字符串
 */
public class L344ReverseString {

	private char[] s = {'h','e','l','l','o'};

	/**
	 * 双指针，设置两个指针，首数和尾数，每次首数往后移动一位，尾数往前移动一位，一直到首数大于或者等于尾数
	 */
	@Test
	public void doublePoint() {
		swap(0,s.length-1,s);
		print();
	}


	@Test
	public void reverseString(char[] s) {
		int length = s.length;
		char temp;
		for (int i = 0; i <length/2; i++) {
			temp = s[i];
			s[i] = s[length - i - 1];
			s[length -1 - i] = temp;
		}
	}

	private void swap(int start, int end, char[] s){
		if (start >= end){
			return;
		}
		char temp = s[start];
		s[start] = s[end];
		s[end] = temp;
		swap(start + 1,end-1,s);
	}



	private   void print(){
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] +" ");
		}
	}

}
