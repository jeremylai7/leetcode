package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/25
 * @desc: 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,1,1],
 *                [1,0,1],
 *                [1,1,1]]
 * 输出：[[1,0,1],
 *       [0,0,0],
 *       [1,0,1]]
 **/
public class L73SetMatrixZeroes {

    @Test
    public void test() {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println(matrix);
        int[][] matrix2 = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        setZeroes2(matrix2);
        System.out.println(matrix2);
        int[][] matrix3 = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        setZeroes3(matrix3);
        System.out.println(matrix3);
    }

    public void setZeroes3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] copyMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (copyMatrix[i][j] == 0) {
                    setRowZero(matrix,i);
                    setColZero(matrix,j);
                }
            }
        }

    }

    private void setRowZero(int[][] matrix,int row) {
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            matrix[row][i] = 0;
        }
    }

    private void setColZero(int[][] matrix,int col) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            matrix[i][col] = 0;
        }
    }

    /**
     * 空间复杂度 O(m + n)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] cloumn = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    cloumn[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || cloumn[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 常量空间复杂度
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowFlag0 = false;
        boolean colFlag0 = false;
        //第一行是否有零
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowFlag0 = true;
                break;
            }
        }
        //第一列是否有零
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colFlag0 = true;
                break;
            }
        }
        //第一行第一列作为标志位
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        //列重置零,排除第一列
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        //行重置零,排除第一行
        for (int i = 1; i < m; i++) {
           if (matrix[i][0] == 0) {
               for (int j = 0; j < n; j++) {
                   matrix[i][j] = 0;
               }
           }
        }
        if (rowFlag0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colFlag0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
