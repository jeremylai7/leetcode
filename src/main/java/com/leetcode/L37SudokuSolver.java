package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-10-18
 * @desc: 解数独
 * 编写一个程序，通过填充空格来解决数独问题。

	数独的解法需 遵循如下规则：

	数字 1-9 在每一行只能出现一次。
	数字 1-9 在每一列只能出现一次。
	数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
	数独部分空格内已填入了数字，空白格用 '.' 表示。

 */
public class L37SudokuSolver {
	@Test
	public void test() {
		char[][] nums = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		solver(nums);
	}

	private boolean solver(char[][] board) {
		//遍历每个数，然后迭代
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					char count = '1';
					while (count <= '9') {
						if (isValid(i,j,board,count)) {
							board[i][j] = count;
							if (solver(board)) {
								return true;
							} else {
								//下一个位置没有数字，就还原，尝试在当前位置用新的数
								board[i][j] = '.';
							}
						}
						count++;
					}
					return false;
				}
			}
		}
		return true;

	}

	private boolean isValid(int row, int col, char[][] board, char c) {
		//同一行同一列不存在该字符
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == c) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == c) {
				return false;
			}
		}
		//小矩阵起始坐标
		int startRow = row/3 * 3;
		int startCol = col/3 * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[startRow + i][startCol + j] == c) {
					return false;
				}
			}
		}
		return true;

	}
}
