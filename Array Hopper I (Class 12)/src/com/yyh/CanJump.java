package com.yyh;
/*
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array. 
 * A[i] means the maximum jump distance from that position (you can only jump towards the end of 
 * the array). Determine if you are able to reach the last index.
 */

public class CanJump {

	public static void main(String[] args) {
		CanJump my = new CanJump();
		System.out.println(my.canJump(new int[]{1, 3, 2, 0, 3}));
		System.out.println(my.canJump(new int[]{2, 1, 1, 0, 2}));
	}

	public boolean canJump(int[] array) {
	    if (array.length <= 1){
	    	return true;
	    }
	    boolean[] arr = new boolean[array.length];
	    arr[arr.length - 1] = true;
	    for (int i = arr.length - 2; i >= 0; i--){
	    	for (int j = 0; j <= array[i]; j++){
	    		if (arr[i + j]){
	    			arr[i] = true;
	    			break;
	    		}
	    	}
	    }
	    return arr[0];
	 }
}
