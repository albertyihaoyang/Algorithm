package com.yyh;

public class BoundedDequeWithArray {
	private int first;
	private int last;
	private int size;
	private Integer[] array;
	
	public BoundedDequeWithArray(int cap){
		array = new Integer[cap];
		first = cap/2;
		last = first;
		size = 0;
	}
	
	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean offerFirst(int value){
		if (size == array.length){
			return false;
		}
		array[first] = value;
		first += (array.length - 1);
		first %= array.length;
		size++;
		return true;
	}
	
	public boolean offerLast(int value){
		if (size == array.length){
			return false;
		}
		last += 1;
		last %= array.length;
		array[last] = value;
		size++;
		return true;
	}
	
	public Integer peekFirst(){
		if (isEmpty()){
			return null;
		}
		return array[(first + 1) % array.length];
	}
	
	public Integer peekLast(){
		if (isEmpty()){
			return null;
		}
		return array[last];
	}
	
	public Integer poolFirst(){
		if (isEmpty()){
			return null;
		}
		first++;
		first %= array.length;
		size--;
		return array[first];
	}
	
	public Integer poolLast(){
		if (isEmpty()){
			return null;
		}
		last += array.length - 1;
		last %= array.length;
		size--;
		return array[(last + 1) % array.length];
	}
	
	public static void main(String[] args){
		BoundedDequeWithArray deque = new BoundedDequeWithArray(5);
		System.out.println(deque.poolFirst());
		deque.offerFirst(1);
		deque.offerFirst(2);
		deque.offerLast(3);
		System.out.println(deque.poolLast());
		System.out.println(deque.peekLast());
		System.out.println(deque.poolFirst());
	}
}
