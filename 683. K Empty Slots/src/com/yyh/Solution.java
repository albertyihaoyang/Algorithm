package com.yyh;
/*
 * There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. 
 * In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.
 * Given an array flowers consists of number from 1 to N. 
 * Each number in the array represents the place where the flower will open in that day.
 * For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, 
 * where i and x will be in the range from 1 to N.
 * Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, 
 * and also the number of flowers between them is k and these flowers are not blooming.
 * If there isn't such day, output -1.
 */
public class Solution {
	// Time: O(n)
	// Space: O(n)
	public int kEmptySlots(int[] flowers, int k) {
		int[] bloom =  new int[flowers.length];
		for(int i = 0; i < flowers.length; i++){
			bloom[flowers[i] - 1] = i + 1;
		}
		int left = 0;
		int right = k + 1; // Slot of size k
		int res = Integer.MAX_VALUE;
		for(int i = 0; right < bloom.length; i++){ // linear scan O(n)
			if(bloom[i] < bloom[left] || bloom[i] <= bloom[right]){
				if(i == right){
					res = Math.min(res, Math.max(bloom[left], bloom[right]));
				}
				left = i; 
				right = k + 1 + i;
			}
		}
		return (res == Integer.MAX_VALUE)? -1 : res;
	}
}
