package com.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: laizc
 * @date: created in 2021/10/30
 * @desc: 只出现一次的数字 III
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 *
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 *
 **/
public class L260SingleNumberIii {

    @Test
    public void test() {
        int[] nums = {1,2,1,3,2,5};
        int[] result = singleNumber(nums);
        System.out.println(result);

    }


    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] array = new int[2];
        int index = 0;
        for (int x: set) {
            array[index++] = x;
        }
        return array;
    }
}
