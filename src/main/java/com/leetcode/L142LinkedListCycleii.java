package com.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-04
 * @desc:  环形链表 II
 */
public class L142LinkedListCycleii {

	@Test
	public void test() {
		ListNode listNode = new ListNode(-4);
		ListNode listNode1 = new ListNode(0,listNode);
		ListNode listNode2 = new ListNode(2,listNode1);
		ListNode listNode3 = new ListNode(3,listNode2);
		ListNode listNode4 = detectCycle(listNode3);
		System.out.println(listNode4);
	}

	private ListNode detectCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		ListNode listNode = null;
		while(head != null) {
			if(set.add(head)) {
				head = head.next;
			} else {
				listNode = head;
				break;
			}

		}
		return listNode;

	}
}
