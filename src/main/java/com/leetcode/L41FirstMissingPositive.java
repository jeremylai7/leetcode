package com.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: laizc
 * @date: created in 2021/9/8
 * @desc: 缺失的第一个正数
 **/
public class L41FirstMissingPositive {

    @Test
    public void test() {
        int[] nums = {3,4,-1,1};
        int result = firstMissingPositive(nums);
        System.out.println(result);
    }

    /**
     * 使用hash表存储
     * 缺失的正数一定在1 ~ N+1 之间
     * 首先使用hash表存储数据，然后遍历1~N,不再1-N就返回，否则返回N+1.
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)){
                return i;
            }
        }
        return n+1;
    }
}
