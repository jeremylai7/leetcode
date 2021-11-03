package com.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: laizc
 * @Date: Created in  2021-10-29
 * @desc: 最大矩阵
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

	示例 1：

	输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
	输出：6
	解释：最大矩形如上图所示
 */
public class L85MaximalRectangle {

	@Test
	public void test() {
		char[][] matrix = {{'1','1','0'},{'1','0','0'}};
		int result = maxRenctangle(matrix);
		System.out.println(result);
	}

	public int maxRenctangle(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[] height = new int[n];
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j] += 1;
				} else {
					height[j] = 0;
				}
			}
			maxArea = Math.max(maxArea,largestRectangleArea(height));
		}
		return maxArea;
	}

	private int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		int p = 0;
		while (p < heights.length) {
			//栈空入栈
			if (stack.empty()) {
				stack.push(p);
			} else {
				int top = stack.peek();
				//当前高度大于栈顶，入栈
				if (heights[p] >= heights[top]){
					stack.push(p);
					p++;
				} else {
					//保存栈顶高度
					int height = heights[stack.pop()];
					int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
					int rightLessMin = p;
					int area = (rightLessMin - leftLessMin - 1) * height;
					maxArea = Math.max(area,maxArea);
				}
			}
		}
		while (!stack.isEmpty()) {
			//保存栈顶高度
			int height = heights[stack.pop()];
			int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
			int rightLessMin = heights.length;
			int area = (rightLessMin - leftLessMin - 1) * height;
			maxArea = Math.max(area,maxArea);
		}
		return maxArea;
	}
}
