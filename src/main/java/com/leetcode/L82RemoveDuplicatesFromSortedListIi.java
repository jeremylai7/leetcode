package com.leetcode;

/**
 * @author: laizc
 * @date: created in 2021/9/8
 * @desc: 删除排序链表中的重复元素 II
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 **/
public class L82RemoveDuplicatesFromSortedListIi {

    public void test() {
        //[1,2,3,3,4,4,5]
        ListNode listNode = new ListNode(4,new ListNode(5));
        ListNode listNode1 = new ListNode(4,listNode);
        ListNode listNode2 = new ListNode(3,listNode1);
        ListNode listNode3 = new ListNode(3,listNode2);
        ListNode listNode4 = new ListNode(2,listNode3);
        ListNode listNode5 = new ListNode(1,listNode4);
        ListNode listNode6 = deleteDuplicates(listNode5);
        System.out.println(listNode6);


    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}
