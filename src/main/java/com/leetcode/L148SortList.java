package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-09
 * @desc:  排序链表
 */
public class L148SortList {

	@Test
	public void test() {
		ListNode listNode = new ListNode(3);
		ListNode listNode1 = new ListNode(1,listNode);
		ListNode listNode2 = new ListNode(2,listNode1);
		ListNode listNode3 = new ListNode(4,listNode2);
		ListNode result = sortList(listNode3);
		System.out.println(result);
	}

	private ListNode sortList(ListNode head) {
		return sortList(head, null);
	}

	private ListNode sortList(ListNode head,ListNode tail) {
		if (head == null) {
			return head;
		}
		if (head.next == tail) {
			head.next = null;
			return head;
		}
		ListNode slow = head,fast = head;
		//找到链表的中点,
		// 找中点可以使用快慢指针，快指针每次移动2步，慢指针移动1步
		//当快指针到达链表末尾时，慢指针指向的链表节点就是链表的中点
		while (fast != tail) {
			slow = slow.next;
			fast = fast.next;
			if (fast != tail) {
				fast = fast.next;
			}
		}
		ListNode mid = slow;
		//以中点为分界,将链表拆分成两个
		ListNode listNodeLeft = sortList(head,mid);
		ListNode listNodeRight = sortList(mid,tail);
		ListNode sored = merge(listNodeLeft,listNodeRight);
		return sored;
	}

	/**
	 * 合并两个排序后的子链表，得到完成排序后的链表
	 * @param left
	 * @param right
	 * @return
	 */
	private ListNode merge(ListNode left,ListNode right) {
		ListNode dummyHead = new ListNode(0);
		ListNode temp = dummyHead,tempLeft = left,tempRight = right;
		while (tempLeft != null && tempRight != null) {
			if (tempLeft.val < tempRight.val) {
				temp.next = tempLeft;
				tempLeft = tempLeft.next;
			} else {
				temp.next = tempRight;
				tempRight = tempRight.next;
			}
			temp = temp.next;
		}
		if (tempLeft != null) {
			temp.next = tempLeft;
		} else if (tempRight != null) {
			temp.next = tempRight;
		}
		return dummyHead.next;


	}
}
