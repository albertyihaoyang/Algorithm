package com.yyh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents
 * 
 * Arguments
 * 	coins - an array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
 * 	target - a non-negative integer representing the target number of cents, eg. 99
 * Assumptions
 * 	coins is not null and is not empty, all the numbers in coins are positive
 * 	target >= 0
 * 	You have infinite number of coins for each of the denominations, you can pick any number of the coins.
 * Return
 * 	a list of ways of combinations of coins to sum up to be target.
 * 	each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.
 * Examples
 * 	coins = {2, 1}, target = 4, the return should be
 * 	[
 * 	 [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
 * 	 [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
 * 	 [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
 * 	]
 */

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinations(4, new int[]{2,1}));
	}
	
	public static List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> solution = new ArrayList<Integer>();
		combinations(target, coins, 0, solution, result);
		return result;
	}
	
	private static void combinations(int target, int[] coins, int index, List<Integer> solution, List<List<Integer>> result){
		if (index == coins.length - 1){
			if (target % coins[index] == 0){
				solution.add(target / coins[index]);
				result.add(new ArrayList<Integer>(solution));
				solution.remove(solution.size() - 1);
			}
			return;
		}
		for (int i = 0; i <= target / coins[index]; i++){
			solution.add(i);
			combinations(target - i * coins[index], coins, index + 1, solution, result);
			solution.remove(solution.size() - 1);
		}
	}
}
