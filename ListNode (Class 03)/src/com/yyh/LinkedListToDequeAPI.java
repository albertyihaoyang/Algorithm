package com.yyh;

class DualListNode{
	public int value;
	public DualListNode next;
	public DualListNode prev;
	public DualListNode(int v){
		value = v;
		next = null;
		prev = null;
	}
	
}
public class LinkedListToDequeAPI {
	private DualListNode first;
	private DualListNode last;
	private int size;
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void offerFirst(int value){
		if (isEmpty()){
			DualListNode newNode = new DualListNode(value);
			first = newNode;
			last = first;
		} else {
			DualListNode newNode = new DualListNode(value);
			first.prev = newNode;
			newNode.next = first;
			first = first.prev;
		}
		size++;
	}
	
	public void offerLast(int value){
		if (isEmpty()){
			DualListNode newNode = new DualListNode(value);
			first = newNode;
			last = first;
		} else {
			DualListNode newNode = new DualListNode(value);
			last.next = newNode;
			newNode.prev = last;
			last = last.next;
		}
		size++;
	}
	
	public Integer peekFirst(){
		if (isEmpty()){
			return null;
		}
		return first.value;
	}
	
	public Integer peekLast(){
		if (isEmpty()){
			return null;
		}
		return last.value;
	}
	
	public Integer poolFirst(){
		if (isEmpty()){
			return null;
		} else if (size == 1){
			int value = first.value;
			first = null;
			last = null;
			size--;
			return value;
		} else {
			int value = first.value;
			first = first.next;
			first.prev = null;
			size--;
			return value;
		}
	}
	
	public Integer poolLast(){
		if (isEmpty()){
			return null;
		} else if (size == 1){
			int value = last.value;
			first = null;
			last = null;
			size--;
			return value;
		} else {
			int value = last.value;
			last = last.prev;
			last.next = null;
			size--;
			return value;
		}
	}
	
	public static void main(String[] args){
		LinkedListToDequeAPI deque = new LinkedListToDequeAPI();
		System.out.println(deque.poolFirst());
		deque.offerFirst(1);
		deque.offerFirst(2);
		deque.offerLast(3);
		System.out.println(deque.poolLast());
		System.out.println(deque.peekLast());
		System.out.println(deque.poolFirst());
	}
}
