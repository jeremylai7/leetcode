package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/10/11
 * @desc: 跳跃游戏 II
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 **/
public class L45JumpGameIi {

    @Test
    public void test() {
        int[] nums = {2,3,1,1,4};
        int result = jump(nums);
        System.out.println(result);

    }

    public int jump(int[] nums) {
        //当前能跳的边界
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的下标
            maxPosition = Math.max(maxPosition,nums[i] + i);
            //遇到边界就更新，步数+1
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
