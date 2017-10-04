package com.yyh;

/*
 * Given a string with no duplicate characters, return a list with all permutations of the characters
 * Examples
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 * Set = "", all permutations are [""]
 * Set = null, all permutations are []
 */

import java.util.List;
import java.util.ArrayList;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String set = "abc";
		System.out.println(permutations(set));
	}
	
	public static List<String> permutations(String set) {
	    if (set == null){
	    	return new ArrayList<String>();
	    }
	    int setLen = set.length();
	    if (setLen == 0){
	    	List<String> empty = new ArrayList<String>();
	    	empty.add("");
	    	return empty;
	    }
	    char[] charSet = new char[set.length()];
	    for (int i = 0; i < setLen; i++){
	    	charSet[i] = set.charAt(i);
	    }
	    List<String> result = new ArrayList<String>();
	    permutations(charSet, 0, "", result);
	    return result;
	}
	
	public static void permutations(char[] set, int index, String cur, List<String> result){
		if (index == set.length - 1){
			cur = cur + Character.toString(set[index]);
			result.add(cur);
			return;
		}
		for (int i = index; i < set.length; i++){
			swap(set, index, i);
			cur = cur + Character.toString(set[index]);
			permutations(set, index + 1, cur, result);
			cur = cur.substring(0, cur.length() - 1);
			swap(set, index, i);
		}
	}
	
	public static void swap(char[] set, int a, int b){
		char temp = set[a];
		set[a] = set[b];
		set[b] = temp;
	}
	
}
