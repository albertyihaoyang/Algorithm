package com.yyh;

public class Solution {
	
	public static void main(String[] args){
		Solution my = new Solution();
		String s = "ab";
		String p = "eidbaooo";
		System.out.println(my.checkInclusion(s, p));
	}
	
	public boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() > s2.length() || s1.length() == 0){
			return false;
		}
		int count = s1.length();
		int[] arr = new int[26];
		for (char c : s1.toCharArray()){
			arr[c - 'a']++;
		}
		int start = 0; int end = 0;
		while (end < s2.length()){
			if (end - start == s1.length() && arr[s2.charAt(start++) - 'a'] ++ >= 0){
				count++;
			}
			if (--arr[s2.charAt(end++) - 'a'] >= 0){
				count--;
			}
			if (count == 0){
				return true;
			}
		}
		return false;
	}
}
