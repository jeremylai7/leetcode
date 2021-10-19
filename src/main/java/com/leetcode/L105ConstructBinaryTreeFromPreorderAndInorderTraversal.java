package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: laizc
 * @Date: Created in  2021-10-19
 * @desc: 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。

	示例 1:

	Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
	Output: [3,9,20,null,null,15,7]
	示例 2:

	Input: preorder = [-1], inorder = [-1]
	Output: [-1]

 */
public class L105ConstructBinaryTreeFromPreorderAndInorderTraversal {

	private Map<Integer, Integer> indexMap;

	@Test
	public void test() {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode node = buildTree(preorder,inorder);
		System.out.println(node);
	}


	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		//构建hash映射，定位根节点
		indexMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			indexMap.put(inorder[i],i);
		}
		return myBuildTree(preorder,0,n - 1,0);
	}

	public TreeNode myBuildTree(int[] preorder, int preorder_left, int preorder_right, int inorder_left) {
		if (preorder_left > preorder_right) {
			return null;
		}
		//前序遍历第一个节点就是根节点
		int preorderRoot = preorder_left;
		//中序定位根节点
		int inorderRoot = indexMap.get(preorder[preorderRoot]);
		//先把根节点建立起来
		TreeNode root = new TreeNode(preorder[preorderRoot]);
		//得到左子树中的节点数目
		int leftSubtreeSize = inorderRoot - inorder_left;
		//递归构造左子树，并连接倒根节点
		//先序遍历中
		root.left = myBuildTree(preorder,preorder_left + 1,preorder_left + leftSubtreeSize,inorder_left);
		//递归构造右子树
		root.right = myBuildTree(preorder,preorder_left + leftSubtreeSize + 1,preorder_right,inorderRoot + 1);
		return root;
	}

}
