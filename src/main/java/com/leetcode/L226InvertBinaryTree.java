package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-12-30
 * @desc:  翻转二叉树
 *
 * 翻转一棵二叉树。

	示例：

	输入：

	4
	/   \
	2     7
	/ \   / \
	1   3 6   9
	输出：

	4
	/   \
	7     2
	/ \   / \
	9   6 3   1
 */
public class L226InvertBinaryTree {

	@Test
	public void test() {
		TreeNode treeNode = new TreeNode(2,new TreeNode(1),new TreeNode(3));
		TreeNode treeNode1 = new TreeNode(7,new TreeNode(6),new TreeNode(9));
		TreeNode treeNode2 = new TreeNode(4,treeNode,treeNode1);
		TreeNode treeNode3 = invertTree(treeNode2);
		System.out.println(treeNode3);
	}

	TreeNode root;

	public TreeNode invertTree(TreeNode node) {
		root = node;
		recall(node);
		return root;
	}

	private TreeNode recall(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode left = node.left;
		TreeNode right = node.right;
		TreeNode temp = left;
		node.left = right;
		node.right = temp;
		recall(node.left);
		recall(node.right);
		return root;
	}

}
