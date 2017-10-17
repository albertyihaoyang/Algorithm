package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
// Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(my.findAnagrams(s, p).toString());
	}
	
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (s == null || p == null || s.length() < p.length() || p.length() == 0){
			return res;
		}
		for (int i = 0; i <= s.length() - p.length(); i++){
			if (isAnagram(s, p, i)){
				res.add(i);
			}
		}
		return res;
	}
	
	private boolean isAnagram(String s, String p, int index) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < p.length(); i++){
			Integer cur = map.get(s.charAt(i + index));
			if (cur == null){
				map.put(s.charAt(i + index), 1);
			} else {
				map.put(s.charAt(i + index), cur + 1);
			}
		}
		for (int i = 0; i < p.length(); i++){
			Integer cur = map.get(p.charAt(i));
			if (cur == null || cur == 0){
				return false;
			} else {
				map.put(p.charAt(i), cur - 1);
			}
		}
		return true;
	}
}
