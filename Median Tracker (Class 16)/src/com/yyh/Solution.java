package com.yyh;

import java.util.Collections;
import java.util.PriorityQueue;
/*
 * Given an unlimited flow of numbers, keep track of the median of all elements seen so far.
 * You will have to implement the following two methods for the class
 * 	read(int value) - read one value from the flow
 * 	median() - return the median at any time, return null if there is no value read so far
 */

public class Solution {
	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;
	
	public Solution() {
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
	}
	
	public void read(int value) {
		if (maxHeap.size() == 0){
			maxHeap.offer(value);
			return;
		} else if (minHeap.size() == 0){
			minHeap.offer(value);
			return;
		}
		if (value <= minHeap.peek()){
			maxHeap.offer(value);
			if (maxHeap.size() == minHeap.size() + 2){
				minHeap.offer(maxHeap.poll());
			}
		} else {
			minHeap.offer(value);
			if (maxHeap.size() < minHeap.size()){
				maxHeap.offer(minHeap.poll());
			}
		}
	}
	
	public Double median() {
		if (maxHeap.size() == 0){
			return null;
		}
		if (maxHeap.size() > minHeap.size()){
			return (double)(maxHeap.peek());
		} else {
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		}
	}
	
	public static void main(String[] args){
		Solution sol = new Solution();
		sol.read(1);
		sol.read(2);
		sol.read(3);
		System.out.println(sol.median());
	}
}
