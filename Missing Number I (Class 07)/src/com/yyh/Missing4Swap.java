package com.yyh;

public class Missing4Swap {
	public static void main(String[] args){
		System.out.println(missing(new int[0]));
		System.out.println(missing(new int[]{1, 4, 2}));
		System.out.println(missing(new int[]{1, 2, 3}));
	}
	
	public static int missing(int[] array) {
		for (int i = 0; i < array.length; i++){
			while (array[i] != i + 1 && array[i] != array.length + 1) {
				swap(array, i, array[i] - 1);
			}
		}
		for (int i = 0; i< array.length; i++){
			if (array[i] != i + 1){
				return i + 1;
			}
		}
		return array.length + 1;
	}
	
	public static void swap (int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
