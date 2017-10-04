package com.yyh;

public class Missing3Sum {
	public static void main(String[] args){
		System.out.println(missing(new int[0]));
		System.out.println(missing(new int[]{1, 4, 2}));
		System.out.println(missing(new int[]{1, 2, 3}));
	}
	public static int missing(int[] array) {
		int sum = (array.length + 1) * (array.length + 2) / 2;
		for (int i : array){
			sum -= i;
		}
		return sum;
	}
}
