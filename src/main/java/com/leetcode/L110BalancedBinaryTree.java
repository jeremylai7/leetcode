package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/10/14
 * @desc: 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 **/
public class L110BalancedBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        boolean flag = isBalanced(treeNode);
        System.out.println(flag);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        //左右两个子树都是平衡二叉树
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getTreeDepth(TreeNode node){
        if (node == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(node.left);
        int rightDepth = getTreeDepth(node.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
