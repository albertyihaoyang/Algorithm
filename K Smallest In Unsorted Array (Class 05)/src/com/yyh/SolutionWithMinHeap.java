package com.yyh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionWithMinHeap {
	public static int[] kSmallest(int[] array, int k) {
		if (array.length == 0 || k == 0){
			return new int[0];
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2){
				if (o1.equals(o2)){
					return 0;
				}
				return o1 > o2 ? 1 : -1;
			}
		});
		for (int i = 0; i < array.length; i++){
			minHeap.offer(array[i]);
		}
		int[] result = new int[k];
		for (int i = 0; i < k; i++){
			result[i] = minHeap.poll();
		}
		return result;
	}
	
	public static void main(String[] args){
		int[] arr = new int[] {2, 5, 6, 3, 4, 1, 7};
		System.out.print(Arrays.toString(kSmallest(arr,3)));
	}
}
