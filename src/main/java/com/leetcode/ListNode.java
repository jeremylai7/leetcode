package com.leetcode;


/**
 * @author: laizc
 * @date: created in 2021/8/2
 * @desc:
 **/
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    /**
     * 数组转链表
     * @param num
     * @return
     */
    public static ListNode arrayTransformListNode(int[] num) {
        ListNode node = null;
        for (int i = num.length - 1; i >= 0 ; i--) {
            node = new ListNode(num[i],node);
        }
        return node;
    }

}
