package com.leetcode;

import org.junit.Test;


/**
 * @author: laizc
 * @date: created in 2021/7/23
 * @desc:
 **/
public class DemoTest {

	@Test
	public void test() {
		//输入：head = [1,2,3,4,5], left = 2, right = 4
		//输出：[1,4,3,2,5]
		ListNode node = new ListNode(4,new ListNode(5));
		ListNode node2 = new ListNode(3,node);
		ListNode node1 = new ListNode(2,node2);
		ListNode node3 = new ListNode(1,node1);
		ListNode listNode = reverseBetween(node3,2,4);


	}

	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		for (int i = 0; i < left - 1; i++) {
			pre = pre.next;
		}
		ListNode cur = pre.next;
		ListNode next;
		for (int i = 0; i < right - left; i++) {
			next = cur.next;
			cur.next = next.next;
			next.next = pre.next;
			pre.next = next;
		}
		return dummy.next;
	}

	private void recall(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode next = head.next;
		head.next = null;



	}
}
