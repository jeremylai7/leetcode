package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-11
 * @desc: LRU 缓存机制
 */
public class L146LruCache {

	class DLinkedNode{
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;

		public DLinkedNode() {}

		public DLinkedNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int size;

	private int capacity;

	private DLinkedNode head;

	private DLinkedNode tail;

	private Map<Integer,DLinkedNode> cache = new HashMap<>();

	public L146LruCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			return -1;
		}
		//找到并移动到首位
		moveToHead(node);
		return node.value;
	}

	public void put(int key,int value) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			//不存在就创建一个新的节点
			DLinkedNode newNode = new DLinkedNode(key,value);
			cache.put(key,newNode);
			addToHead(newNode);
			size++;
			if (size > capacity) {
				//超出容量，移除最后节点
				DLinkedNode tail = removeTail();
				cache.remove(tail.key);
				size--;
			}
		} else {
			//key存在，覆盖value，并移到头部
			if (node.value != value) {
				node.value = value;
			}
			moveToHead(node);

		}
	}

	private DLinkedNode removeTail() {
		DLinkedNode node = tail.prev;
		removeNode(node);
		return node;
	}

	private DLinkedNode removeNode(DLinkedNode node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
		return node;
	}

	private void moveToHead(DLinkedNode node) {
		removeNode(node);
		addToHead(node);
	}

	private void addToHead(DLinkedNode node) {
		node.prev = head;
		node.next = head.next;
		head.next = node;
		head.next.prev = node;
	}


}
