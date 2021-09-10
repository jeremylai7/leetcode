package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-10
 * @desc: 隔离列表
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

	你应当 保留 两个分区中每个节点的初始相对位置。

	示例 1：

	输入：head = [1,4,3,2,5,2], x = 3
	输出：[1,2,2,4,3,5]
 */
public class L86Submissions {

	@Test
	public void test() {
		int[] nums = {1,4,3,2,5,2};
		int x = 3;
		ListNode node = null;
		for (int i = nums.length -1; i >=0 ; i--) {
			ListNode listNode = new ListNode(nums[i]);
			listNode.next = node;
			node = listNode;
		}
		ListNode listNode = partition(node,x);
		System.out.println(listNode);
	}

	public ListNode partition(ListNode head, int x) {
		ListNode small = new ListNode(0);
		ListNode smallHead = small;
		ListNode large = new ListNode(0);
		ListNode largeHead = large;
		ListNode cur = head;
		while (cur != null) {
			int val = cur.val;
			if (val < x) {
				small.next = cur;
				small = small.next;
			} else {
				large.next = cur;
				large = large.next;
			}
			cur = cur.next;
		}
		large.next = null;
		small.next = largeHead.next;
		return smallHead.next;
	}

}
