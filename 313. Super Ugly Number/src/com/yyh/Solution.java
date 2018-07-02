package com.yyh;

import java.util.PriorityQueue;

public class Solution {
	public int nthSuperUglyNumber(int n, int[] primes) {
        int i = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        long cur = 0;
        long last = 0;
        while (i < n){
            cur = pq.poll();
            if (cur == last) continue;
            last = cur;
            i++;
            for (int p: primes){
                pq.offer(cur * p);
            }
        }
        return (int)cur;
    }
}
