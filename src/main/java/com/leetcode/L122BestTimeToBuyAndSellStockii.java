package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/8/7
 * @desc: 买卖股票的最佳时机 II
 **/
public class L122BestTimeToBuyAndSellStockii {

    private int[] nums = {7,1,5,3,6,4};

    @Test
    public void greedy() {
        int result = maxProfit(nums);
        System.out.println(result);
    }

    /**
     * 贪心算法
     * 每次有利可图就做买入和卖出
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int sub = prices[i] - prices[i-1];
            if (sub > 0) {
                sum += sub;
            }
        }
        return sum;
    }
}
