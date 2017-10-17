package com.yyh;
/*
 * Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 */
public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int i = 0; int j = numbers.length - 1;
		int[] res = new int[2];
		while (i < j){
			if (numbers[i] + numbers[j] == target){
				res[0] = i + 1; res[1] = j + 1;
				return res;
			} else if (numbers[i] + numbers[j] < target){
				i++;
			} else {
				j--;
			}
		}
		return res;
	}
}
