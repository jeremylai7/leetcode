package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/8
 * @desc: 不同路径 II
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 **/
public class L63UniquePathsIi {

    @Test
    public void test() {
        int[][] nums = {{0,0,0},{1,0,0},{0,0,0}};
        int result = uniquePathsWithObstacles(nums);
        System.out.println(result);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp= new int[m][n];
        for (int i = 0; i < m; i++) {
            //遇到障碍物，停止往下赋值
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            //遇到障碍物，停止往右赋值
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            }else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];

    }
}
