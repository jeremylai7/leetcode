package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/9
 * @desc: 相同的树
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 **/
public class L100SameTree {

    @Test
    public void test() {
        //p = [1,2,3], q = [1,2,3]
        TreeNode treeNode = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode treeNode2 = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        boolean same = isSameTree(treeNode,treeNode2);
        System.out.println(same);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        } else if(p == null || q == null) {
            return false;
        } else if(p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }

    }
}
