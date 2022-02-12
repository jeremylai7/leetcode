package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2022-02-12
 * @desc: 飞地的数量
 */
public class L1020NumberOfEnclaves {
	@Test
	public void test() {
		//int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
		int[][] grid2 = {{0,1,1,0},
				{0,0,1,0},
				{0,0,1,0},
				{0,0,0,0}};
		int num = numEnclaves(grid2);
		System.out.println(num);
	}

	private int rows,columns;

	private boolean[][] visited;


	public int numEnclaves(int[][] grid) {
		rows = grid.length;
		if (rows == 0) {
			return 0;
		}
		columns = grid[0].length;
		visited = new boolean[rows][columns];
		//左右边界遍历
		for (int i = 0; i < rows; i++) {
			dfs(grid,i,0);
			dfs(grid,i,columns - 1);
		}
		//上下边界遍历
		for (int j = 1; j < columns -1; j++) {
			System.out.println(grid[0][j]);
			dfs(grid,0,j);
			dfs(grid,rows - 1,j);
		}
		int enclaves = 0;
		for (int i = 1; i < rows -1; i++) {
			for (int j = 1; j < columns - 1; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					enclaves++;
				}
			}
		}
		return enclaves;


	}

	private void dfs(int[][] grid,int i,int j) {
		if (i < 0 || i >= rows || j < 0 || j >= columns || grid[i][j] == 0 || visited[i][j]) {
			return;
		}
		visited[i][j] = true;
		// 上 右 下 左
		dfs(grid,i - 1,j);
		dfs(grid,i,j + 1);
		dfs(grid,i + 1,j);
		dfs(grid,i,j - 1);
	}
}
