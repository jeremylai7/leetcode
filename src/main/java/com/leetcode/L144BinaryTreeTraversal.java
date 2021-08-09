package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-01-29
 * @desc: 二叉树遍历
 */
public class L144BinaryTreeTraversal {

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
	 * 前序递归解法
	 */
	@Test
	public void preOrderRecursive() {
		List<Integer> list = new ArrayList<>();
		addPreOrder(list,treeNode);
		print(list);
	}

	private void addPreOrder(List<Integer> list,TreeNode treeNode){
		if (treeNode != null){
			list.add(treeNode.val);
			addPreOrder(list,treeNode.left);
			addPreOrder(list,treeNode.right);
		}
	}

	/**
	 * 中序递归解法
	 */
	@Test
	public void inOrderRecursive() {
		List<Integer> list = new ArrayList<>();
		addMidOrder(list,treeNode);
		print(list);
	}

	private void addMidOrder(List<Integer> list,TreeNode treeNode){
		if (treeNode != null){
			addMidOrder(list,treeNode.left);
			list.add(treeNode.val);
			addMidOrder(list,treeNode.right);
		}
	}

	/**
	 * 后序递归解法
	 */
	@Test
	public void afterOrderRecursive() {
		List<Integer> list = new ArrayList<>();
		addAfterOrder(list,treeNode);
		print(list);
	}

	private void addAfterOrder(List<Integer> list,TreeNode treeNode){
		if (treeNode != null){
			addAfterOrder(list,treeNode.left);
			addAfterOrder(list,treeNode.right);
			list.add(treeNode.val);
		}
	}




	private void print(List<Integer> list){
		for(Integer integer: list) {
			System.out.print(integer +" ");
		}
	}
}
