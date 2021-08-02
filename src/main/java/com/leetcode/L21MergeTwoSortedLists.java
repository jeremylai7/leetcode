package com.leetcode;

import org.junit.Test;
import org.w3c.dom.ls.LSException;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-02
 * @desc: 合并两个有序链表
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class L21MergeTwoSortedLists {

	@Test
	public void test() {
		ListNode listNode = new ListNode(4);
		ListNode listNode1 = new ListNode(2,listNode);
		ListNode listNode2 = new ListNode(1,listNode1);
		ListNode listNode3 = new ListNode(4);
		ListNode listNode4 = new ListNode(3,listNode3);
		ListNode listNode5 = new ListNode(1,listNode4);
		ListNode head = mergeTwoLists(listNode2,listNode5);
		print(head);



	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		//记录最后一个节点
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

	private void print(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val + " ");
			listNode = listNode.next;

		}
	}

}
