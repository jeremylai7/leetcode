package com.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: laizc
 * @date: created in 2021/9/23
 * @desc: 有序矩阵中第 K 小的元素
 **/
public class L378KthSmallestElementInASortedMatrix {

    @Test
    public void test() {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int target = 8;
        int result = kthSmallest(matrix,target);
        System.out.println(result);
    }

    /**
     * 直接排序
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[m * n];
        int index = 0;
        for(int[] row : matrix) {
            for(int num : row) {
                nums[index++] = num;
            }
        }
        Arrays.sort(nums);
        return nums[k-1];

    }
}
