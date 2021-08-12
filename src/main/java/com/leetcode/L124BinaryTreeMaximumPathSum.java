package com.leetcode;

import org.junit.Test;

import javax.xml.soap.Node;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-12
 * @desc: 二叉树中的最大路径和
 */
public class L124BinaryTreeMaximumPathSum {

	private int max = Integer.MIN_VALUE;

	@Test
	public void test() {
		TreeNode treeNode = new TreeNode(6);
		TreeNode treeNode1 = new TreeNode(2);
		TreeNode treeNode2 = new TreeNode(5,treeNode,treeNode1);
		TreeNode treeNode5 = new TreeNode(0);
		TreeNode treeNode6 = new TreeNode(8);
		TreeNode treeNode3 = new TreeNode(1,treeNode5,treeNode6);
		TreeNode treeNode4 = new TreeNode(3,treeNode2,treeNode3);
		int max = maxPathSum(treeNode4);
		System.out.println(max);
	}

	private int maxPathSum(TreeNode root) {
		maxGain(root);
		return max;
	}

	private int maxGain(TreeNode node) {
		if (node == null) {
			return 0;
		}
		//递归计算左右子节点的最大值
		int left = Math.max(maxGain(node.left),0);
		int right = Math.max(maxGain(node.right),0);
		//节点最大路径和取决于该节点的左右子节点的最大贡献值
		int newPath = node.val + left + right;
		max = Math.max(newPath,max);
		return node.val + Math.max(left,right);
	}
}
