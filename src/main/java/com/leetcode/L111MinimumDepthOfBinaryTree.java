package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/10/15
 * @desc: 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例 1：
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 **/
public class L111MinimumDepthOfBinaryTree {

    @Test
    public void test() {
        TreeNode node = new TreeNode(1,new TreeNode(2),new TreeNode(4));
        int min = minDepth(node);
        System.out.println(min);
    }

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return getDepth(root);
    }

    private int getDepth(TreeNode node) {
        if(node.left == null && node.right == null) {
            return 1;
        }
        if(node.left == null) {
            return getDepth(node.right) + 1;
        }
        if(node.right == null) {
            return getDepth(node.left) + 1;
        }
        return Math.min(getDepth(node.left),getDepth(node.right)) + 1;

    }
}
