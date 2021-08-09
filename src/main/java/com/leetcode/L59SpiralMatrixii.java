package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-09
 * @desc: 螺旋矩阵 II
 *
 * 输入：n = 3
  输出：[[1,2,3],[8,9,4],[7,6,5]]
[[1,2,3],
[8,9,4],
[7,6,5]]
 */
public class L59SpiralMatrixii {

	@Test
	public void test() {
		int[][] result = generateMatrix(3);
		System.out.println(result);
	}

	public int[][] generateMatrix(int n) {
		int maxNum = n * n;
		int[][] matrix = new int[n][n];
		//用四个坐标表示四个方向 右下左上
		int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
		int directionIndex = 0;
		int row = 0,column = 0;
		int index = 1;
		for (int i = 0; i < maxNum; i++) {
			matrix[row][column] = index++;
			int nextRow = row + directions[directionIndex][0];
			int nextColumn = column + directions[directionIndex][1];
			if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] > 0) {
				directionIndex = (directionIndex + 1)%4;
			}
			row += directions[directionIndex][0];
			column += directions[directionIndex][1];
		}
		return matrix;
	}
}
