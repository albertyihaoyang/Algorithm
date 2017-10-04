package com.yyh;
import java.util.*;
/*
 * Given an array of size n, find the majority element. The majority element is the element 
 * 	that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

	public static void main(String[] args) {
		MajorityElement my = new MajorityElement();
		int[] nums = new int[] {1};
		System.out.println(my.majorityElement(nums));
	}

	public int majorityElement(int[] nums) {
		if (nums.length == 1){
			return nums[0];
		}
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums){
            Integer cur = map.get(i);
            if (cur == null){
            	map.put(i, 1);
            } else if (cur + 1 > nums.length / 2){
            	return i;
            } else {
            	map.put(i, cur + 1);
            }
        }
        return 0;
    }
}
