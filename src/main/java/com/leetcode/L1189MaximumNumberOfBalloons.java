package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2022/2/13
 * @desc: “气球” 的最大数量
 *
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 * 示例 1：
 *
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 *
 * 输入：text = "leetcode"
 * 输出：0
 *
 **/
public class L1189MaximumNumberOfBalloons {

    @Test
    public void test() {
        String text = "nlaebolko";
        int num = maxNumberOfBalloons(text);
        System.out.println(num);

    }

    public int maxNumberOfBalloons(String text) {
        // balloon
        int[] array = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == 'b') {
                array[0] = array[0] + 1;
            } else if (ch == 'a') {
                array[1] = array[1] + 1;
            } else if (ch == 'l') {
                array[2] = array[2] + 1;
            } else if (ch == 'o') {
                array[3] = array[3] + 1;
            } else if (ch == 'n') {
                array[4] = array[4] + 1;
            }
        }
        array[2] = array[2]/2;
        array[3] = array[3]/2;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(min,array[i]);
        }
        return min;
    }

}
