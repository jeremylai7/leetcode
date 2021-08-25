package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-25
 * @desc: 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

	示例 1：

	输入：nums = [1,1,2]
	输出：
	[[1,1,2],
	[1,2,1],
	[2,1,1]]

 *
 */
public class L47PermutationsIi {

	private boolean[] used;


	private LinkedList<Integer> path;

	List<List<Integer>> lists;

	@Test
	public void test() {
		int[] nums = {1,1,2};
		List<List<Integer>> lists = permuteUnique(nums);
		System.out.println(lists);

	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		path = new LinkedList<>();
		used = new boolean[nums.length];
		lists = new ArrayList<>();
		Arrays.sort(nums);
		recall(nums);
		return lists;
	}

	private void recall(int[] nums) {
		if (path.size() == nums.length) {
			lists.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length ; i++) {
			if (used[i] || (i > 0 && nums[i] == nums[i-1] && used[i-1])) {
				continue;
			}
			used[i] = true;
			path.add(nums[i]);
			recall(nums);
			path.removeLast();
			used[i] = false;
		}
	}
}
