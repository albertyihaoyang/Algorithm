package com.yyh;

import java.util.List;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
//You may assume the dictionary does not contain duplicate words.
public class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0){
			return false;
		}
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++){
			if (wordDict.contains(s.substring(0, i))){
				dp[i] = true;
				continue;
			}
			for (int j = 1; j < i; j++){
				if (dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i] = true;
					continue;
				}
			}
		}
		return dp[s.length()];
	}
}
