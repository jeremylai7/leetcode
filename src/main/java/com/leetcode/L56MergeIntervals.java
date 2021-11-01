package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2021/10/23
 * @desc: 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 **/
public class L56MergeIntervals {

    @Test
    public void test() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] nums = merge(intervals);
        System.out.println(nums);
    }

    /**
     * 排序 + 比较
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        //左端点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0],right = intervals[i][1];
            //merged没有元素或者 merged最后一个元素的right小于当前的left
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
                merged.add(new int[]{left,right});
            } else {
                //当前的right和merged最后一个元素的right比较，谁大给谁赋值
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1],right);
            }
        }
        return merged.toArray(new int[merged.size()][]);

    }

}
