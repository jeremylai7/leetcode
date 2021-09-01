package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-01
 * @desc: 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

	示例 1：

	输入：head = [1,2,2,1]
	输出：true

 */
public class L234PalindromeLinkedList {
	@Test
	public void test() {
		//head = [1,2,2,1]
		ListNode listNode = new ListNode(2,new ListNode(1));
		ListNode listNode1 = new ListNode(2,listNode);
		ListNode listNode2 = new ListNode(1,listNode1);
		boolean flag = isPalindrome(listNode2);
		System.out.println(flag);

	}

	public boolean isPalindrome(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		int left = 0;
		int right = list.size() - 1;
		while (left < right) {
			if (!list.get(left).equals(list.get(right))) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
