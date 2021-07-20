package com.leetcode;

/**
 * @author: laizc
 * @date: created in 2021/7/19
 * @desc: 删除链表中的节点
 *
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 *
 * 示例 1：
 *
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 **/

import org.junit.Test;

import java.lang.reflect.WildcardType;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class L237DeleteNodeInALinkedList {

    /**
     * 脑筋急转弯
     * 1、删除某个节点，要将该节点的上一个节点指向该节点的下一个节点，但是这是一个单链表，无法找打前一个节点
     * 2、根据只能找到下一个节点的特点，将改节点的下一个节点赋值给改节点
     * 3、然后该节点的next节点就是next的next节点
     *
     */
    @Test
    public void deleteNode() {
        ListNode listNode = new ListNode(9);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = listNode;
        ListNode listNode3 = new ListNode(5);
        listNode3.next = listNode2;
        ListNode listNode4 = new ListNode(4);
        listNode4.next = listNode3;
        deleteNode(listNode3);

        while (listNode4 != null) {
            System.out.println(listNode4.val);
            listNode4 = listNode4.next;
        }

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }



    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
