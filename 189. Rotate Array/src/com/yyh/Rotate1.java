package com.yyh;

import java.util.Arrays;

public class Rotate1 {
	
	public static void main(String[] args){
		Rotate1 my = new Rotate1();
		int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(nums));
		my.rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}
	
	public void rotate(int[] nums, int k) {
        if (nums.length <= 1){
            return;
        }
        int idx = k % nums.length;
        if (idx == 0){
            return;
        }
        reverse(nums, 0, nums.length - idx - 1 );
        reverse(nums, nums.length - idx, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int left, int right){
        while (left < right){
            swap(nums, left++, right--);
        }
    }
    
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
