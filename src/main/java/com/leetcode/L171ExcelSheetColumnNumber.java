package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/5
 * @desc: Excel 表列序号
 *
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 **/
public class L171ExcelSheetColumnNumber {

    @Test
    public void test() {
        String str = "ZY";
        int result = titleToNumber(str);
        System.out.println(result);
    }

    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int index = 1;
        for (int i = columnTitle.length() -1; i >= 0; i--) {
            int result = columnTitle.charAt(i) - 'A' + 1;
            sum = sum + (result * index);
            index = index * 26;
        }
        return sum;
    }

}
