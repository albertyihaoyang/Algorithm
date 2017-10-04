package com.yyh;
import java.util.*;
public class FindKSmallestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindKSmallestSum mySol = new FindKSmallestSum();
		int[] a = new int[]{1, 3, 5};
		int[] b = new int[]{6, 7, 8};
		System.out.println(Arrays.toString(mySol.kSmallestBF(a, b, 5)));
		System.out.println(Arrays.toString(mySol.kSmallestHeap(a, b, 5)));
	}

	// Assumption: k < a.length * b.length
		// Return the k-smallest sum s with an sorted array
		
	// Time complexity: O(k^2*lgk) Space complexity: O(k) for heap and O(k) for result;
	public int[] kSmallestBF(int[] a, int[] b, int k){
		int[] result = new int[k];
		if (k == 0) {
			return result;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		// Counter to record whether heap is full
		for (int i = 0; i < Math.min(a.length, k); i++){
			for (int j = 0; j < Math.min(b.length, k); j++) {
				int sum = a[i] + b[j];
				if (maxHeap.size() < k){
					maxHeap.offer(sum);
				} else if (sum < maxHeap.peek()){
					maxHeap.poll();
					maxHeap.offer(sum);
				}
			}
		}
		for (int i = k - 1; i >=0; i--){
			result[i] = maxHeap.poll();
		}
		return result;
	}
	
	// Using BFS2 with a 2D matrix collecting the sum of 2 arrays
	// Time complexity: O(klgk)/ Space complexity: O(k)
	public int[] kSmallestHeap(int[] a, int[] b, int k){
		int[] result = new int[k];
		if (k == 0 || a.length == 0 || b.length == 0) {
			return result;
		}
		// BFS2, need a minheap on the value of each cells
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>(){
			@Override
			public int compare(Cell c1, Cell c2){
				if (c1.sum == c2.sum){
					return 0;
				}
				return c1.sum < c2.sum ? -1: 1;
			}
		});
		// all the generated cells will be marked true,
		// to avoid being generated more than once
		boolean visited[][] = new boolean[a.length][b.length];
		minHeap.offer(new Cell(0, 0, a[0] + b[0]));
		// iterate k rounds, and BFS2 the smallest k cells
		for (int i = 0; i < k; i++){
			Cell cur = minHeap.poll();
			// the neighbor cell will be inserted back to the minheap only if
			// 1. it is not out of boundary.
			// 2. it has not been generated before.
			// Before for each cell it could be generated twice
			if (cur.a + 1 < a.length && !visited[cur.a + 1][cur.b]){
				minHeap.offer(new Cell(cur.a + 1, cur.b, a[cur.a + 1] + b[cur.b]));
				visited[cur.a + 1][cur.b] = true;
			}
			if (cur.b + 1< b.length && !visited[cur.a][cur.b + 1]){
				minHeap.offer(new Cell(cur.a, cur.b + 1, a[cur.a] + b[cur.b + 1]));
				visited[cur.a][cur.b + 1] = true;
			}
			result[i] = cur.sum;
		}
		return result;
	}
	
	private class Cell{
		int a;
		int b;
		int sum;
		public Cell(int a, int b, int sum){
			this.a = a;
			this.b = b;
			this.sum = sum;
		}
	}
}
