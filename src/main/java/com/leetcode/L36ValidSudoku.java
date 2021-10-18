package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: laizc
 * @Date: Created in  2021-10-18
 * @desc: 有效的数独
 *
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

	数字 1-9 在每一行只能出现一次。
	数字 1-9 在每一列只能出现一次。
	数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
	数独部分空格内已填入了数字，空白格用 '.' 表示。

	注意：

	一个有效的数独（部分已被填充）不一定是可解的。
	只需要根据以上规则，验证已经填入的数字是否有效即可。

 */
public class L36ValidSudoku {

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
		boolean flag = isValidSudoku(nums);
		System.out.println(flag);
	}

	public boolean isValidSudoku(char[][] board) {
		//判断每一行
		for (int i = 0; i < 9; i++) {
			if (!isValidRows(board[i])) {
				return false;
			}
		}
		//判断每一列
		for (int i = 0; i < 9; i++) {
			if (!isValidColumns(i,board)) {
				return false;
			}
		}
		//判断每个小数独
		for (int i = 0; i < 9; i = i+3) {
			for (int j = 0; j < 9; j = j + 3) {
				if (!isValidSmall(i,j,board)){
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValidRows(char[] board) {
		Map<Character,Integer> map = new HashMap<>();
		for (char ch : board) {
			if (ch != '.') {
				//遍历每行，存在就返回false
				if (map.getOrDefault(ch,0) != 0) {
					return false;
				} else {
					map.put(ch,1);
				}

			}
		}
		return true;
	}

	private boolean isValidColumns(int index, char[][] board) {
		Map<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < 9; i++) {
			char ch = board[i][index];
			if (ch != '.') {
				if (map.getOrDefault(ch,0) != 0) {
					return false;
				} else {
					map.put(ch,1);
				}
			}
		}
		return true;
	}

	private boolean isValidSmall(int i, int j, char[][] board) {
		Map<Character,Integer> map = new HashMap<>();
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				char ch = board[k+i][l+j];
				if (ch != '.') {
					if (map.getOrDefault(ch,0) != 0) {
						return false;
					} else {
						map.put(ch,1);
					}
				}


			}
		}
		return true;
	}
}
