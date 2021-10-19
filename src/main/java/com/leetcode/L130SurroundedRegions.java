package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-10-19
 * @desc: 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例 1：

输入：board = [["X","X","X","X"],
               ["X","O","O","X"],
              ["X","X","O","X"],
              ["X","O","X","X"]]

输出：       [["X","X","X","X"],
             ["X","X","X","X"],
             ["X","X","X","X"],
             ["X","O","X","X"]]
解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

 */
public class L130SurroundedRegions {

	@Test
	public void test() {
		char[][] board = {{'X', 'O', 'X', 'O', 'X', 'O'},
				{'O', 'X', 'O', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'O', 'X', 'O'},
				{'O', 'X', 'O', 'X', 'O', 'X'}};
		solve(board);
		System.out.println(board);
	}


	int m,n;
	char[][] board;

	/**
	 * 广度遍历
	 * @param board
	 */
	public void solve(char[][] board) {
		m = board.length;
		if (m == 0) {
			return;
		}
		n = board[0].length;
		this.board = board;
		//遍历第一列和最后一列
		for (int i = 0; i < m; i++) {
			dfs(i,0);
			dfs(i,n - 1);
		}
		//遍历第一行和最后一行
		for (int i = 0; i < n; i++) {
			dfs(0,i);
			dfs(m - 1,i);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'A') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}


	}


	public void dfs(int x,int y) {
		if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
			return;
		}
		board[x][y] = 'A';
		//遍历
		dfs(x + 1,y);
		dfs(x - 1,y);
		dfs(x,y + 1);
		dfs(x,y - 1);
	}

}
