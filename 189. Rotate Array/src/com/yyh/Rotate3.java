package com.yyh;

import java.util.*;

public class Rotate3 {
	
	public static void main(String[] args){
		Rotate3 my = new Rotate3();
		int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(nums));
		my.rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}
	
	public void rotate(int[] nums, int k) {
        if (nums.length <= 1){
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        int idx = k % nums.length;
        for (int i = 0; i < nums.length; i++){
        	queue.offer(nums[(i + nums.length - idx) % nums.length]);
        }
        for (int i = 0; i < nums.length; i++){
        	nums[i] = queue.poll();
        }
    }
    
}
