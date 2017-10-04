package com.yyh;

import java.util.*;

/*
 * Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.
 * Assumptions
 * 	s is not null or empty
 * 	l is not null.
 */

public class AllAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allAnagrams("aab", "ababacbbaac"));
	}
	
	public static List<Integer> allAnagrams(String s, String l){
		List<Integer> list = new ArrayList<>();
		if (l.length() < s.length()) {
			return list;
		}
		char[] lSet = l.toCharArray();
		char[] sSet = s.toCharArray();
		list.addAll(allAnagrams(lSet, sSet));
		return list;
	}

	
	public static List<Integer> allAnagrams(char[] lSet, char[] sSet){
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= lSet.length - sSet.length; i++){
			Map<Character, Integer> map = new HashMap<>();
			for (int j = 0; j < sSet.length; j++){
				Integer val = map.get(sSet[j]);
				if (val == null) {
					map.put(sSet[j], 1);
				} else {
					map.put(sSet[j], val+1);
				}
			}
			for (int j = 0; j < sSet.length; j++){
				Integer val = map.get(lSet[i + j]);
				if (val == null) {
					break;
				} else if (val == 1){
					map.remove(lSet[i + j]);
				} else {
					map.put(lSet[i + j], val - 1);	
				}
			}
			if (map.isEmpty()) {
				list.add(i);
			}
		}
		return list;
	}
}
