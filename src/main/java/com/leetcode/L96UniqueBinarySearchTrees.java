package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2023/1/31
 * @desc: 不同的二叉搜索树
 */
public class L96UniqueBinarySearchTrees {

    /**
     * 动态规划
     */
    @Test
    public void test() {
        int n = 3;
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        // i 作为根节点
        for (int i = 2; i < n + 1; i++) {
            // 遍历左子树和右子树
            for (int j = 1; j <= i ; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        System.out.println(G[n]);

    }

}
