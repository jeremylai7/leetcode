package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/10/31
 * @desc: 二叉树展开为链表
 **/
public class L114FlattenBinaryTreeToLinkedList {

    @Test
    public void test() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2,node3,node4);
        TreeNode node2 = new TreeNode(5,null,new TreeNode(6));
        TreeNode root = new TreeNode(1,node1,node2);
        flatten(root);
        System.out.println(root);

    }

    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为null，直接使用右节点
            if (root.left == null) {
                root = root.right;
            } else {
                //找到左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来右子树接到左子树的最右节点
                pre.right = root.right;
                //将左子树移动到右子树
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }


    }
}
