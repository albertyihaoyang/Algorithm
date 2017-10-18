package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to find the number of connected components in an undirected graph.
 */
public class Solution {
	public int countComponents(int n, int[][] edges) {
		if (n < 1){
			return 0;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] edge : edges){
			List<Integer> cur = map.get(edge[0]);
			if (cur == null){
				cur = new ArrayList<Integer>();
			}
			cur.add(edge[1]);
			map.put(edge[0], cur);
			cur = map.get(edge[1]);
			if (cur == null){
				cur = new ArrayList<Integer>();
			}
			cur.add(edge[0]);
			map.put(edge[1], cur);
		}
		boolean[] visited = new boolean[n];
		int res = 0;
		for (int i = 0; i < n; i++){
			if (visited[i]) continue;
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);
			while (!queue.isEmpty()){
				int cur = queue.poll();
				visited[cur] = true;
				List<Integer> neis = map.get(cur);
				if (neis == null) continue;
				for (int nei : neis){
					if (visited[nei]) continue;
					queue.offer(nei);
				}
			}
			res++;
		}
		return res;
	}
}
