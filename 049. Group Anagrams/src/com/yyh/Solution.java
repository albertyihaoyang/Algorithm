package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given an array of strings, group anagrams together.
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(my.groupAnagrams(strs).toString());
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs == null || strs.length == 0){
			return res;
		}
		Map<Character, Integer>[] maps = new Map[strs.length];
		boolean[] visited = new boolean[strs.length];
		for (int k = 0; k < strs.length; k++){
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < strs[k].length(); i++){
				Integer count = map.get(strs[k].charAt(i));
				if (count == null){
					map.put(strs[k].charAt(i), 1);
				} else {
					map.put(strs[k].charAt(i), count + 1);
				}
			}
			maps[k] = map;
		}
		for (int i = 0; i < strs.length; i++){
			if (visited[i]){
				continue;
			}
			List<String> cur = new ArrayList<>();
			cur.add(strs[i]);
			visited[i] = true;
			for (int j = i + 1; j < strs.length; j++){
				if (visited[j]){
					continue;
				}
				if (maps[i].equals(maps[j])){
					cur.add(strs[j]);
					visited[j] = true;
				}
			}
			res.add(cur);
		}
		return res;
	}
}
