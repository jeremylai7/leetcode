package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/14
 * @desc: 旋转数组
 **/
public class L189RotateArray {

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
        int[] nums2 = {1,2,3,4,5,6,7};
        rotate2(nums2,k);
        System.out.println(nums2);

    }

    /**
     * 使用额外的数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] num = new int[n];
        for(int i = 0;i < n;i++) {
            num[(i + k)%n] = nums[i];
        }
        System.arraycopy(num,0,nums,0,n);
    }

    /**
     * 数组翻转 k = 3 n = 7
     * 原始数组	    1 2 3 4 5 6 7
     * 翻转所有元素	7 6 5 4 3 2 1
     * 翻转 [0, k%n - 1] 区间的元素	5 6 7 4 3 2 1
     * 翻转 [k%n, n - 1] 区间的元素	5 6 7 1 2 3 4
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int m = nums.length;
        if (nums.length > 0) {
            roll(nums,0,m - 1);
            roll(nums,0,k%m - 1);
            roll(nums,k%m,m - 1);
        }

    }

    private void roll(int[] nums,int left,int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
