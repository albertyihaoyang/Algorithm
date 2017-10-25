package com.yyh;

import java.util.ArrayList;
import java.util.List;

// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
// Find all strobogrammatic numbers that are of length = n.
public class Solution {
	public List<String> findStrobogrammatic(int n) {
		List<String> res = new ArrayList<>();
		if (n <= 0) return res;
		int[] arr = new int[n];
		if (n % 2 == 0) helperEven(arr, 0, res);
		else helperOdd(arr, 0, res);
		return res;
	}
	
	private void helperEven(int[] arr, int i, List<String> res){
		if (i == arr.length / 2){
			StringBuilder builder = new StringBuilder();
			for (int a : arr) {
			  builder.append(a);
			}
			res.add(builder.toString());
			return;
		}
		if (i != 0){
			arr[i] = 0;
			arr[arr.length - 1 - i] = 0;
			helperEven(arr, i + 1, res);
		}
		arr[i] = 1;
		arr[arr.length - 1 - i] = 1;
		helperEven(arr, i + 1, res);
		arr[i] = 8;
		arr[arr.length - 1 - i] = 8;
		helperEven(arr, i + 1, res);
		arr[i] = 6;
		arr[arr.length - 1 - i] = 9;
		helperEven(arr, i + 1, res);
		arr[i] = 9;
		arr[arr.length - 1 - i] = 6;
		helperEven(arr, i + 1, res);
	}
	
	private void helperOdd(int[] arr, int i, List<String> res){
		if (i == (arr.length - 1) / 2){
			arr[i] = 0;
			StringBuilder builder = new StringBuilder();
			for (int a : arr) {
			  builder.append(a);
			}
			res.add(builder.toString());
			arr[i] = 1;
			builder = new StringBuilder();
			for (int a : arr) {
			  builder.append(a);
			}
			res.add(builder.toString());
			arr[i] = 8;
			builder = new StringBuilder();
			for (int a : arr) {
			  builder.append(a);
			}
			res.add(builder.toString());
			return;
		}
		if (i != 0){
			arr[i] = 0;
			arr[arr.length - 1 - i] = 0;
			helperOdd(arr, i + 1, res);
		}
		arr[i] = 1;
		arr[arr.length - 1 - i] = 1;
		helperEven(arr, i + 1, res);
		arr[i] = 8;
		arr[arr.length - 1 - i] = 8;
		helperEven(arr, i + 1, res);
		arr[i] = 6;
		arr[arr.length - 1 - i] = 9;
		helperEven(arr, i + 1, res);
		arr[i] = 9;
		arr[arr.length - 1 - i] = 6;
		helperEven(arr, i + 1, res);
	}
}
