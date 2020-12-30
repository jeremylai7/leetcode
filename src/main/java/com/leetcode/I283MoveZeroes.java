package com.leetcode;

import org.junit.Test;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class I283MoveZeroes {

    private static Integer[] array =  {0,1,0,3,12};

    @Test
    public void test1(){
        int index = 0;
        for (int i = 0; i <array.length ; i++) {
            if (array[i] != 0) {
                array[index] = array[i];
                index++;
            }
        }
        for (int i = index; i <array.length ; i++) {
            array[i] = 0;
        }
    }

}
