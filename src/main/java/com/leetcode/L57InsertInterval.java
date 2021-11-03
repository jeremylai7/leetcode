package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/11/3
 * @desc: 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 **/
public class L57InsertInterval {

    @Test
    public void test() {
        int[][] intervals = {{1,3},{6,9}};
        int[] num = {2,5};
        int[][] result = insert(intervals,num);
        System.out.println(result);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int newLeft = newInterval[0];
        int newRight = newInterval[1];
        boolean placed = false;
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0],right = intervals[i][1];
            if (left > newRight) {
                if (!placed) {
                    merged.add(new int[]{newLeft,newRight});
                    placed = true;
                }
                //插入区间右侧且无交集
                merged.add(new int[]{left,right});
            } else if (right < newLeft) {
                //插入区间左侧且无交集
                merged.add(new int[]{left,right});
            } else {
                newLeft = Math.min(left,newLeft);
                newRight = Math.max(right,newRight);
            }

        }
        if (!placed) {
            merged.add(new int[]{newLeft,newRight});
        }
        return merged.toArray(new int[merged.size()][]);

    }


}
