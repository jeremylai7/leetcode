package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-13
 * @desc:  删除排序链表中的重复元素
 */
public class L83RemoveDuplicatesFromSortedList {

	@Test
	public void test() {
		ListNode listNode5 = new ListNode(6);
		ListNode listNode6 = new ListNode(5,listNode5);
		ListNode listNode = new ListNode(4,listNode6);
		ListNode listNode1 = new ListNode(3,listNode);
		ListNode listNode2 = new ListNode(3,listNode1);
		ListNode listNode3 = new ListNode(3,listNode2);
		ListNode listNode4 = new ListNode(2,listNode3);
		ListNode listNode7 = new ListNode(2,listNode4);
		ListNode listNode8 = deleteDuplicates(listNode7);
		System.out.println(listNode8);
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			}else {
				cur = cur.next;
			}
		}
		return head;
	}
}
