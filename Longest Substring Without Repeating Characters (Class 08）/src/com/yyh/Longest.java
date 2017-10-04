package com.yyh;

import java.util.*;

/*
 * Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.
 * For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
 */
public class Longest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longest("b"));
	}

	public static int longest(String input) {
	    Set<Character> set = new HashSet<>();
	    int slow = 0;
	    int max = 0;
	    for (int fast = 0; fast < input.length(); fast++){
	    	if (set.contains(input.charAt(fast))){
	    		while (input.charAt(slow) != input.charAt(fast)){
	    			set.remove(input.charAt(slow));
	    			slow++;
	    		}
	    		slow++;
	    	} else {
	    		set.add((input.charAt(fast)));
	    		if (fast - slow + 1 > max) {
	    			max = fast - slow + 1;
	    		}
	    	}
	    	
	    }
	    return max;
	}
}
