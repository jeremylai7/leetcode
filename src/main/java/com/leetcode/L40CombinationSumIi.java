package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-24
 * @desc: 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

   candidates 中的每个数字在每个组合中只能使用一次。

   注意：解集不能包含重复的组合。 
	示例 1:

	输入: candidates = [10,1,2,7,6,1,5], target = 8,
	输出:
	[
	[1,1,6],
	[1,2,5],
	[1,7],
	[2,6]
	]



 */
public class L40CombinationSumIi {

	List<List<Integer>> list = new ArrayList<>();

	int[] candidate;

	@Test
	public void test() {
		int[] nums = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> list = combinationSum2(nums,target);
		System.out.println(list);
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		candidate = candidates;
		recall(0,target,new LinkedList<>());
		return list;
	}

	private void recall(int start, int target, LinkedList<Integer> path) {
		if (target == 0) {
			list.add(new ArrayList<>(path));
			return;
		}
		for (int i = start; i <candidate.length ; i++) {
			if (i > start && candidate[i] == candidate[i-1]) {
				continue;
			}
			int sub = target - candidate[i];
			if (sub < 0) {
				break;
			}
			path.add(candidate[i]);
			recall(i + 1,sub,path);
			path.removeLast();
		}
	}
}
