package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-09
 * @desc:  路径总和
 */
public class L112PathSum {

	@Test
	public void test() {
		//root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
		TreeNode treeNode = new TreeNode(5,new TreeNode(4),new TreeNode(6));
		int targetSum = 9;
		boolean flag = hasPathSum(treeNode,targetSum);
		System.out.println(flag);
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		if(root.left == null && root.right == null) {
			return root.val == targetSum;
		}
		int val = root.val;
		return hasPathSum(root.left,targetSum - val) || hasPathSum(root.right,targetSum - val);
	}
}
