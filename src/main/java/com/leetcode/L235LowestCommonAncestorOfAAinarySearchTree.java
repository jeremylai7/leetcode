package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-09
 * @desc: 二叉搜索树的最近公共祖先
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6
解释: 节点 2 和节点 8 的最近公共祖先是 6。
 */
public class L235LowestCommonAncestorOfAAinarySearchTree {


	@Test
	public void test() {
		TreeNode treeNode = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		treeNode.right = right;
		TreeNode secondLeft = new TreeNode(3);
		right.left =secondLeft;
		TreeNode ancestor = lowestCommonAncestor(treeNode, secondLeft,right);
		System.out.println(ancestor);
	}

	private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pathP = getPath(root,p);
		List<TreeNode> pathQ = getPath(root,q);
		TreeNode treeNode = null;
		for (int i = 0; i < pathP.size() && i < pathQ.size() ; i++) {
			if (pathP.get(i) == pathQ.get(i)){
				treeNode = pathP.get(i);
			} else {
				break;
			}
		}
		return treeNode;
	}

	private List<TreeNode> getPath(TreeNode root, TreeNode target) {
		List<TreeNode> path = new ArrayList<>();
		TreeNode node = root;
		while (node != target && node != null) {
			path.add(node);
			if (target.value < node.value) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		path.add(node);
		return path;

	}

}
