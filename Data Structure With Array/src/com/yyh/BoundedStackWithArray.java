package com.yyh;

public class BoundedStackWithArray{
	private int tail;
	private int size;
	private Integer[] array;
	
	public BoundedStackWithArray(int cap){
		array = new Integer[cap];
		tail = 0;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean offer(int value){
		if (size == array.length){
			return false;
		}
		array[tail] = value;
		tail++;
		tail %= array.length;
		size++;
		return true;
	}
	
	public Integer peek(){
		if (isEmpty()) {
			return null;
		} else {
			return array[(tail-1) % array.length];
		}
	}
	
	public Integer pool(){
		if (isEmpty()) {
			return null;
		} else {
			tail += array.length-1;
			tail %= array.length;
			size--;
			return array[tail];	
		}
	}
	
	public static void main(String[] args){
		BoundedStackWithArray stack = new BoundedStackWithArray(2);
		System.out.println(stack.pool());
		stack.offer(1);
		stack.offer(2);
		stack.offer(3);
		System.out.println(stack.pool());
		System.out.println(stack.peek());
		System.out.println(stack.pool());
		System.out.println(stack.peek());
		System.out.println(stack.pool());
	}
}
