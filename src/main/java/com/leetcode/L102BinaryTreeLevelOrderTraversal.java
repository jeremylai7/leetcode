package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-01-29
 * @desc: 层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

 

	示例：
	二叉树：[3,9,20,null,null,15,7],

	3
	/ \
	9  20
	/  \
	15   7
	返回其层序遍历结果：

	[
	[3],
	[9,20],
	[15,7]
	]
 */
public class L102BinaryTreeLevelOrderTraversal {

	@Test
	public void test(){
		TreeNode treeNode = new TreeNode(20,new TreeNode(15),new TreeNode(7));
		TreeNode treeNode1 = new TreeNode(3,new TreeNode(9),treeNode);
		List<List<Integer>> lists = levelOrder(treeNode1);
		System.out.println(lists);

	}

	List<List<Integer>> lists = new ArrayList<>();

	public List<List<Integer>> levelOrder(TreeNode root) {
		recall(root,0);
		return lists;
	}

	private void recall(TreeNode treeNode,int deep) {
		if (treeNode == null) {
			return;
		}
		if (lists.size() <= deep) {
			lists.add(new ArrayList<>());
		}
		List<Integer> list = lists.get(deep);
		list.add(treeNode.val);
		recall(treeNode.left,deep+1);
		recall(treeNode.right,deep+1);
	}
}
