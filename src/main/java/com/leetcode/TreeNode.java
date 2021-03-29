package com.leetcode;

/**
 * @Author: laizc
 * @Date: Created in  2021-01-29
 * @desc: 二叉树
 */
public class TreeNode {

	int value;

	TreeNode left;

	TreeNode right;

	TreeNode() {}

	TreeNode(int value) { this.value = value; }

	TreeNode(int value, TreeNode left, TreeNode right) {
          this.value = value;
          this.left = left;
          this.right = right;
    }
}
