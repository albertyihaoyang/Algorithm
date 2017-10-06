package com.yyh;
// Given n non-negative integers representing an elevation map where the width of each bar is 1, 
// compute how much water it is able to trap after raining.
public class Trap {
	public int trap(int[] height) {
		if (height.length == 0){
			return 0;
		}
		int res = 0;
		int left = 0;
		int right = height.length - 1;
		int lmax = height[left];
		int rmax = height[right];
		while (left < right){
			lmax = Math.max(lmax, height[left]);
			rmax = Math.max(rmax, height[right]);
			if (lmax < rmax){
				res += Math.max(0, lmax - height[left]);
				left++;
			} else {
				res += Math.max(0, rmax - height[right]);
				right--;
			}
		}
		return res;
	}
}
