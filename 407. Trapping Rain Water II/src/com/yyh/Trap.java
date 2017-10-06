package com.yyh;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, 
// compute the volume of water it is able to trap after raining.
public class Trap {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int height;
		public Node(int x, int y, int height){
			this.x = x;
			this.y = y;
			this.height = height;
		}

		@Override
		public int compareTo(Node another){
			if (this.height == another.height){
				return 0;
			} 
			return this.height < another.height ? -1 : 1;
		}
	}

	public int trapRainWater(int[][] heightMap) {
		int res = 0;
		int rows = heightMap.length;
		if (rows == 0){
			return res;
		}
		int cols = heightMap[0].length;
		if (rows < 3 || cols < 3){
			return res;
		}
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		boolean[][] visited = new boolean[rows][cols];
		border(heightMap, minHeap, visited);
		while (!minHeap.isEmpty()){
			Node cur = minHeap.poll();
			List<Node> neis = getNeis(cur, heightMap);
			for (Node nei : neis){
				if (!visited[nei.x][nei.y]){
					res += Math.max(0, cur.height - nei.height);
					nei.height = Math.max(cur.height, nei.height);
					visited[nei.x][nei.y] = true;
					minHeap.offer(nei);
				}
			}
		}
		return res;
	}

	private void border(int[][] heightMap, PriorityQueue<Node> minHeap, boolean[][] visited){
		int rows = heightMap.length;
		int cols = heightMap[0].length;
		for (int j = 0; j < cols; j++){
			minHeap.offer(new Node(0, j, heightMap[0][j]));
			minHeap.offer(new Node(rows - 1, j, heightMap[rows - 1][j]));
			visited[0][j] = true;
			visited[rows - 1][j] = true;
		}
		for (int i = 1; i < rows - 1; i++){
			minHeap.offer(new Node(i, 0, heightMap[i][0]));
			minHeap.offer(new Node(i, cols - 1, heightMap[i][cols - 1]));
			visited[i][0] = true;
			visited[i][cols - 1] = true;
		}
	}

	private List<Node> getNeis(Node cur, int[][] matrix){
		List<Node> neis = new ArrayList<>();
		if (cur.x + 1 < matrix.length){
			neis.add(new Node(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
		}
		if (cur.x - 1 >= 0){
			neis.add(new Node(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
		}
		if (cur.y + 1 < matrix[0].length){
			neis.add(new Node(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
		}
		if (cur.y - 1 >= 0){
			neis.add(new Node(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
		}
		return neis;
	}
}
