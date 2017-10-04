package com.yyh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionWithMaxHeap {
	public static int[] kSmallest(int[] array, int k) {
		if (array.length == 0 || k == 0){
			return new int[0];
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2){
				if (o1.equals(o2)){
					return 0;
				}
				return o1 > o2 ? -1: 1;
			}
		});
		for (int i = 0; i < array.length; i++){
			if (i < k){
				// offer the first k elements into max heap.
				// Notice: if you want to utilize heapify(), the only thing you can do is to call 
				//a certain constructor of PriorityQueue
				maxHeap.offer(array[i]);
			} else if (array[i] < maxHeap.peek()){
				// for other elements, only offer it into the max heap if it is smaller
				// than the max value in the max heap
				maxHeap.poll();
				maxHeap.offer(array[i]);
			}
		}
		int[] result = new int[k];
		for (int i = k-1; i >= 0; i--){
			result[i] = maxHeap.poll();
		}
		return result;
	}
	
	public static void main(String[] args){
		int[] arr = new int[] {2, 5, 6, 3, 4, 1, 7};
		System.out.print(Arrays.toString(kSmallest(arr,3)));
	}
}
