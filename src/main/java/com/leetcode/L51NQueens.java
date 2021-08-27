package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-27
 * @desc:  N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

	给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

	每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 */
public class L51NQueens {

	@Test
	public void test() {
		int n = 4;
		List<List<String>> lists = solveNQueens(n);
		System.out.println(lists);
	}

	List<List<String>> res = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		// 初始化棋盘 "." 表示空，"Q"表示皇后，
		char[][] board = new char[n][n];
		for (char[] c : board) {
			Arrays.fill(c, '.');
		}
		backtrack(board, 0);
		return res;
	}

	private void backtrack(char[][] board, int row) {
		//终止条件
		if (row == board.length) {
			res.add(charToList(board));
			return;
		}
		//每一行列数(也就是长度)
		int n = board[row].length;
		for (int col = 0; col < n; col++) {
			//排除相互攻击的格子
			if (!isValid(board,row,col)) {
				continue;
			}
			//放入Q
			board[row][col] = 'Q';
			//进入下一行放皇后
			backtrack(board,row + 1);
			//撤销Q
			board[row][col] = '.';
		}


	}

	private boolean isValid(char[][] board, int row, int col) {
		int n = board.length;
		//检查列是否有皇后冲突
		for (int i = 0; i < n; i++) {
			if (board[i][col] == 'Q') {
				return false;
			}
		}
		//检查右上方是否有皇后冲突
		for (int i = row - 1,j = col + 1; i >= 0 && j < n; i--,j++) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		//检查左上方是否有皇后冲突
		for (int i = row - 1,j = col - 1; i >= 0 && j >= 0; i--,j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}

	public List<String> charToList(char[][] board) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			list.add(String.copyValueOf(board[i]));
		}
		return list;
	}

}
