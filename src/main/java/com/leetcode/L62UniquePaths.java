package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/8/9
 * @desc: 不同路径
 **/
public class L62UniquePaths {

    @Test
    public void test() {
        int result = uniquePaths(3,2);
        System.out.println(result);


    }

    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            nums[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            nums[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = nums[i][j-1] + nums[i-1][j];
            }
        }
        return nums[m-1][n-1];
    }
}
