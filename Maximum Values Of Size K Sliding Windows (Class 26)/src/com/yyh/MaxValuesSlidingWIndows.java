package com.yyh;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxValuesSlidingWIndows {
	public List<Integer> maxWindows(int[] array, int k){
		List<Integer> max = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < array.length; i++){
			while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]){
				deque.pollLast();
			}
			if (!deque.isEmpty() && deque.peekFirst() <= i - k){
				deque.pollFirst();
			}
			deque.offerLast(i);
			if (i >= k - 1){
				max.add(array[deque.peekFirst()]);
			}
		}
		return max;
	}
}
