package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/5
 * @desc: 实现 strStr()
 **/
public class L28ImplementStrstr {

    @Test
    public void test() {
        int index = strStr("hello","ll");
        System.out.println(index);

    }

    public int strStr(String haystack, String needle) {
        int hayLength = haystack.length();
        int needLength = needle.length();
        if (hayLength < needLength) {
            return -1;
        }
        if (needLength == 0) {
            return 0;
        }
        for (int i = 0; i < hayLength - needLength + 1; i++) {
            int j;
            for (j = 0; j < needLength; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needLength) {
                return i;
            }
        }
        return -1;
    }
}
