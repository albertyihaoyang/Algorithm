package com.yyh;

public class minHeap {
	private int[] arr;
	private int size;
	
	public minHeap(int cap){
		if (cap <= 0){
			throw new IllegalArgumentException("Input capacity can not be 0!");
		}
		arr = new int[cap];
		size = 0;
	}
	
	public minHeap(int arr[]){
		if (arr == null || arr.length == 0){
			throw new IllegalArgumentException("Input array can not be null or empty!");
		}
		size = arr.length;
		this.arr = new int[size];
		for (int i = 0; i < size; i++){
			this.arr[i] = arr[i];
		}
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
		
	}
	
	public boolean isFull(){
		return size == arr.length;
	}
	
	public int peak(){
		if (size == 0){
			return -1;
		} else {
			return arr[0];
		}
	}
	
	public int poll(){
		if (size == 0){
			return -1;
		}
		int value = arr[0];
		arr[0] = arr[size -1];
		size--;
		percolateDown(0);
		return value;
	}
	
	public void offer(int value){
		if (isFull()){
			return;
		}
		arr[size] = value;
		percolateUp(size);
		percolateDown(0);
		size++;
	}
	
	public void percolateUp(int index){
		while (index > 0){
			int parentIndex = (index - 1) / 2;
			if (arr[index] < arr[parentIndex]) {
				swap(arr, index, parentIndex);
				index = parentIndex;
			} else{
				break;
			}
		}
		percolateDown(index);
	}
	
	public void percolateDown(int index){
		while (index <= (size - 1) / 2){
			int leftChildIndex = index * 2 + 1;
			int rightChildIndex = index * 2 + 2;
			int candidateIndex = leftChildIndex;
			if (rightChildIndex < size && arr[rightChildIndex] < arr[leftChildIndex]){
				candidateIndex = rightChildIndex;
			}
			if (arr[candidateIndex] < arr[index]) {
				swap(arr, index, candidateIndex);
				index = candidateIndex;
			} else{
				break;
			}
		}
	}
	
	public void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public void heapify(){
		for (int i = size / 2 - 1; i >= 0; i--){
			percolateDown(i);
		}
	}
	
	public void update(int index, int value){
		if (index < 0 || index > size - 1){
			throw new ArrayIndexOutOfBoundsException("Invalid index range!");
		}
		int currentValue = arr[index];
		arr[index] = value;
		if (value < currentValue){
			percolateUp(index);
		} else {
			percolateDown(index);
		}
	}
}
