package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-20
 * @desc: Nim 游戏
 *
 * 你和你的朋友，两个人一起玩 Nim 游戏：

桌子上有一堆石头。
你们轮流进行自己的回合，你作为先手。
每一回合，轮到的人拿掉 1 - 3 块石头。
拿掉最后一块石头的人就是获胜者。
假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。

示例 1：

输入：n = 4
输出：false
解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
     因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 */
public class L292NimGame {

	private int a = 9;

	/**
	 * 1、假设石子数量是1,2,3，你就可以拿走全部石子。
	 * 2、如果石子是4，无论你拿多少个，都是输
	 * 3、所以想要获胜，避免石头为4.
	 * 4、同理，如果有5,6,7，你可以拿几块，剩下4块，自己赢
	 * 5、如果是8块，这时候无论你拿了几块，对手都可以拿几块，让最后剩下是4块
	 * 所以如果是4的倍数，输。不是4的倍数，赢
	 *
	 *
	 */
	@Test
	public void test() {
		canWinNim(a);
	}

	public boolean canWinNim(int n) {
		return n%4 == 0 ? false : true;
	}

}
