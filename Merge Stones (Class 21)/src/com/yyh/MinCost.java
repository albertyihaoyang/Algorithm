package com.yyh;
/*
 * We have a list of piles of stones, each pile of stones has a certain weight, represented by an array of integers. 
 * In each move, we can merge two adjacent piles into one larger pile, the cost is the sum of the weights of the two piles. 
 * We merge the piles of stones until we have only one pile left. Determine the minimum total cost.
 */
public class MinCost {
	public int minCost(int[] stones) {
		// Assumptions: stones is not null, stones.length >= 1.
		// This problem is actually the same one with Cutting Wood I
		// Only difference is for each partition(i,j), we need to
		// comput the length
		int len = stones.length;
		int[][] cost = new int[len][len];
		// subSum[i][j]: the length of partition(i,j).
		int[][] subSum = new int[len][len];
		for (int i = 0; i < len; i++){
			for (int j = i; j >= 0; j--){
				if (i == j){
					cost[j][i] = 0;
					subSum[j][i] = stones[i];
				} else {
					subSum[j][i] = subSum[j][i - 1] + stones[i];
					cost[j][i] = Integer.MAX_VALUE;
					for (int k = j; k < i; k++){
						cost[j][i] = Math.min(cost[j][i], cost[j][k] + cost[k + 1][i] + subSum[j][i]);
					}
				}
			}
		}
		return cost[0][len - 1];
	}
}
