package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/7/9
 * @desc: 买卖股票的最佳时机
 **/
public class L121BestTimeToBuyAndSellStock {

    private int[] prices = {7,1,5,3,6,4};

    /**
     * 暴力求解
     */
    @Test
    public void violent() {
        int total = 0;
         for (int i = 0; i < prices.length; i++) {
             for (int j = i+1; j < prices.length ; j++) {
                 int  sub= prices[j] - prices[i];
                 if (total < sub) {
                     total = sub;
                 }
             }
         }
        System.out.println(total);
    }

    /**
     * 一次遍历
     */
    @Test
    public void atATime() {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
    }

}
