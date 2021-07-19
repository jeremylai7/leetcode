package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/7/19
 * @desc: 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 **/
public class L88MergeSortedArray {

    private int[] nums1 = {1,2,3,0,0};

    private int[] nums2 = {2,5,6};

    private int m = 3;

    private int n = 3;

    @Test
    public void doublePoint() {
        doublePoint(nums1,m,nums2,n);
    }

    private void doublePoint(int[] nums1,int m,int[] nums2,int n) {
        int p1 = 0,p2 = 0;
        int[] sort = new int[m + n];
        while (p1 < m || p2 < n) {
            int cursor;
            //p1遍历完了，遍历p2
            if (p1 == m) {
                cursor = nums2[p2++];
            //p2遍历完了，遍历p1
            } else if (p2 == n) {
                cursor = nums1[p1++];
            }else if (nums1[p1] < nums2[p2]) {
                cursor = nums1[p1++];
            } else {
                cursor = nums2[p2++];
            }
            sort[p1 + p2 - 1] = cursor;
        }
        for (int i = 0; i < sort.length; i++) {
            nums1[i] = sort[i];
        }
        System.out.println(nums1);
    }

}
