package com.yyh;
/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */

public class MaxArea {
	public static void main(String[] args){
		MaxArea my = new MaxArea();
		int[] array = new int[]{3, 1, 2, 3};
		System.out.println(my.maxAreaII(array));
	}
	// O(n^2)
	public int maxArea(int[] array) {
		int result = 0;
		for (int i = 1; i < array.length; i++){
			for (int j = 0; j < i; j++){
				result = Math.max(Math.min(array[i], array[j]) * (i - j), result);
			}
		}
		return result;
	}
	
	public int maxAreaII(int[] array){
		int res = 0;
		int left = 0;
		int right = array.length - 1;
		while (left < right){
			res = Math.max(Math.min(array[left], array[right]) * (right - left), res);
			if (array[left] < array[right]){
				left++;
			} else {
				right--;
			}
		}
		return res;
	}
	
}
