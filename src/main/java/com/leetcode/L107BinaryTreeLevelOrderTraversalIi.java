package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/10/31
 * @desc: 二叉树的层序遍历 II
 *
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层序遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 **/
public class L107BinaryTreeLevelOrderTraversalIi {

    @Test
    public void test() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2,node3,node4);
        TreeNode node2 = new TreeNode(5,null,new TreeNode(6));
        TreeNode root = new TreeNode(1,node1,node2);
        List<List<Integer>> lists = levelOrderBottom(root);
        System.out.println(lists);
    }


    List<List<Integer>> lists;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        lists = new ArrayList<>();
        recall(root,0);
        Collections.reverse(lists);
        return lists;
    }

    private void recall(TreeNode node,int deep) {
        if (node == null) {
            return;
        }
        if (lists.size() == deep) {
            lists.add(deep,new ArrayList<>());
        }
        List<Integer> list = lists.get(deep);
        list.add(node.val);
        recall(node.left,deep + 1);
        recall(node.right,deep + 1);
    }
}
