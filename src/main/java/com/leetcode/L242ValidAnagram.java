package com.leetcode;

import com.sun.tools.corba.se.idl.StringGen;
import org.junit.Test;

import java.util.*;

/**
 * @author: laizc
 * @date: created in 2021/3/28
 * @desc: 有效的字母异位词
 **/
public class L242ValidAnagram {

    private String s = "cat";

    private String t = "ata";

    /**
     * 使用数组
     * 首先将字符串转成数组，然后对数组进行排序。最后对排序后的数组进行比较
      */
    @Test
    public void arrayTest() {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        boolean flag = Arrays.equals(sChars,tChars);
        System.out.println(flag);
    }

    /**
     * 使用map
     */
    @Test
    public void mapTest(){
        Map<Character,Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch,map.get(ch) + 1);
            }else {
                map.put(ch,1);
            }
        }
        boolean flag = false;
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                flag = false;
                break;
            }else if (count > 1) {
                map.put(ch,count - 1);
            }else {
                map.remove(ch);
            }
        }
        if (map.isEmpty()){
            flag = true;
        }
        System.out.println(flag);

    }



}
