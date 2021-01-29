package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: laizc
 * @Date: Created in  2021-01-29
 * @desc: 二叉树前序遍历
 */
public class BinaryTreePreorderTraversal {

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

	/**
	 * 递归解法
	 */
	@Test
	public void recursive() {
		List<Integer> list = new ArrayList<>();
		addOrder(list,treeNode);
		print(list);
	}

	private void addOrder(List<Integer> list,TreeNode treeNode){
		if (treeNode != null){
			list.add(treeNode.value);
			addOrder(list,treeNode.left);
			addOrder(list,treeNode.right);
		}
	}

	/**
	 * 迭代
	 */
	@Test
	public void iteration(){
		Stack<TreeNode> treeNodes = new Stack<>();

	}



	private void print(List<Integer> list){
		for(Integer integer: list) {
			System.out.print(integer +" ");
		}
	}
}
