package com.yyh;

import java.util.HashMap;
import java.util.Map;
// Given a string which consists of lowercase or uppercase letters,
// find the length of the longest palindromes that can be built with those letters.
public class Solution {
	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		boolean odd = false;
		for (char ch : s.toCharArray()){
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int res = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()){
			int val = entry.getValue();
			if (val % 2 != 0){
				odd = true;
			}
			res += val / 2;
		}
		return odd ? res * 2 + 1 : res * 2;
	}
}
