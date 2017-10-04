package com.yyh;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {
	private List<Integer> heap;
	private int size;
	private int cap;
	
	public BinaryHeap(int cap){
		heap = new ArrayList<Integer>(cap);
		size = 0;
		this.cap = cap;
	}
	
	public void insert(int value){
		if (size == cap){
			return;
		}
		heap.add(value);
		update();
		size++;
	}
	
	public void update(){
		
	}
	
	public int get(){
		if (size == 0){
			return -1;
		} else {
			return heap.get(0);
		}
	}
	
	public int pop(){
		if (size == 0){
			return -1;
		} else {
			int value = heap.get(0);
			heap.set(0, null);
			update();
			size--;
			return value;
		}
	}
	
	public int iParent(int index){
		return (index - 1) / 2;
	}
	
	public int iLChild(int index){
		return 2 * index + 1;
	}
	
	public int iRChild(int index){
		return 2 * index + 2;
	}
}
