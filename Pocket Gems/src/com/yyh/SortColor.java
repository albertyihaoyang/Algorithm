package com.yyh;

public class SortColor {
	public void sortColors(int[] nums) {
		int i = 0, j = 0, k = nums.length - 1;
		while (j <= k){
			if (nums[j] == 0){
				swap(nums, i++, j++);
			} else if (nums[j] == 1){
				j++;
			} else {
				swap(nums, j, k--);
			}
		}
	}
	
	private void swap(int[] nums, int a, int b){
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
