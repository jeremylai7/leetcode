package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/8/1
 * @desc: 两数相加
 **/
public class L2AddTwoNumbers {

    @Test
    public void test() {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(4,listNode);
        ListNode listNode2 = new ListNode(2,listNode1);

        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(6,listNode3);
        ListNode listNode5 = new ListNode(5,listNode4);
        ListNode listNode6 = addTwoNumbers(listNode2,listNode5);
        print(listNode6);
    }

    private ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        ListNode demo = new ListNode(0);
        ListNode head = demo;
        int addOne = 0;
        while (l1 != null || l2 != null || addOne != 0) {
            int leftVal = 0,rightVal = 0;
            if (l1 != null){
                leftVal = l1.val;
            }
            if (l2 != null) {
                rightVal = l2.val;
            }
            int sum = leftVal + rightVal + addOne;
            head.next = new ListNode(sum % 10);
            head = head.next;
            addOne = sum /10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return demo.next;
    }

    private void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;

        }
    }

}
