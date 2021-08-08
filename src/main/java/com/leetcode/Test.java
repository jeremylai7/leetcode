package com.leetcode;

import java.time.LocalDateTime;

/**
 * @author: laizc
 * @date: created in 2021/7/23
 * @desc:
 **/
public class Test {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        int month = now.getDayOfMonth();
        System.out.println(month +  " " +now.getYear());
        System.out.println(now);
    }
}
