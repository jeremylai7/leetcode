package com.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: laizc
 * @date: created in 2021/9/7
 * @desc: N皇后 II
 **/
public class L52NQueensIi {

    @Test
    public void test() {
        int result = totalNQueens(4);
        System.out.println(result);
    }

    int size = 0;

    public int totalNQueens(int n) {
        // 初始化棋盘 "." 表示空，"Q"表示皇后，
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtrack(board, 0);
        return size;

    }

    private void backtrack(char[][] board, int row) {
        //终止条件
        if (row == board.length) {
            size++;
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
}
