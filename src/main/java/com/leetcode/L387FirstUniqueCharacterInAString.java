package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: laizc
 * @date: created in 2021/9/24
 * @desc: 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 **/
public class L387FirstUniqueCharacterInAString {

    @Test
    public void test() {
        String str = "loveleetcode";
        int index = firstUniqChar(str);
        System.out.println(index);
    }

    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch,map.get(ch) + 1);
            } else {
                map.put(ch,1);
            }
        }
        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }
}
