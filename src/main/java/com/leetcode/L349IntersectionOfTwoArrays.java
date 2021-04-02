package com.leetcode;

import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author: laizc
 * @Date: Created in  2021-04-02
 * @desc: 两个数组的交集
 */
public class L349IntersectionOfTwoArrays {

	private int[] num1 = {1,2,2,1};

	private int[] num2 = {2,2};


	@Test
	public void violenceTest() {
		Set<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < num1.length; i++) {
			for (int j = 0; j < num2.length ; j++) {
				if (num1[i] == num2[j]) {
					set.add(num1[i]);
					break;
				}
			}
		}
		Integer[] array = set.toArray(new Integer[0]);
		System.out.println(array);
	}




}
