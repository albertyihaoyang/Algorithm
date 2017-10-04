package com.yyh;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.
 *Assumptions
 *the matrix is not null, N > 0 and M > 0
 *K > 0 and K <= N * M
 */

public class Solution {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1, 3, 5, 7}, {2, 4, 8, 9}, {3, 5, 11, 15}, {6, 8, 13, 18}};
		System.out.println(kthSmallest(matrix, 5));
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		class minHeapComparator implements Comparator<Cell>{
			@Override
			public int compare(Cell c1, Cell c2){
				if (c1.value == c2.value){
					return 0;
				}
				return c1.value < c2.value ? -1: 1;
			}
		}
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new minHeapComparator());
		int rows = matrix.length;
		int cols = matrix[0].length;
		// all the generated cell will be marked true,
		// to avoid being generated more than once
		boolean[][] flag = new boolean[rows][cols];
		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		flag[0][0] = true;
		// iterate k-1 rounds, and Best First Search the smallest k-1 cells
		for (int i = 0; i < k - 1; i++){
			Cell cur = minHeap.poll();
			// the neighbor cell will be inserted back to the minheap only if
			// 1. it is not out of boundary
			// 2. it has not been generated before.
			// Because for each cell it could be generated twice.
			if (cur.row + 1 < rows && !flag[cur.row + 1][cur.col]){
				minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
				flag[cur.row + 1][cur.col] = true;
			}
			if (cur.col + 1 < cols && !flag[cur.row][cur.col + 1]){
				minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
				flag[cur.row][cur.col + 1] = true;
			}
		}
		return minHeap.peek().value;	
	}
	
	
	static class Cell {
		int row;
		int col;
		int value;
		Cell (int row, int col, int value){
			this.row = row;
			this.col = col;
			this.value = value;
		}
	}
}
