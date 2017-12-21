package com.yyh;

import java.util.PriorityQueue;

public class MinConnectionCost {
	public int minCost(int[] nums){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int n : nums){
			pq.offer(n);
		}
		while (pq.size() > 1){
			int n1 = pq.poll();
			int n2 = pq.poll();
			pq.offer(n1 + n2);
		}
		return pq.poll();
	}
}
