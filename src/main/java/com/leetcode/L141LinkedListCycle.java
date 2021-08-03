package com.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-03
 * @desc: 环形链表
 *
 * head = [3,2,0,-4], pos = 1
   输出：true
 */
public class L141LinkedListCycle {

	@Test
	public void test() {
		ListNode listNode = new ListNode(-4);
		ListNode listNode1 = new ListNode(0,listNode);
		ListNode listNode2 = new ListNode(2,listNode1);
		ListNode listNode3 = new ListNode(3,listNode2);
		System.out.println(set(listNode3));
	}

	private boolean set(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while(head != null) {
			set.add(head);
			head = head.next;
			if (set.contains(head)) {
				return true;
			}
		}
		return false;


	}


}
