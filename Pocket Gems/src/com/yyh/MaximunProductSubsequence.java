package com.yyh;

public class MaximunProductSubsequence {
	public int maxProduct(int[] nums) {
		int r = nums[0];
		for (int i = 1, imax = r, imin = r; i < nums.length; i++){
			if (nums[i] < 0){
				int tmp = imax;
				imax = imin;
				imin = tmp;
			}
			imax = Math.max(nums[i], nums[i] * imax);
			imin = Math.min(nums[i], nums[i] * imin);
			r = Math.max(r, imax);
		}
		return r;
	}
}
