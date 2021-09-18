package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/18
 * @desc: 接雨水
 **/
public class L42TrappingRainWater {

    @Test
    public void test() {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(nums);
        System.out.println(result);
    }

    public int trap(int[] height) {
        int sum = 0;
        int max = 0;
        //找到数组的最大值
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        //一层层遍历
        for (int i = 1; i <= max; i++) {
            boolean isStart = false;
            int temp = 0;
            for (int j = 0; j < height.length; j++) {
                //计算已经开始，开始累积
                if (isStart && height[j] < i) {
                    temp++;
                }
                //大于等于i,开始计算雨，结束再次进入结束计算
                if (height[j] >= i) {
                    sum += temp;
                    temp = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

}
