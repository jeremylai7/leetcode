package com.leetcode;

/**
 * @Author: laizc
 * @Date: Created in  2021-01-29
 * @desc: 二叉树
 */
public class TreeNode {

	int val;

	TreeNode left;

	TreeNode right;

	TreeNode() {}

	TreeNode(int value) { this.val = value; }

	TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
}
