package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-09
 * @desc: 二叉搜索树中第K小的元素
 */
public class L230KthSmallestElementInABst {

	@Test
	public void test() {
		TreeNode treeNode = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		treeNode.right = right;
		TreeNode secondLeft = new TreeNode(2);
		right.left =secondLeft;
		int result =  kthSmallest(treeNode,1);
		System.out.println(result);

	}


	private int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		addMid(list,root);
		return list.get(k - 1);


	}

	private void addMid(List<Integer> list, TreeNode treeNode){
		if (treeNode == null){
			return;
		}
		addMid(list,treeNode.left);
		list.add(treeNode.val);
		addMid(list,treeNode.right);
	}
}
