package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/8/14
 * @desc: 删除链表的倒数第 N 个结点
 **/
public class L19RemoveThNodeFromEndOfList {

    @Test
    public void test() {
        ListNode listNode = new ListNode(5);
        ListNode listNode1 = new ListNode(4,listNode);
        ListNode listNode2 = new ListNode(3,listNode1);
        ListNode listNode3 = new ListNode(2,listNode2);
        ListNode listNode4 = removeNthFromEnd(listNode3,1);
        System.out.println(listNode4);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        //伪头结点
        ListNode dummy = new ListNode(1,head);
        int sub = length - n + 1;
        cur = dummy;
        int index = 1;
        while (cur != null) {
            if (sub == index) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
            index++;
        }
        return dummy.next;
    }
}
