package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-10
 * @desc: 二叉树的最近公共祖先
 */
public class L236LowestCommonAncestorOfABinaryTree {

	@Test
	public void test() {
		TreeNode treeNode = new TreeNode(6);
		TreeNode treeNode1 = new TreeNode(2);
		TreeNode treeNode2 = new TreeNode(5,treeNode,treeNode1);
		TreeNode treeNode5 = new TreeNode(0);
		TreeNode treeNode6 = new TreeNode(8);
		TreeNode treeNode3 = new TreeNode(1,treeNode5,treeNode6);
		TreeNode treeNode4 = new TreeNode(3,treeNode2,treeNode3);
		TreeNode treeNode7 = lowestCommonAncestor(treeNode4,treeNode,treeNode1);
		System.out.println(treeNode7);
	}


	private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//遍历到叶子节点返回null，遍历到p,q返回p,q
		if (root == null || root == p || root == q) {
			return root;
		}
		System.out.println(root.val);
		//递归遍历左右节点
		TreeNode left =  lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		if(left == null && right == null) {
			return null;
		}
		if(left == null) {
			return right;
		}
		if(right == null) {
			return left;
		}
		return root;
	}
}
