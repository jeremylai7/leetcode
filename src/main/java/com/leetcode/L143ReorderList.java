package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2022-01-18
 * @desc: 重排链表
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：

	L0 → L1 → … → Ln - 1 → Ln
	请将其重新排列后变为：

	L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
	不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

	 

	示例 1：



	输入：head = [1,2,3,4]
	输出：[1,4,2,3]


 */
public class L143ReorderList {

	@Test
	public void test() {
		ListNode listNode = new ListNode(3,new ListNode(4));
		ListNode node = new ListNode(2,listNode);
		ListNode node1 = new ListNode(1,node);
		reorderList(node1);

	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		// 找到中点
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode newHead = slow.next;
		slow.next = null;
		// 倒置后半段
		newHead = inversion(newHead);
		// 拼接链表
		ListNode l1Temp;
		ListNode l2Temp;
		ListNode l1 = head;
		while (head != null && newHead != null) {
			l1Temp = l1.next;
			l2Temp = newHead.next;

			l1.next = newHead;
			l1 = l1Temp;

			newHead.next = l1;
			newHead = l2Temp;
		}
	}

	private ListNode inversion(ListNode node) {
		if (node == null) {
			return null;
		}
		ListNode cur = node;
		ListNode pre = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
