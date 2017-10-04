package com.yyh;
/*
 * You are given n pairs of numbers. In every pair, the first number is always smaller 
 * than the second number.
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. 
 * Chain of pairs can be formed in this fashion.
 * Given a set of pairs, find the length longest chain which can be formed. 
 * You needn't use up all the given pairs. You can select pairs in any order.
 */
public class FindLongestChain {

	public static void main(String[] args) {
		FindLongestChain my = new FindLongestChain();
		System.out.println(my.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
		
	}

	public int findLongestChain(int[][] pairs) {
        if (pairs.length <= 1){
        	return pairs.length;
        }
        int[][] chain = new int[pairs.length][2];
        int max = 0;
        chain[0] = pairs[0];
        for (int i = 1; i < pairs.length; i++){
        	int curMax = 1;
        	for (int j = 0; j < i; j++){
        		if (chain[j][0] < pairs[i][0] && chain[j][1] >= curMax){
        			curMax = chain[j][1] + 1;
        		}
        	}
        	chain[i][0] = pairs[i][1];
        	chain[i][1] = curMax;
        	max = Math.max(max, curMax);
        }
        return max;
    }
}
