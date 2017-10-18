package com.yyh;

import java.util.HashMap;
import java.util.Map;

// Given a string, determine if a permutation of the string could form a palindrome.
public class Solution {
	public boolean canPermutePalindrome(String s) {
		if (s.length() <= 1){
			return true;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()){
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		boolean flag = false;
		for (Map.Entry<Character, Integer> entry : map.entrySet()){
			if (entry.getValue() % 2 != 0){
				if (flag) return false;
				else flag = true;
			} 
		}
		return true;
	}
}
