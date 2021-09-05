package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/5
 * @desc: 将有序数组转换为二叉搜索树
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 **/
public class L108ConvertSortedArrayToBinarySearchTree {

    @Test
    public void test() {
        int[] nums = {-10,-3,0,5,9};
        TreeNode treeNode = recursive(nums,0,nums.length-1);
        System.out.println(treeNode);

    }

    private TreeNode recursive(int[] nums,int left,int right) {
        if(left > right) {
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = recursive(nums,left,mid-1);
        treeNode.right = recursive(nums,mid+1,right);
        return treeNode;
    }
}
