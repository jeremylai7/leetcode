package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2022-01-06
 * @desc: 单词搜索
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

	单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。


	示例 1：


	输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
	输出：true

 */
public class L79WordSearch {

	@Test
	public void test() {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		boolean flag = exist(board,word);
		System.out.println(flag);
	}

	public boolean exist(char[][] board, String word) {
		int row = board.length;
		if (row == 0) {
			return false;
		}
		int column = board[0].length;
		boolean[][] visited = new boolean[row][column];

		//每个元素都遍历一次
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (dfs(board,i,j,word,0,visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board,int row,int column,String word,int index,boolean[][] visited) {
		//越界
		if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
			return false;
		}
		// 已经被访问、当前字符不匹配
		if (visited[row][column] || board[row][column] != word.charAt(index)) {
			return false;
		}
		// 匹配到最后一个
		if (index == word.length() - 1) {
			return true;
		}
		visited[row][column] = true;
		// 上下左右遍历
		boolean up = dfs(board,row,column - 1,word,index + 1,visited);
		if (up) {
			return true;
		}
		boolean down = dfs(board,row,column + 1,word,index + 1,visited);
		if (down) {
			return true;
		}
		boolean left = dfs(board,row - 1,column,word,index + 1,visited);
		if (left) {
			return true;
		}
		boolean right = dfs(board,row + 1,column,word,index + 1,visited);
		if (right) {
			return true;
		}
		//当前位置没有传进来，标记为false
		visited[row][column] = false;
		return false;
	}

}
