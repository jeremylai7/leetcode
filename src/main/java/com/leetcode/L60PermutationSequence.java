package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/10/18
 * @desc: 排列序列
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 示例 1：
 *
 * 输入：n = 3, k = 3
 * 输出："213"
 * 示例 2：
 *
 * 输入：n = 4, k = 9
 * 输出："2314"
 *
 **/
public class L60PermutationSequence {

    @Test
    public void test() {
        String str = getPermutation(4,9);
        System.out.println(str);
    }


    public String getPermutation(int n, int k) {
        k--;
        int[] factorial = new int[n];
        //算出所有的阶乘值
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k/factorial[i];
            stringBuilder.append(nums.remove(index));
            k = k - index * factorial[i];
        }
        return stringBuilder.toString();
    }
}
