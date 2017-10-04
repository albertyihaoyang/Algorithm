package com.yyh;
/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Write a function to determine if a given target is in the array.
 * The array may contain duplicates.
 */
public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
        	if (nums[i] == target){
        		return true;
        	}
        }
        return false;
    }

}
