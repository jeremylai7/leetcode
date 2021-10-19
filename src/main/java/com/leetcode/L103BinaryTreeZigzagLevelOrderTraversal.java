package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-10-19
 * @desc:  二叉树的锯齿形层序遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

	例如：
	给定二叉树 [3,9,20,null,null,15,7],

	3
	/ \
	9  20
	/  \
	15   7
	返回锯齿形层序遍历如下：

	[
	[3],
	[20,9],
	[15,7]
	]

 */
public class L103BinaryTreeZigzagLevelOrderTraversal {

	@Test
	public void test() {
		TreeNode treeNode = new TreeNode(20,new TreeNode(15),new TreeNode(7));
		TreeNode treeNode1 = new TreeNode(3,new TreeNode(9),treeNode);
		List<List<Integer>> lists = zigzagLevelOrder(treeNode1);
		System.out.println(lists);
	}

	List<List<Integer>> lists;

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		lists = new ArrayList<>();
		recall(root,0);
		return lists;
	}

	private void recall(TreeNode node,int dept) {
		if (node == null) {
			return;
		}
		if (lists.size() <= dept){
			lists.add(new ArrayList<>());
		}
		List<Integer> list = lists.get(dept);
		//从左往右
		if (dept%2 == 0) {
			list.add(node.val);
		} else {
			list.add(0,node.val);
		}

		recall(node.left,dept+1);
		recall(node.right,dept + 1);

	}
}
