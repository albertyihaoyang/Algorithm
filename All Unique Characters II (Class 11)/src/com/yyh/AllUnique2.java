package com.yyh;
import java.util.*;

// Determine if the characters of a given string are all unique.

public class AllUnique2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllUnique2 my = new AllUnique2();
		System.out.println(my.allUnique("abA+8"));
		System.out.println(my.allUnique("abA+a8"));
	}

	public boolean allUnique(String word) {
	    Set<Character> set = new HashSet<>();
	    for (int i = 0; i < word.length(); i++){
	    	if (set.contains(word.charAt(i))){
	    		return false;
	    	}
	    	set.add(word.charAt(i));
	    }
	    return true;
	 }
}
