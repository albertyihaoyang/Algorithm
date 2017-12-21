package com.yyh;

import java.util.PriorityQueue;

public class SolutionII {
	public int findKthLargest(int[] nums, int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	    return pq.peek();
	}
}
