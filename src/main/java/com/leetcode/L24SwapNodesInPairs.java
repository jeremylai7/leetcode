package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-06
 * @desc: 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 示例 1：

	输入：head = [1,2,3,4]
	输出：[2,1,4,3]
 */
public class L24SwapNodesInPairs {

	@Test
	public void test() {
		ListNode listNode = new ListNode(4);
		ListNode listNode1 = new ListNode(3,listNode);
		ListNode listNode2 = new ListNode(2,listNode1);
		ListNode listNode3 = new ListNode(1,listNode2);
		ListNode listNode4 = swapPairs(listNode3);
		System.out.println(listNode4);

		ListNode listNode10 = new ListNode(4);
		ListNode listNode11 = new ListNode(3,listNode10);
		ListNode listNode12 = new ListNode(2,listNode11);
		ListNode listNode13 = new ListNode(1,listNode12);
		ListNode listNode14 = swapPairs2(listNode13);
		System.out.println(listNode14);
	}

	/**
	 * 使用递归
	 * 两两交换，先交换最后两个，或者最后剩下一个时，不交换。
	 * 交换完最后两个，往前交换。
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		head.next = swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}

	/**
	 * 迭代，两两结点交换
	 * @param head
	 * @return
	 */
	public ListNode swapPairs2(ListNode head) {
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode temp = dummyHead;
		while (temp.next != null && temp.next.next != null) {
			ListNode listNode1 = temp.next;
			ListNode listNode2 = temp.next.next;
			temp.next = listNode2;
			listNode1.next = listNode2.next;
			listNode2.next = listNode1;
			temp = listNode1;
		}
		return dummyHead.next;
	}


}
