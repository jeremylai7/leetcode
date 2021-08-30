package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-30
 * @desc: 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。

   例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class L101SymmetricTree {

	@Test
	public void test() {
		TreeNode treeNode2 = new TreeNode(3);
		TreeNode treeNode3 = new TreeNode(4);
		TreeNode treeNode = new TreeNode(2,treeNode2,treeNode3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(3);
		TreeNode treeNode6 = new TreeNode(2,treeNode4,treeNode5);
		TreeNode root = new TreeNode(1,treeNode,treeNode6);
		boolean flag = isSymmetric(root);
		System.out.println(flag);
	}

	public boolean isSymmetric(TreeNode root) {
		return check(root, root);
	}


	private boolean check(TreeNode left,TreeNode right){
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return left.val == right.val && check(left.left,right.right) && check(left.right,right.left) ;
	}

}
