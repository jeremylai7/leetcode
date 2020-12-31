package com.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: laizc
 * @Date: Created in  2020-12-31
 * @desc: 存在重复元素
 *给定一个整数数组，判断是否存在重复元素。
 *
 *如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false
 *
 *
 */
public class L217ContainsDuplicate {

	private static int[] ARRAY = {1,1,1,3,3,4,3,2,4,2};

	/**
	 * 先排序数组，然后遍历，和前一个数对比，相等即为重复
	 */
	@Test
	public void testSort(){
		Arrays.sort(ARRAY);
		boolean repeat = false;
		for (int i = 1; i < ARRAY.length; i++) {
			if (ARRAY[i-1] == ARRAY[i]){
				repeat = true;
				break;
			}
		}
		System.out.println(repeat);
	}

	/**
	 * 添加到set集合，如果发现set集合有数据，add
	 */
	@Test
	public void testSet(){
		Set<Integer> set = new HashSet<>();
		boolean repeat = false;
		for (int i = 1; i < ARRAY.length; i++) {
			if (!set.add(ARRAY[i])){
				repeat = true;
			}
		}
		System.out.println(repeat);
	}
}
