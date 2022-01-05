package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2022/1/5
 * @desc: 杨辉三角 II
 *
     * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
     *
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     *
     *
     * 示例 1:
     *
     * 输入: rowIndex = 3
     * 输出: [1,3,3,1]
     * 示例 2:
     *
     * 输入: rowIndex = 0
     * 输出: [1]
 *
 **/
public class L119PascalsTriangleIi {

    @Test
    public void test() {
        List<Integer> list = getRow(5);
        System.out.println(list);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = cur;

        }
        return pre;
    }
}
