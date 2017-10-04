package com.yyh;

public class LinkedListToQueueAPI {
	private ListNode head;
	private ListNode tail;
	private int size;
	
	public void offer(int value){
		if (isEmpty()) {
			head = new ListNode(value);
			tail = head;
		} else {
			tail.next = new ListNode(value);
			tail = tail.next;
		}
		size++;
	}
	
	public Integer pool(){
		if (isEmpty()) {
			return null;
		} else if (size == 1) {
			size--;
			int value = head.value;
			head = null;
			tail = head;
			return value;
		} else {
			int value = head.value;
			head = head.next;
			size--;
			return value;
		}
	}
	
	public Integer peek(){
		if (isEmpty()) {
			return null;
		}
		return head.value;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public static void main(String[] args){
		LinkedListToQueueAPI queue = new LinkedListToQueueAPI();
		System.out.println(queue.pool());
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue.pool());
		System.out.println(queue.peek());
		System.out.println(queue.pool());
	}
}
