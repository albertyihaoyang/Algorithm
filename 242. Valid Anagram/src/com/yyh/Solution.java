package com.yyh;

import java.util.HashMap;
import java.util.Map;

// Given two strings s and t, write a function to determine if t is an anagram of s.
public class Solution {
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length()){
			return false;
		}
		if (s.length() == 0) return true;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++){
			Integer cur = map.get(s.charAt(i));
			if (cur == null){
				map.put(s.charAt(i), 1);
			} else {
				map.put(s.charAt(i), cur + 1);
			}
		}
		for (int i = 0; i < t.length(); i++){
			Integer cur = map.get(t.charAt(i));
			if (cur == null || cur == 0){
				return false;
			} else {
				map.put(t.charAt(i), cur - 1);
			}
		}
		return true;
	}
}
