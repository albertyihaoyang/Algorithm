package com.yyh;

public class LinkedListToStackAPI {
	private ListNode head;
	private int size;
	
	public void offer(int value){
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public Integer pool(){
		if (isEmpty()){
			return null; 
		}
		int value = head.value;
		head = head.next;
		size--;
		return value;
	}
	
	public Integer peek(){
		if (isEmpty()){
			return null; 
		}
		int value = head.value;
		return value;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
}
