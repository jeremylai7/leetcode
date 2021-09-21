package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/21
 * @desc: 搜索二维矩阵 II
 **/
public class L240SearchA2dMatrixIi {

    @Test
    public void test() {
        int target = 12;
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean flag = searchMatrix(matrix,target);
        System.out.println(flag);
    }

    private boolean searchMatrix(int[][] matrix,int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0,column = columns - 1;
        while (row < rows && column >= 0) {
            int index= matrix[row][column];
            if (index == target) {
                return true;
            } else if (index < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

}
