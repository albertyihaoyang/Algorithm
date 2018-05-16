package com.yyh;
/*
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), 
 * where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. 
 * Write an algorithm to reconstruct the queue.
 */

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	public int[][] reconstructQueue(int[][] people) {
		int len = people.length;
        if (len == 0) return people;
        List<int[]> res = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(len, new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2){
                if (p1[0] > p2[0]) return -1;
                else if (p1[0] < p2[0]) return 1;
                else return p1[1] < p2[1] ? -1: 1;
            }
        });
                                                                       
        for (int[] p: people) pq.offer(p);
        
        for (int i = 0; i < len; i++){
            int[] cur = pq.poll();
            res.add(cur[1], cur);
        }
        
        int[][] nres = new int[len][2];
        
        for (int i = 0; i < len; i++){
            int[]cur = res.get(i);
            nres[i][0] = cur[0];
            nres[i][1] = cur[1];
        }
        return nres;
    }
}
