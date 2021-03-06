package com.yyh;
// Find the longest common substring of two given strings.
public class LongestCommon {
	public static void main(String[] args){
		String s = "abcde";
		String t = "abcfabcde";
		System.out.println(longestCommon(s, t));
	}
	public static String longestCommon(String s, String t) {
		if (s.length() == 0 || t.length() == 0){
			return "";
		}
		int sLen = s.length();
		int tLen = t.length();
		int[][] dp = new int[sLen][tLen];
		int max = 0;
		int right = 0;
		for (int i = 0; i < sLen; i++){
			for (int j = 0; j < tLen; j++){
				if (s.charAt(i) == t.charAt(j)){
					if (i == 0 || j == 0){
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
					if (dp[i][j] > max){
						max = dp[i][j];
						right = i;
					}
				}
			}
		}
		return s.substring(right - max + 1, right + 1);
	}
}
