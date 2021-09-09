package com.leetcode;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/9/10
 * @desc: 反转链表 II
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 **/
public class L92ReverseLinkedListIi {

    @Test
    public void test() {
        //：head = [1,2,3,4,5], left = 2, right = 4
        int[] nums = {1,2,3,4,5};
        ListNode node = null;
        for (int i = nums.length -1; i >=0 ; i--) {
            ListNode listNode = new ListNode(nums[i]);
            listNode.next = node;
            node = listNode;
        }
        ListNode listNode = reverseBetween(node,2,4);
        System.out.println(listNode);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //初始化两个指针 p q
        ListNode q = dummy;
        ListNode p = dummy.next;
        for (int i = 0; i < left - 1; i++) {
            p = p.next;
            q = q.next;
        }
        //使用头插法
        for (int i = 0; i < right - left; i++) {
            ListNode next = p.next;
            //指向下一个2->4
            p.next = p.next.next;
            //指向前一个3->2
            next.next = q.next;
            //指向next 1->3
            q.next = next;
        }
        return dummy.next;
    }

}
