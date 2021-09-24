package com.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author: laizc
 * @date: created in 2021/9/24
 * @desc: 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 **/
public class L350IntersectionOfTwoArraysIi {

    @Test
    public void test() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = intersect(nums1,nums2);
        System.out.println(result);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num) + 1);
            } else {
                map.put(num,1);
            }
        }
        int[] nums = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            Integer count = map.getOrDefault(num,0);
            if (count > 0) {
                nums[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num,count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(nums, 0, index);
    }
}
