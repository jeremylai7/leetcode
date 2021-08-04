package com.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-04
 * @desc: 相交链表
 *
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
public class L160IntersectionOfTwoLinkedLists {

	@Test
	public void test(){
		ListNode listNode = new ListNode(0);
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = hashMap(listNode,listNode1);

	}

	private ListNode hashMap(ListNode headA,ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}
		while (headB != null) {
			if (!set.add(headB)){
				return headB;
			}
			headB = headB.next;
		}
		return null;

	}
}
