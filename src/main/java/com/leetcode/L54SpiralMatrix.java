package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-09
 * @desc: 旋转矩阵
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
   输出：[1,2,3,6,9,8,7,4,5]
 */
public class L54SpiralMatrix {

	private int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};

	@Test
	public void test() {
		List<Integer> result = spiralOrder(nums);
		System.out.println(result);
	}

	private List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		//行
		int rows = matrix.length;
		//列
		int columns = matrix[0].length;
		boolean[][] visited = new boolean[rows][columns];
		int total = rows * columns;
		int row = 0,column = 0;
		//用四个坐标表示四个方向
		int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
		//开始方向向右
		int directionIndex = 0;
		for (int i = 0; i < total; i++) {
			result.add(matrix[row][column]);
			visited[row][column] = true;
			int nextRow = row + directions[directionIndex][0];
			int nextColumn = column + directions[directionIndex][1];
			//下一个不符合要求
			if (nextRow < 0 || nextRow >= matrix.length || nextColumn < 0 || nextColumn >= matrix[0].length || visited[nextRow][nextColumn]) {
				directionIndex = (directionIndex + 1)%4;
			}
			row += directions[directionIndex][0];
			column += directions[directionIndex][1];
		}
		return result;
	}
}
