package com.yyh;
// Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
public class Solution {
	public boolean hasAlternatingBits(int n) {
		int k = 0;
		for (int i = 0; i < 33; i++){
			if (i % 2 == 0){
				k = k * 2;
			} else {
				k = k * 2 + 1;
			}
			if (k == n){
				return true;
			} else if (k > n){
				break;
			}
		}
		return false;
	}
}
