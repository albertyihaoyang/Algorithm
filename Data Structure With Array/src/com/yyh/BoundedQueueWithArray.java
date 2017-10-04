package com.yyh;

public class BoundedQueueWithArray {
	private int head;
	private int tail;
	private int size;
	private Integer[] array;
	
	public BoundedQueueWithArray(int cap){
		array = new Integer[cap]; 
		head = 0;
		tail = 1;
		size = 0;
	}
	
	public boolean offer(int value){
		if (size == array.length){
			return false;
		} else {
			array[tail] = value;
			tail++;
			tail %= array.length;
			size++;
			return true;
		}
	}
	
	public Integer pool(){
		if (isEmpty()) {
			return null;
		}
		head ++;
		head %= array.length;
		size--;
		return array[head];
	}
	
	public Integer peek(){
		if (isEmpty()) {
			return null;
		}
		return array[(head + 1) % array.length];
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public static void main(String[] args){
		BoundedQueueWithArray queue = new BoundedQueueWithArray(2);
		System.out.println(queue.pool());
		queue.offer(1);
		queue.offer(2);
		System.out.println(queue.pool());
		System.out.println(queue.peek());
		queue.offer(3);
		System.out.println(queue.pool());
		System.out.println(queue.peek());
		System.out.println(queue.pool());
	}
}
