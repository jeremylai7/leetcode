package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2022/1/5
 * @desc: 三角形最小路径和
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 **/
public class L120Triangle {

    @Test
    public void test() {
        int n = 4;
        int[] num = {2,3,4,6,5,7,2,1,8,3};
        List<List<Integer>> lists = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(num[index++]);
            }
            lists.add(list);
        }
        int result = minimumTotal(lists);
        System.out.println(result);

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] matrix = new int[n][n];
        matrix[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            matrix[i][0] = matrix[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                matrix[i][j] = Math.min(matrix[i - 1][j - 1],matrix[i - 1][j]) + triangle.get(i).get(j);
            }
            matrix[i][i] = matrix[i - 1][i - 1] + triangle.get(i).get(i);
        }
        //对比最下面一行最小值
        int min = matrix[n - 1][0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min,matrix[n - 1][i]);
        }
        return min;
    }
}
