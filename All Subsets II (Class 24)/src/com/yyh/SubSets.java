package com.yyh;
import java.util.ArrayList;
import java.util.Arrays;
// Given a set of characters represented by a String, return a list containing all subsets of the characters.
import java.util.List;

public class SubSets {
	// Method 1: DFS I
	public List<String> subSets(String set) {
		List<String> res = new ArrayList<String>();
		if (set == null){
			return res;
		}
		char[] arraySet = set.toCharArray();
		// Make sure the multi-set is sorted that we can dedup
		Arrays.sort(arraySet);
		StringBuilder sb = new StringBuilder();
		helper(arraySet, sb, 0, res);
		return res;
	}
	
	// index: at current level, determine if the element at "index" should be included in the subset or not
	private void helper(char[] set, StringBuilder sb, int index, List<String> result){
		if (index == set.length){
			result.add(sb.toString());
			return;
		}
		helper(set, sb.append(set[index]), index + 1, result);
		sb.deleteCharAt(sb.length() - 1);
		// skip all the consecutive and duplicate elements.
		while (index < set.length - 1 && set[index] == set[index + 1]){
			index++;
		}
		helper(set, sb, index + 1, result);
	}
}
