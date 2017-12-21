package com.yyh;
/*
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully 
 * if one of the following is true for the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?
 */
public class Solution {
	int res = 0;

	public int countArrangement(int N) {
		int[] arr = new int[N];
		for (int i = 0; i < N; i++){
			arr[i] = i + 1;
		}
		helper(arr, 0);
		return res;
	}

	private void helper(int[]arr, int ind){
		if (ind == arr.length - 1){
			if ((arr[ind] % (ind + 1) == 0) || ((ind + 1) % arr[ind] == 0)){
				res++;
			}
		}
		for (int i = ind; i < arr.length; i++){
			swap(arr, ind, i);
			if ((arr[ind] % (ind + 1) == 0) || ((ind + 1) % arr[ind] == 0)){
				helper(arr, ind + 1);
			}
			swap(arr, ind, i);
		}
	}

	private void swap(int[] arr, int a, int b){
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
