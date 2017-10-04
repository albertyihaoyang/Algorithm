package com.yyh;

import java.util.Arrays;

public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{5, 0, 1, 0, 3, 12};
		System.out.println(Arrays.toString(arr));
		moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length){
        	if (nums[j] != 0){
        		nums[i] = nums[j];
        		i++;
        	}
        	j++;
        }
        for (int k = i; k < nums.length; k++){
        	nums[k] = 0;
        }
    }

}
