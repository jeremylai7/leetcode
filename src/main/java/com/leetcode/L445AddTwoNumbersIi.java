package com.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-30
 * @desc:  两数相加 II
 */
public class L445AddTwoNumbersIi {
	@Test
	public void test() {
/*		ListNode listNode = new ListNode(3);
		ListNode listNode1 = new ListNode(4,listNode);
		ListNode listNode2 = new ListNode(2,listNode1);
		ListNode listNode3 = new ListNode(7,listNode2);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(6,listNode4);
		ListNode listNode6 = new ListNode(5,listNode5);
		ListNode listNode7 = addTwoNumbers(listNode3,listNode6);*/
		ListNode listNode = new ListNode(9,new ListNode(9));
		ListNode listNode1 = new ListNode(1);
		ListNode listNode7 = addTwoNumbers(listNode1,listNode);
		System.out.println(listNode7);

	}

	/**
	 * 使用栈处理逆序数据
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}
		ListNode listNode = null;
		int addOne = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty() || addOne != 0) {
			int a = stack1.isEmpty() ? 0 : stack1.pop();
			int b = stack2.isEmpty() ? 0 : stack2.pop();
			int sum = (a + b + addOne)%10;
			addOne = (a + b + addOne)/10;
			ListNode cur = new ListNode(sum);
			cur.next = listNode;
			listNode = cur;
		}
		return listNode;
	}
}
