package com.yyh;

import java.util.Arrays;

// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?
public class RemoveDuplicates {

	public static void main(String[] args) {
		RemoveDuplicates my = new RemoveDuplicates();
		int[] nums = new int[]{1,1,1,2,2};
		System.out.println(my.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

	public int removeDuplicates(int[] nums) {
        if (nums.length <= 1){
        	return nums.length;
        }
        int slow = 1;
        int fast = 1;
        int counter = 1;
        while (fast < nums.length){
        	if (nums[fast] != nums[slow - 1]){
        		nums[slow++] = nums[fast++];
        		counter = 1;
        	} else if (counter < 2){
        		nums[slow++] = nums[fast++];
        		counter++;
        	} else {
        		fast++;
        	}
        }
        return slow;
    }
}
