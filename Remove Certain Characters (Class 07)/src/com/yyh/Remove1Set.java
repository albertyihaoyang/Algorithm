package com.yyh;

import java.util.HashSet;
import java.util.Set;

/*
 * Remove1Set given characters in input string, the relative order 
 * of other characters should be remained. Return the new string after deletion.
 * 
 * Assumptions
 * 	The given input string is not null.
 * 	The characters to be removed is given by another string, it is guranteed to be not null.
 */
public class Remove1Set {

	public static void main(String[] args) {
		System.out.println(remove("abcd","ab"));

	}

	public static String remove(String input, String t) {
	    // We need to know how to solve this problem with inplace way.
		// Usually we can convert the immutable String to char[]
	    char[] array = input.toCharArray();
	    // Get set of all distinct characters in t so that lookup
	    // operation will be efficient
	    Set<Character> set = buildSet(t);
	    // slow: [0, slow) contains the valid result
	    // fast: [fast, array.length) is the area to explore.
	    int slow = 0;
	    for (int fast = 0; fast < array.length; fast++){
	    	// the exploring character can only be put into valid area
	    	// if it is not in the set.
	    	if (!set.contains(array[fast])){
	    		array[slow++] = array[fast];
	    	}
	    }
	    return new String(array, 0, slow);
	 }
	
	private static Set<Character> buildSet(String t){
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < t.length(); i++) {
			set.add(t.charAt(i));
		}
		return set;
	}
}
