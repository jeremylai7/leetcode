package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-10
 * @desc:  合并K个升序链表
 */
public class L23MergeKSortedLists {

	@Test
	public void test() {
		ListNode listNode = new ListNode(4);
		ListNode listNode1 = new ListNode(2,listNode);
		ListNode listNode2 = new ListNode(1,listNode1);
		ListNode listNode3 = new ListNode(4);
		ListNode listNode4 = new ListNode(3,listNode3);
		ListNode listNode5 = new ListNode(1,listNode4);
		ListNode[] listNodes = {listNode2,listNode5};
		ListNode listNode6 = mergeKLists(listNodes);
		System.out.println(listNode6);
	}


	/**
	 * 循环 + 合并两个有序链表
	 * @param lists
	 * @return
	 */
	private ListNode mergeKLists(ListNode[] lists) {
		ListNode head = null;
		for (int i = 0; i < lists.length; i++) {
			ListNode listNode = lists[i];
			head = mergeTwoLists(listNode,head);
		}
		return head;

	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//记录最后一个节点
		ListNode head = new ListNode(0);
		ListNode last = head;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				last.next = l2;
				l2 = l2.next;
			} else {
				last.next = l1;
				l1 = l1.next;
			}
			last = last.next;
		}
		//遍历结束，剩下补全链表
		if (l1 != null) {
			last.next = l1;
		}
		if (l2 != null) {
			last.next = l2;
		}
		return head.next;
	}
}
