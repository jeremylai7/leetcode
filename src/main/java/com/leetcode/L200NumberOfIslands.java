package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2022-01-12
 * @desc:  岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

	岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

	此外，你可以假设该网格的四条边均被水包围。

	 

	示例 1：

	输入：grid = [
	["1","1","1","1","0"],
	["1","1","0","1","0"],
	["1","1","0","0","0"],
	["0","0","0","0","0"]
	]
	输出：1
	示例 2：

	输入：grid = [
	["1","1","0","0","0"],
	["1","1","0","0","0"],
	["0","0","1","0","0"],
	["0","0","0","1","1"]
	]
	输出：3

 */
public class L200NumberOfIslands {

	@Test
	public void test() {
		char[][] nums = {{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}};
		int num = numIslands(nums);
		System.out.println(num);
	}

	/**
	 * 深度优先
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int rows = grid.length;
		int columns = grid[0].length;
		int numIslands = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == '1') {
					numIslands++;
					dfs(grid,i,j);
				}
			}
		}
		return numIslands;
	}

	private void dfs(char[][] grid,int i,int j) {
		int row = grid.length;
		int column = grid[0].length;
		if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		//上右下左
		dfs(grid,i - 1,j);
		dfs(grid,i,j + 1);
		dfs(grid,i + 1,j);
		dfs(grid,i,j - 1);

	}

}
