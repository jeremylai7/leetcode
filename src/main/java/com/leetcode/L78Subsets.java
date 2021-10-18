package com.leetcode;

import org.junit.Test;

import java.util.*;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

/**
 * @author: laizc
 * @date: created in 2021/8/8
 * @desc: 子集
 **/
public class L78Subsets {

    private final int[] nums = {1,2,3};

    @Test
    public void test() {
        List<List<Integer>> lists =  subsets(nums);
        System.out.println(lists);
        System.out.println(subsets2(nums));

    }

    /**
     * 迭代
     * 遍历各个元素，遍历之前都要添加前面添加的数据
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newList = new ArrayList<>();
                List<Integer> list = result.get(j);
                //防止空指针异常
                if (list.size() > 0) {
                    newList.addAll(list);

                }
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }

    /**
     * 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        recall(nums,0,new ArrayList<>(),lists);
        return lists;
    }

    private void recall(int[] nums,int start,ArrayList<Integer> temp,List<List<Integer>> lists) {
        lists.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            recall(nums,i + 1,temp,lists);
            temp.remove(temp.size() - 1);
        }

    }

}
