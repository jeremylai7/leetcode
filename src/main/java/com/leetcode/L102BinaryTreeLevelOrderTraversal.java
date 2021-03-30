package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-01-29
 * @desc: 层序遍历
 */
public class L102BinaryTreeLevelOrderTraversal {

	private static TreeNode treeNode = null;

	/**
	 * 初始化，生成二叉树
	 */
	static {
		TreeNode treeNode = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		treeNode.right = right;
		TreeNode secondLeft = new TreeNode(3);
		right.left =secondLeft;
	}

	@Test
	public void test(){

	}
}
