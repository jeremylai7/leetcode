package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/10/11
 * @desc: 子集
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 **/
public class L90SubsetsIi {

    @Test
    public void test() {
        int[] nums = {1,2,2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        System.out.println(lists);
    }

    /**
     * 排序后，前后两个相同，则忽略
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        recall(nums,0,new ArrayList<>(),lists);
        return lists;
    }

    private void recall(int[] nums,int start,ArrayList<Integer> temp,List<List<Integer>> lists) {
        lists.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            recall(nums,i + 1,temp,lists);
            temp.remove(temp.size() - 1);
        }
    }
}
