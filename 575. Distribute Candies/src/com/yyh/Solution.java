package com.yyh;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies. 
 * Each number means one candy of the corresponding kind. 
 * You need to distribute these candies equally in number to brother and sister. 
 * Return the maximum number of kinds of candies the sister could gain.
 */
public class Solution {
	public int distributeCandies(int[] candies) {
		int kind = 0;
		int max = candies.length / 2;
		Set<Integer> set = new HashSet<>();
		for (int c : candies){
			if (!set.contains(c)){
				kind++;
				set.add(c);
				if (kind >= max){
					return max;
				}
			}
		}
		return kind;
	}
}
