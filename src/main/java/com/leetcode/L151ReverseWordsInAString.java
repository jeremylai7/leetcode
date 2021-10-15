package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/10/16
 * @desc: 翻转字符串里的单词
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 * 说明：
 *
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 *
 **/
public class L151ReverseWordsInAString {

    @Test
    public void test() {
        String s = "the sky is blue";
        String str = reverseWords(s);
        System.out.println(str);
    }

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder stringBuilder = new StringBuilder();
        int left = s.length() - 1;
        int right = left;
        while (left >= 0) {
            //遍历单个单词
            while ( left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            stringBuilder.append(s, left + 1, right + 1).append(" ");
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;
        }
        return stringBuilder.toString().trim();
    }
}
