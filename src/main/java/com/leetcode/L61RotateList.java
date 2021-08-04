package com.leetcode;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-04
 * @desc: 旋转链表
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 */
public class L61RotateList {

	@Test
	public void test() {
		ListNode listNode = new ListNode(5);
		ListNode listNode1 = new ListNode(4,listNode);
		ListNode listNode2 = new ListNode(3,listNode1);
		ListNode listNode3 = new ListNode(2,listNode2);
		ListNode listNode4 = new ListNode(1,listNode3);
		ListNode listNode7 = rotateRight(listNode4,2);
		System.out.println(listNode7);
	}

	/**
	 * 1、计算链表长度，以及找到最后一个节点 39-41行
	 * 2、根据移动位置k 和链表长度，算出需要移动的位置 add 43行
	 * 3、链表闭环
	 * 4、移动的 add 处的next复制到新的链表，链表的next -> null
	 *
	 */
	private ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		//计算链表长度
		int n = 1;
		ListNode iterate = head;
		while (iterate.next != null) {
			n++;
			iterate = iterate.next;
		}
		int add = n - k%n;
		if (add == n) {
			return head;
		}
		//闭环
		iterate.next = head;
		//iterate是最后一个节点，移动要首节点需要移动一个位置，这里要多往后遍历一次
		while (add-- > 0) {
			iterate = iterate.next;
		}
		ListNode ret = iterate.next;
		iterate.next = null;
		return ret;
	}

}
