package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/16
 * @desc: 寻找旋转排序数组中的最小值 II
 **/
public class L154FindMinimumInRotatedSortedArrayIi {

    @Test
    public void test() {
        int[] nums = {2,2,2,0,1};
        int result = findMin(nums);
        System.out.println(result);
    }

    /**
     * 使用二分法查找
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low = 0,height = nums.length - 1;
        while(low < height) {
            int mid = low + (height - low)/2;
            if(nums[mid] < nums[height]) {
                height = mid;
            } else if(nums[mid] > nums[height]) {
                low = mid + 1;
            }else {
                height = height - 1;
            }
        }
        return nums[low];
    }

}
