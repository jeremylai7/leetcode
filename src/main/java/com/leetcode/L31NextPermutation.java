package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/10/13
 * @desc: 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 **/
public class L31NextPermutation {

    @Test
    public void test() {
        int[] nums = {1,3,2,5};
        nextPermutation(nums);
        print(nums);
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到第一个不再递增的位置
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        //如果找到最左边，就直接倒置输出
        if (i < 0) {
            reverse(nums,0);
            return;
        }
        //找到刚好大于 nums[i] 的位置
        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }
        //交换
        swap(nums,i,j);



    }

    private void swap(int[] nums,int i,int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start,j = nums.length - 1;
        while (i < j) {
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
