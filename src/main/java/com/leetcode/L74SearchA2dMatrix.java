package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/11
 * @desc: 搜索二维矩阵
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 * 示例 1：
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 **/
public class L74SearchA2dMatrix {

    @Test
    public void test() {
        int[][] nums = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean flag = searchMatrix(nums,3);
        System.out.println(flag);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //一次二分法
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int midValue = matrix[mid/n][mid%n];
            if (target < midValue) {
                right = mid - 1;
            }else if (target > midValue) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;

    }

}
