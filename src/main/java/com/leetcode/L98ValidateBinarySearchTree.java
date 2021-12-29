package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/12/29
 * @desc: 验证二叉搜索树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *  
 * 示例 1：
 *
 * 输入：root = [2,1,3]
 * 输出：true
 **/
public class L98ValidateBinarySearchTree {

    @Test
    public void test() {
        TreeNode node = new TreeNode(6,new TreeNode(3),new TreeNode(7));
        TreeNode node1 = new TreeNode(5,new TreeNode(4),node);
        boolean flag = isValidBST(node1);
        System.out.println(flag);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node,long min,long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left,min,node.val) && isValidBST(node.right,node.val,max);
    }
}
