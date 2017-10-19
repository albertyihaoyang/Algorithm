package com.yyh;
/*
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, 
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 * Substrings that occur multiple times are counted the number of times they occur.
 */
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		String s = "00110";
		System.out.println(my.countBinarySubstrings(s));
	}
	
	public int countBinarySubstrings(String s) {
		int res = 0;
		if (s.length() < 2){
			return res;
		}
		int slow = 0;
		int mid = 0;
		int fast = 0;
		while (fast < s.length() - 1){
			fast++;
			if (s.charAt(fast) != s.charAt(fast - 1)){
				res += Math.min(mid - slow, fast - mid);
				slow = mid;
				mid = fast;
			}
		}
		res += Math.min(mid - slow, s.length() - mid);
		return res;
	}
}
