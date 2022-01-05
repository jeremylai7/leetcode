package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2022-01-05
 * @desc: 路径总和 II
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

	叶子节点 是指没有子节点的节点。

	 

	示例 1：


	输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
	输出：[[5,4,11,2],[5,8,4,5]]


 */
public class L113PathSumIi {

	@Test
	public void test() {
		TreeNode node = new TreeNode(11,new TreeNode(7),new TreeNode(2));
		TreeNode node1 = new TreeNode(4,new TreeNode(5),new TreeNode(1));
		TreeNode node2 = new TreeNode(8,new TreeNode(13),node1);
		TreeNode node3 = new TreeNode(4,node,null);
		TreeNode node4 = new TreeNode(5,node3,node2);
		List<List<Integer>> lists = pathSum(node4,22);
		System.out.println(lists);
	}

	List<List<Integer>> lists;

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		lists = new ArrayList<>();
		if (root == null) {
			return lists;
		}
		List<Integer> list = new ArrayList<>();
		recall(root,targetSum,list);
		return lists;
	}

	private void recall(TreeNode root, int target,List<Integer> list) {
		if (root == null) {
			return;
		}
		// list 是引用传递，在每个路径下新建一个 subList
		List<Integer> subList = new ArrayList<>(list);
		subList.add(root.val);
		if (root.left == null && root.right == null) {
			if (root.val == target) {
				lists.add(subList);
			}
			return;
		}
		recall(root.left,target - root.val,subList);
		recall(root.right,target - root.val,subList);

	}


}
