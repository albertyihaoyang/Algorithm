package com.yyh;
// Given an integer array of length L, find the number that occurs more than 0.5 * L times.
public class MajorityNumberI {
	public int majority(int[] array) {
		int can = array[0];
		int count = 1;
		for (int i = 1; i < array.length; i++){
			if (count == 0){
				can = array[i];
				count++;
			} else if (can == array[i]){
				count++;
			} else {
				count--;
			}
		}
		return can;
	}
}
