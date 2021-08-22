package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/8/22
 * @desc: 电话号码的字母组合
 **/
public class L17LetterCombinationsOfAPhoneNumber {

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    @Test
    public void test() {
        String digits = "2";
        List<String> list = letterCombinations(digits);
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        backtrack(list,digits,0,"");
        return list;

    }

    private void backtrack(List<String> list,String digits,int index,String string) {
        if (index == digits.length()) {
            list.add(string);
            return;
        }
        String values = KEYS[digits.charAt(index) - '0'];
        for (int i = 0; i < values.length(); i++) {
            backtrack(list,digits,index + 1,string + values.charAt(i));
        }
    }
}
