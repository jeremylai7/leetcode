package com.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: laizc
 * @date: created in 2023/1/30
 * @desc: 填充每个节点的下一个右侧节点指针 II
 */
public class L117PopulatingNextRightPointersInEachNodeII {
    @Test
    public void test() {
        Node node3 = new Node(2,null,null,null);
        Node node2 = new Node(3,null,null,null);
        Node root = new Node(1,node3,node2,null);
        Node node = queue(root);
        System.out.println(node);
    }

    /**
     * 解法一：队列
     * @param root
     * @return
     */
    private Node queue(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        // 遍历每层二叉树
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 取出第一个元素
                Node node = queue.poll();
                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 添加下一层元素
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
