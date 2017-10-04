package com.yyh;

import java.util.*;
/*
 * Given a string with possible duplicate characters, return a list with all permutations of the characters.
 */

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permutations("abc"));
	}
	
	public static List<String> permutations(String set) {
	    List<String> list = new ArrayList<>();
	    if (set == null){
	    	return list;
	    } else if (set.length() == 0) {
	    	list.add("");
	    	return list;
	    }
	    char[] charSet = set.toCharArray();
	    Set<String> stringSet = new HashSet<>();
	    char[] newChar = new char[charSet.length];
	    helper(charSet, 0, newChar, list, stringSet);
	    return list;
	 }
	
	public  static void helper(char[] charSet, int index, char[] newChar, List<String> list, Set<String> stringSet){
		if (index == charSet.length - 1){
			newChar[index] = charSet[index];
			String newString = new String(newChar, 0, newChar.length);
			if (!stringSet.contains(newString)) {
				list.add(newString);
				stringSet.add(newString);
			}
			return;
		}
		for (int i = index; i < charSet.length; i++){
			swap(charSet, index, i);
			newChar[index] = charSet[index];
			helper(charSet, index + 1, newChar, list, stringSet);
			swap(charSet, index, i);
		}
			
	}
	
	public static void swap(char[] set, int a, int b){
		char temp = set[a];
		set[a] = set[b];
		set[b] = temp;
	}
}
