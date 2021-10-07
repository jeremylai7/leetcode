package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/10/7
 * @desc: 字符串中的单词数
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 **/
public class L434NumberOfSegmentsInAString {

    @Test
    public void test() {
        String str = "Hello, my name is John";
        int count = countSegments(str);
        System.out.println(count);

    }

    public int countSegments(String s) {
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }

        }
        return count;
    }
}
