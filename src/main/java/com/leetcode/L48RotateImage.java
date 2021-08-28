package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/8/29
 * @desc:  旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *  
 **/
public class L48RotateImage {

    @Test
    public void test() {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(nums);
        System.out.println(nums);
        int[][] nums2 = {{1,2,3},{4,5,6},{7,8,9}};
        rotate2(nums2);
        System.out.println(nums2);

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][]temp = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                temp[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        //先上下翻转
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        //对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
