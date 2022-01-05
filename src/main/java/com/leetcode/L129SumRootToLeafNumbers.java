package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2022-01-05
 * @desc: 求根节点到叶节点数字之和
 *
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
	每条从根节点到叶节点的路径都代表一个数字：

	例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
	计算从根节点到叶节点生成的 所有数字之和 。

	叶节点 是指没有子节点的节点。

	 

	示例 1：


	输入：root = [1,2,3]
	输出：25
	解释：
	从根到叶子节点路径 1->2 代表数字 12
	从根到叶子节点路径 1->3 代表数字 13
	因此，数字总和 = 12 + 13 = 25


 */
public class L129SumRootToLeafNumbers {

	@Test
	public void test() {
		TreeNode node = new TreeNode(11,new TreeNode(7),new TreeNode(2));
		TreeNode node1 = new TreeNode(4,new TreeNode(5),new TreeNode(1));
		TreeNode node2 = new TreeNode(8,new TreeNode(13),node1);
		TreeNode node3 = new TreeNode(4,node,null);
		TreeNode node4 = new TreeNode(5,node3,node2);
		int sum = dfs(node4,0);
		System.out.println(sum);
	}

	public int dfs(TreeNode root,int subSum) {
		if (root == null) {
			return 0;
		}
		int sum = subSum * 10 + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		} else {
			return dfs(root.left,sum) + dfs(root.right,sum);
		}
	}
}
