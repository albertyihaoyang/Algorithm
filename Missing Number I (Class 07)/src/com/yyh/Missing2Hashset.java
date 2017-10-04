package com.yyh;

import java.util.HashSet;

public class Missing2Hashset {
	public static void main(String[] args){
		System.out.println(missing(new int[0]));
		System.out.println(missing(new int[]{1, 4, 2}));
		System.out.println(missing(new int[]{1, 2, 3}));
	}
	public static int missing(int[] array) {
		int n = array.length + 1;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int number : array){
			set.add(number);
		}
		for (int i = 1; i < n; i++) {
			if (!set.contains(i)){
				return i;
			}
		}
		return n;
	}	
}
