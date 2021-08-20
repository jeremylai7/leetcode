package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/8/20
 * @desc: 整数转罗马数字
 **/
public class L12IntegerToRoman {

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @Test
    public void test() {
        String result = intToRoman(1998);
        System.out.println(result);



    }

    public String intToRoman(int num) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (value <= num) {
                num = num - value;
                stringBuffer.append(symbol);
            }
            if (num == 0) {break;}
        }
        return stringBuffer.toString();
    }


}
