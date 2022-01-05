package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: laizc
 * @Date: Created in  2022-01-05
 * @desc:  从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。

	注意:
	你可以假设树中没有重复的元素。

	例如，给出

	中序遍历 inorder = [9,3,15,20,7]
	后序遍历 postorder = [9,15,7,20,3]
	返回如下的二叉树：

	3
	/ \
	9  20
	/  \
	15   7


 */
public class L106ConstructBinaryTreeFromInorderAndPostorderTraversal {
	@Test
	public void test() {
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		TreeNode treeNode = buildTree(inorder,postorder);
		System.out.println(treeNode);
	}

	private Map<Integer, Integer> indexMap = new HashMap<>();

	private int postIndex;

	private int[] postorder;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.postorder = postorder;
		//中序构建 hash 映射
		int n = inorder.length;
		for (int i = 0; i < n; i++) {
			indexMap.put(inorder[i],i);
		}
		//后序最后一个数开始
		postIndex = postorder.length - 1;
		return myBuildTree(0,inorder.length-1);
	}

	private TreeNode myBuildTree(int inLeft,int inRight) {
		if (inLeft > inRight) {
			return null;
		}
		//找到根节点
		int rootValue = postorder[postIndex];
		TreeNode root = new TreeNode(rootValue);
		//根据中序 root 位置分成左右两个子树
		int index = indexMap.get(rootValue);
		postIndex--;
		//构建右子树
		root.right = myBuildTree(index + 1,inRight);
		//构建左子树
		root.left = myBuildTree(inLeft,index - 1);
		return root;

	}

}
