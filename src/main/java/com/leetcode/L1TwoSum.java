package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: laizc
 * @Date: Created in  2020-12-31
 * @desc:  两数之和
 *给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 示例:
 给定 nums = [2, 7, 11, 15], target = 9
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 *
 */
public class L1TwoSum {

	private final static Integer[] ARRAY =  {8,2, 7, 11, 15};

	private final static int TARGET = 9;

	/**
	 * 暴力枚举
	 */
	@Test
	public void violenceTest() {
		int[] resultArray = null;
		for (int i = 0; i < ARRAY.length; i++) {
			for (int j = i; j < ARRAY.length; j++) {
				if (ARRAY[j] == TARGET - ARRAY[i]) {
					resultArray = new int[]{i,j};
				}
			}
		}
		print(resultArray);
	}

	/**
	 * 哈希表
	 */
	@Test
	public void hashMapTest(){
		int[] resultArray = null;
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i <ARRAY.length ; i++) {
			int sub = TARGET - ARRAY[i];
			if (map.containsKey(sub)) {
				resultArray = new int[]{i,map.get(sub)};
			}else {
				map.put(ARRAY[i],i);
			}
		}
		print(resultArray);
	}


	private void print(int[] arrays){
		for(int array : arrays){
			System.out.println(array + " ");
		}
	}
}
