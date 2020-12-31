package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
public class L283MoveZeroes {

    private final static Integer[] ARRAY =  {0,1,0,3,12};

    /**
     * 设置一个初始为零的指针index，遍历数组，讲非零的数放在index，index右移。遍历结束后，index剩余数据设置为零
     */
    @Test
    public void test1(){
        int index = 0;
        for (int i = 0; i <ARRAY.length ; i++) {
            if (ARRAY[i] != 0) {
                ARRAY[index] = ARRAY[i];
                index++;
            }
        }
        for (int i = index; i <ARRAY.length ; i++) {
            ARRAY[i] = 0;
        }
        print();
    }

    private void print(){
        for (int i = 0; i < ARRAY.length; i++) {
            System.out.print(ARRAY[i] +" ");
        }
    }

}
