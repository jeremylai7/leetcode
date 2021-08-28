package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/8/28
 * @desc: 组合
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 **/
public class L77Combinations {

    List<List<Integer>> lists;

    LinkedList<Integer> path;

    int end;

    @Test
    public void test() {
        List<List<Integer>> lists = combine(4,2);
        System.out.println(lists);

    }

    public List<List<Integer>> combine(int n, int k) {
        lists = new ArrayList<>();
        end = n;
        path = new LinkedList<>();
        recall(1,k);
        return lists;

    }

    private void recall(int begin,int k) {
        if (path.size() == k) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= end; i++) {
            path.add(i);
            recall(i+ 1,k);
            path.removeLast();
        }

    }
}
