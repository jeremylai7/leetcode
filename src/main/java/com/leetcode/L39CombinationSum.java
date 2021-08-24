package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-24
 * @desc: 组合总和
 */
public class L39CombinationSum {

	List<List<Integer>> list = new ArrayList<>();

	int[] candidate;

	@Test
	public void test() {
		int[] candidates = {2,7,6,3,5,1};
		int target = 9;
		List<List<Integer>> list = combinationSum(candidates,target);
		System.out.println(list);
	}



	public List<List<Integer>> combinationSum(int[] candidates,int target) {
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
			int sub = target - candidate[i];
			if (sub < 0) {
				break;
			}
			path.add(candidate[i]);
			recall(i,sub,path);
			path.removeLast();
		}
	}

}
