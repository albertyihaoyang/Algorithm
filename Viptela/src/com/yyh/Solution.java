package com.yyh;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args){
		System.out.println(largestComb(new String[]{"4", "40", "5", "6", "9", "98", "989"})); // test case
		System.out.println(largestComb(new String[]{"4", "4", "5"}));
		System.out.println(largestComb(new String[]{"4", "4000001"}));
		System.out.println(largestComb(new String[]{"1"})); // corner case
		System.out.println(largestComb(new String[]{}));
	}
	
	public static String largestComb(String[] nums){
		if (nums.length == 0) return "0";
		if (nums.length == 1) return nums[0];
		Arrays.sort(nums, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2){
				if (s1.equals(s2)) return 0;
				String s1s2 = s1 + s2;
				String s2s1 = s2 + s1;
				for (int i = 0; i < s1s2.length(); i++){
					if (s1s2.charAt(i) > (s2s1.charAt(i))) return -1;
					else if (s1s2.charAt(i) < (s2s1.charAt(i))) return 1;
				}
				return 0;
			}
		}); // Time complexity: O(m * nlgn) 
		// m: average length of String
		// n: length of array
		
		StringBuilder sb = new StringBuilder();
		for (String s: nums){
			sb.append(s);
		}
		
		return sb.toString();
	}
}
