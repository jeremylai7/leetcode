package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/8/17
 * @desc: 最后一个单词的长度
 **/
public class L58LengthOfLastWord {

    @Test
    public void test() {
        int result = lengthOfLastWord("hello world");
        System.out.println(result);
    }

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

}
