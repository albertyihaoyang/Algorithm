package com.yyh;

import java.util.Arrays;

public class Rotate2 {
	
	public static void main(String[] args){
		Rotate2 my = new Rotate2();
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
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
        	result[(i + idx) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++){
        	nums[i] = result[i];
        }
    }
    
}
