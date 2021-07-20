package com.leetcode;

import javafx.scene.media.SubtitleTrack;
import org.junit.Test;

import java.util.*;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-20
 * @desc: 三数之和
 */
public class L15_3sum {

	private int[] nums = {-1,0,1,2,-1,-4};


	@Test
	public void test() {
		List<List<Integer>> lists = test(nums);
		print(lists);
	}

	private List<List<Integer>> test(int[] nums) {
		List<List<Integer>> lists = new ArrayList<>();
		Arrays.sort(nums);
		//for循环 + 双指针
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int target = -nums[i];
			int left = i +1,right = nums.length - 1;
			while (left < right) {
				int sum = nums[left] + nums[right];
				if (sum == target) {
					lists.add(Arrays.asList(nums[i],nums[left],nums[right]));
					//去重
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right -1]) {
						right--;
					}
					left++;
					right--;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return lists;



		/*for (int i = 0; i < nums.length; i++) {
			int first = nums[i];
			Map<Integer,Integer> map = new HashMap<>();
			for (int j = i+1; j < nums.length; j++) {
				int second = nums[j];
				int sum = 0 - first - second;
				if (map.containsKey(sum)) {
					System.out.println(" " + i + " "+ j + " " + map.get(sum));
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(sum);
					lists.add(list);
				} else {
					map.put(nums[j],j);
				}
			}
		}
		return lists;*/
	}

	private void print(List<List<Integer>> lists) {
		for (List<Integer> list: lists) {
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
