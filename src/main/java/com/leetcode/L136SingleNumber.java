package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: laizc
 * @date: created in 2021/9/21
 * @desc: 只出现一次的数字
 **/
public class L136SingleNumber {

    @Test
    public void test() {
        int[] nums = {1,2,1,2,3};
        int result = singleNumber(nums);
        System.out.println(result);
        result = singleNumber2(nums);
        System.out.println(result);


    }

    /**
     * 位运算
     * ^异或运算，相同位0，不同为1
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i];
        }
        return sum;
    }

    /**
     * 使用hashmap
     * 遍历hash表，如果没有就存起来，如果有就移除
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer, Integer> entry :map.entrySet()){
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
