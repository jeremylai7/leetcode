package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-27
 * @desc: K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

	k 是一个正整数，它的值小于或等于链表的长度。

	如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
	 
	示例 1：

	输入：head = [1,2,3,4,5], k = 2
	输出：[2,1,4,3,5]
 */
public class L25ReverseNodesInkGroup {

	@Test
	public void test() {
		int[] nums = {1,2,3,4,5};
		int k = 2;
		ListNode head = ListNode.arrayTransformListNode(nums);
		ListNode node = reverseKGroup(head,k);
		System.out.println(node);
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode end = dummy;
		while (end.next != null) {
			for (int i = 0; i < k && end != null; i++) {
				end = end.next;
			}
			if (end == null) {
				break;
			}
			ListNode start = pre.next;
			ListNode next = end.next;
			end.next = null;
			pre.next = reverse(start);
			start.next = next;
			pre = start;
			end = pre;
		}
		return dummy.next;
	}

	private ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

}
