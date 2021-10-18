package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/10/11
 * @desc: 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 **/
public class L55JumpGame {

    @Test
    public void test() {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
        System.out.println(canJump2(nums));
    }

    /**
     * 遇到零往前遍历，看前面是否能跳过零的位置
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        //length - 1 表示最后一个位置不用走了
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                int j = i - 1;
                boolean canSkipZero = false;
                while (j >= 0) {
                    if (nums[j] + j > i) {
                        canSkipZero = true;
                        break;
                    }
                    j--;
                }
                if (!canSkipZero) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * max 记录能跳的最远的下标
     * 遇到零，当前位置和max做比较
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        //记录能跳的最远的下标
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && max <= i) {
                return false;
            }
            max = Math.max(max,nums[i] + i);
        }
        return true;
    }
}
