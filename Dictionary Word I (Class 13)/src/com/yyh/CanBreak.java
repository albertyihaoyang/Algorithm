package com.yyh;
// Given a word and a dictionary, 
// determine if it can be composed by concatenating words from the given dictionary.
import java.util.*;
public class CanBreak {

	public static void main(String[] args) {
		CanBreak my = new CanBreak();
		String input = "robcatbob";
		String[] dict = new String[]{"rob", "cat", "bob"};
		System.out.println(my.canBreak(input, dict));
		input = "robob";
		System.out.println(my.canBreak(input, dict));
	}

	public boolean canBreak(String input, String[] dict) {
	    Set<String> set = new HashSet<>();
	    for (String s : dict){
	    	set.add(s);
	    }
	    boolean[] result = new boolean[input.length() + 1];
	    for (int i = 1; i <= input.length(); i++){
	    	if (set.contains(input.substring(0, i))){
	    		result[i] = true;
	    		continue;
	    	}
	    	for (int j = i; j >= 0; j--){
	    		if (result[j] && set.contains(input.substring(j, i))){
	    			result[i] = true;
	    			break;
	    		}
	    	}
	    }
	    return result[result.length - 1];
	}
}
