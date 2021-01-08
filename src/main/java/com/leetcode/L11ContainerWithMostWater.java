package com.leetcode;

import org.junit.Test;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为 (i,ai) 和 (i, 0) 。找出其中的两条线，
 * 使得它们与x轴共同构成的容器可以容纳最多的水。
 */
public class L11ContainerWithMostWater {

    private int[] ARRAY = {1,8,6,2,5,4,8,3,7};


    /**
     * 双指针解法
     */
    @Test
    public void doublePointerTest(){
        int left = 0;
        int right = ARRAY.length -1;
        int max = 0;
        while (left < right) {
            int capacity = Math.min(ARRAY[left],ARRAY[right]) * (right - left);
            if (max < capacity) { max = capacity;}
            if(ARRAY[left] < ARRAY[right]) {
                left++;
            }else{
                right--;
            }


        }
        System.out.println(max);
    }
}
