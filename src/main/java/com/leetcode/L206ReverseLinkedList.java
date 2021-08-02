package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-02
 * @desc: 反转链表
 *
 *  输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class L206ReverseLinkedList {


	@Test
	public void test() {
		ListNode listNode5 = new ListNode(5);
		ListNode listNode4 = new ListNode(4,listNode5);
		ListNode listNode3 = new ListNode(3,listNode4);
		ListNode listNode2 = new ListNode(2,listNode3);
		ListNode listNode1 = new ListNode(1,listNode2);
		ListNode listNode = reverseList(listNode1);
		print(listNode);


	}

	/**
	 * 1、分割头结点和next节点，next用next存储起来
	 * 2、头结点的next指向新的节点
	 *
	 *
	 */
	private ListNode reverseList(ListNode listNode) {
		ListNode pre = null;
		ListNode cur = listNode;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}


	private void print(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val + " ");
			listNode = listNode.next;

		}
	}



}
