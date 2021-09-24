package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/24
 * @desc: 递增的三元子序列
 *
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * 示例 2：
 *
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 示例 3：
 *
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 *
 **/
public class L334IncreasingTripletSubsequence {

    @Test
    public void test() {
        int[] nums = {2,1,5,0,4,6};
        boolean flag = increasingTriplet(nums);
        System.out.println(flag);
    }

    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if(length < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for(int i = 0;i < length;i++) {
            int num = nums[i];
            if(num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
