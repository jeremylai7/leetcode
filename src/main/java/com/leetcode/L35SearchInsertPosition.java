package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/7/18
 * @desc:  搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 **/
public class L35SearchInsertPosition {

    private int[] nums = {1,3,5,6};

    private int target = 5;

    /**
     * 二分查找
     */
    @Test
    public void binary() {
        int result = binary(nums,target);
        System.out.println(result);
    }

    private int binary(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0,right = nums.length - 1,ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

    }
}
