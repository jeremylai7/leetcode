package com.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: laizc
 * @date: created in 2021/8/2
 * @desc: 多数元素
 * 在大小为n的数组，找到出现大于n/2的元素
 * 输入：[3,2,3]
 * 输出：3
 **/
public class L169MajorityElement {

    private int[] nums = {3,2,3};

    @Test
    public void test() {
        int result = majorityElement(nums);
        System.out.println("map:" + result);
        System.out.println("sort:" + sort(nums));
    }

    /**
     *
     * map全部存入数据
     *
     */
    private int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int count = 1;
            if (map.containsKey(nums[i])) {
                count = map.get(nums[i]) + 1;
            }
            map.put(nums[i],count);
        }
        int key = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > length/2) {
                key = entry.getKey();
            }

        }
        return key;
    }

    /**
     *
     * @param nums
     * @return
     */
    private int sort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];

    }

}
