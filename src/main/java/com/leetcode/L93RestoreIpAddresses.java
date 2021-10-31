package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/10/31
 * @desc: 复原 IP 地址
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按 任何 顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *  
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 **/
public class L93RestoreIpAddresses {

    List<String> list;

    @Test
    public void test() {
        //String s = "25525511135";
        String s = "010010";
        list = new ArrayList<>();
        List<String> list = restoreIpAddresses(s);
        System.out.println(list);
    }

    public List<String> restoreIpAddresses(String s) {
        list = new ArrayList<>();
        dfs(s,0,new StringBuilder(),0);
        return list;
    }

    private void dfs(String s,int start,StringBuilder temp,int count) {
        if (s.length() - start > (4 - count) * 3) {
            return;
        }
        //遍历结束
        if (start == s.length()) {
            if (count == 4) {
                list.add(temp.substring(0,temp.length() - 1));
            }
            return;
        }
        //当前超过末尾，或者已经达到 4 部分 就结束
        if (start > s.length() || count == 4) {
            return;
        }
        //保存当前的解
        StringBuilder before = new StringBuilder(temp);

        //加入 1 位数
        temp.append(s.charAt(start) + ".");
        dfs(s,start + 1,temp,count + 1);

        //大于1位，不能以0为开头。
        if (s.charAt(start) == '0') {
            return;
        }
        //加入2位数
        if (start + 1 < s.length()) {
            temp = new StringBuilder(before);
            temp.append(s.substring(start,start + 2) + ".");
            dfs(s,start + 2,temp,count + 1);

        }
        //加入 3 位数
        if (start + 2 < s.length()) {
            temp = new StringBuilder(before);
            int num = Integer.parseInt(s.substring(start,start + 3));
            if (num >= 0 && num <= 255) {
                temp.append(num + ".");
                dfs(s,start + 3,temp,count + 1);
            }
        }

    }

}
