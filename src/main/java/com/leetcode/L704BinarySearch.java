package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/7/18
 * @desc: 二分查找
 **/
public class L704BinarySearch {

    private int[] nums = {-1,0,3,5,9,12};

    private int target = 9;

    @Test
    public void binarySearch () {
        int result = binarySearch(nums,target);
        System.out.println(result);
    }

    private int binarySearch(int[] nums,int target) {
        int left = 0,right=nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left )/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
