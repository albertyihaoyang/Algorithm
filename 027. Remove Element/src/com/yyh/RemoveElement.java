package com.yyh;

import java.util.Arrays;

public class RemoveElement {

	public static void main(String[] args) {
		int[] arr = new int[]{3, 2, 2, 3};
		System.out.println(Arrays.toString(arr));
		int i = removeElement(arr, 3);
		System.out.println(Arrays.toString(arr));
		System.out.println(i);

	}

	public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (j < nums.length){
        	if (nums[j] != val){
        		nums[i] = nums[j];
        		i++;
        	}
        	j++;
        }
        return i;
    }
}
