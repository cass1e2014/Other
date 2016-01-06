import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set. 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1. 
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should
 * invalidate the least recently used item before inserting a new item.
 * 
 * @author cassie9082
 * 
 */
public class LRUCache {
	private class Node {
		Node prev;
		Node next;
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}

	private int capacity;
	private HashMap<Integer, Node> hashmap = new HashMap<Integer, Node>();
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!hashmap.containsKey(key)) {
			return -1;
		} else {
			// remove current node
			Node current = hashmap.get(key);
			current.prev.next = current.next;
			current.next.prev = current.prev;

			// move current to tail
			move_to_tail(current);
			return current.value;
		}
	}

	// Move to tail是指move到最后，但是在tail之前（这边的tail，其作用相当于一个在尾巴的指针）
	public void move_to_tail(Node current) {
		current.prev = tail.prev;// 让current指针的prev指针指向目前tail指针的prev指针所指在的位置
		tail.prev = current;// 在引导好current指针的prev指针指在正确的位置后，tail指针改变自己prev指针的指向，指到current这个node上
		// 把Node current和前后指针指好
		current.prev.next = current;
		current.next = tail;
	}

	// 在set（）的时候可能会遇到加满的情况
	public void set(int key, int value) {
		// check if the hashmap has already contained the key
		if (get(key) != -1) {
			hashmap.get(key).value = value; // assign a new value to the existing key
			return;
		}

		// check if the hashmap is full,remove掉最头上的node（head相当于一个在头上的指针）
		if (hashmap.size() == capacity) {
			hashmap.remove(head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}

		Node insert = new Node(key, value);
		// Node insert要先被加入hashmap中再被加入到链表到最后
		hashmap.put(key, insert);
		move_to_tail(insert);//最新加入的也要被move到最后

	}
}
