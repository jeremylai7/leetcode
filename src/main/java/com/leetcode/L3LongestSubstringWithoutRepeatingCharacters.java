package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: laizc
 * @date: created in 2021/8/21
 * @desc: 无重复字符的最长子串
 **/
public class L3LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void test() {
        int length = lengthOfLongestSubstring("abcabcdjweke");
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        int left = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                //遇到相同的元素，left往后移动一位
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }
        return max;

    }
}
