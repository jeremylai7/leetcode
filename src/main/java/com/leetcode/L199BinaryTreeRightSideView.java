package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2022-01-18
 * @desc: 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

 	示例 1:

	输入: [1,2,3,null,5,null,4]
	输出: [1,3,4]
	示例 2:

	输入: [1,null,3]
	输出: [1,3]


 */
public class L199BinaryTreeRightSideView {
	@Test
	public void test() {



	}

	List<Integer> list;

	public List<Integer> rightSideView(TreeNode root) {
		list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		recall(root,0);
		return list;
	}

	private void recall(TreeNode node,int deep) {
		if (node == null) {
			return;
		}
		if (list.size() <= deep) {
			list.add(node.val);
		} else {
			list.set(deep,node.val);
		}
		recall(node.left,deep + 1);
		recall(node.right,deep + 1);
	}
}
