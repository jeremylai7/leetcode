package com.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: laizc
 * @Date: Created in  2021-12-02
 * @desc: 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

	返回滑动窗口中的最大值。

	 

	示例 1：

	输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
	输出：[3,3,5,5,6,7]
	解释：
	滑动窗口的位置                最大值
	---------------               -----
	[1  3  -1] -3  5  3  6  7       3
	1 [3  -1  -3] 5  3  6  7       3
	1  3 [-1  -3  5] 3  6  7       5
	1  3  -1 [-3  5  3] 6  7       5
	1  3  -1  -3 [5  3  6] 7       6
	1  3  -1  -3  5 [3  6  7]      7
 */
public class L239SlidingWindowMaximum {

	@Test
	public void test() {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] result = maxSlidingWindow(nums,k);
		System.out.println(Arrays.toString(result));


	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		//队列保存两个元素：值和下标
		//元素对比，如果相等，坐标更大的优先。如果不相等，数值更大的优先
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
		for (int i = 0; i < k; i++) {
			pq.offer(new int[]{nums[i],i});
		}
		int[] ans = new int[n - k + 1];
		//滑动窗口初始最大值
		ans[0] = pq.peek()[0];
		for (int i = k; i < n; i++) {
			pq.offer(new int[]{nums[i],i});
			//移除滑动串口之外的元素
			while (pq.peek()[1] <= i - k) {
				pq.poll();
			}
			ans[i - k + 1] = pq.peek()[0];
		}
		return ans;
	}
}
